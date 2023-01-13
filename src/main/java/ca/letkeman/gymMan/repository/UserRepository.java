package ca.letkeman.gymMan.repository;

import ca.letkeman.gymMan.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Long> {

}