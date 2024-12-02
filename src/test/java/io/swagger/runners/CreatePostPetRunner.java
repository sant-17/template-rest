package io.swagger.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "io.swagger.stepDefinitions",
        tags = "@Post",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
@RunWith(CucumberWithSerenity.class)
public class CreatePostPetRunner {
}
