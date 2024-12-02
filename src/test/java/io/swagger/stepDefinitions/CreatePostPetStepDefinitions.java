package io.swagger.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.swagger.models.PetDataModel;
import io.swagger.questions.ObjectPet;
import io.swagger.tasks.PostPetTask;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static io.swagger.constants.Constants.URL_Base;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CreatePostPetStepDefinitions {
    private static final String restAPIUrl = URL_Base;

    @When("I send a request to the endpoint {string} with the pet name {string} category {string} and status {string}")
    public void iSendARequestToTheEndpointWithThePetNameCategoryAndStatus(String ep, String name, String category, String status) {
        Actor user = Actor.named("user").whoCan(CallAnApi.at(restAPIUrl));
        ObjectPet objectPet = new ObjectPet(name, category, status);
        PetDataModel petDataModel = objectPet.answeredBy(null);

        System.out.println(petDataModel);

        user.attemptsTo(
                PostPetTask.withPetData(petDataModel, ep)
        );
    }
    @Then("I validate the response code is {string}")
    public void iValidateTheResponseCodeIs(String code) {
        Actor user = Actor.named("user");
        String codeRest = String.valueOf(SerenityRest.lastResponse().getStatusCode());

        user.should(
                seeThat("The response code is ", res -> codeRest,equalTo(code))
        );
    }
}
