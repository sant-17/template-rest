package io.swagger.questions;

import io.swagger.models.PetDataModel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

@AllArgsConstructor
public class ObjectPet implements Question<PetDataModel> {
    private final String name;
    private final String category;
    private final String status;

    @Override
    public PetDataModel answeredBy(Actor actor) {
        PetDataModel pet = PetDataModel.builder()
                .id(0L)
                .category(PetDataModel.Category.builder()
                        .id(0L)
                        .name(category)
                        .build())
                .name(name)
                .photoUrls(List.of("string"))
                .tags(List.of(PetDataModel.Tags.builder()
                        .id(0L)
                        .name("string")
                        .build()))
                .status(status)
                .build();

        return pet;
    }
}
