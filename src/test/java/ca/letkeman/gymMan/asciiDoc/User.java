package ca.letkeman.gymMan.asciiDoc;

import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.halLinks;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.subsectionWithPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
public class User {

  @Autowired
  private WebApplicationContext context;

  private MockMvc mockMvc;

  @BeforeEach
  public void setUp(RestDocumentationContextProvider restDocumentation) {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
        .apply(documentationConfiguration(restDocumentation))
        .alwaysDo(document("{ClassName}/{methodName}"))
        .build();
  }

  @Test
  public void index() throws Exception {
    this.mockMvc.perform(get("/users")).andExpect(status().isOk())
        .andDo(print())
        .andDo(document("{ClassName}/{methodName}",
            links(
                halLinks(), // <- this shortens things a bit
                linkWithRel("self").ignored(),
//                linkWithRel("links").ignored(),
                //linkWithRel("profile").description("The ALPS profile for the service"))
                linkWithRel("profile").ignored()
            )
        ));

  }
  @Test
  public void single() throws Exception {
    this.mockMvc.perform(get("/users/1")).andExpect(status().isOk())
        .andDo(print())
        .andDo(document("{ClassName}/{methodName}",
            links(
                halLinks(), // <- this shortens things a bit
                linkWithRel("self").ignored(),
                linkWithRel("creator").ignored(),
                //linkWithRel("_links").ignored(),
                linkWithRel("user").ignored()
            )));
  }
}