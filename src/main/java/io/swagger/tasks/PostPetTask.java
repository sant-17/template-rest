package io.swagger.tasks;

import io.restassured.http.ContentType;
import io.swagger.models.PetDataModel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class PostPetTask implements Task {
    private final PetDataModel petDataModel;
    private final String endPoint;


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(endPoint).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .headers("accept", "application/json")
                                .body(petDataModel)
                                .log()
                                .all()
                )
        );
    }

    public static Performable withPetData(PetDataModel pet, String endPoint) {
        return instrumented(PostPetTask.class, pet, endPoint);
    }
}
