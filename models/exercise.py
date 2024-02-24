from __future__ import annotations

from typing import Optional

from sqlalchemy import String
from sqlalchemy.orm import mapped_column, Mapped, relationship

from models.base_model import BaseModel, Base

from models.exercise_step import ExerciseStep


class Exercise(Base):
    id: Mapped[int] = mapped_column(primary_key=True, name='exercise_id', sort_order=-10)
    name: Mapped[str] = mapped_column(String(length=30), nullable=False, sort_order=1)
    place_holder: Mapped[str] = mapped_column(String(100), nullable=True, sort_order=2)
    tool_tip: Mapped[str] = mapped_column(String(100), nullable=True, sort_order=3)
    image: str = mapped_column(String(100), nullable=True, sort_order=4)
    description: Mapped[str] = mapped_column(String(), nullable=True, sort_order=5)

    steps: Mapped[list['ExerciseStep']] = relationship(back_populates='exercise')


class ExerciseDTO(BaseModel):
    id: int | None
    name: str
    place_holder: Optional[str] = None
    tool_tip: Optional[str] = None
    image: Optional[str] = None
    description: Optional[str] = None


class ExerciseCreate(BaseModel):
    id: int | None
    name: str
    place_holder: Optional[str] = None
    tool_tip: Optional[str] = None
    image: Optional[str] = None
    description: Optional[str] = None