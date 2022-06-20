package petclinic;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import petclinic.screenplay.tasks.pets.PetTypeAPI;

public class SerenityCucumberAdapter {
    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;

    @Before
    public void setTheStage() {
        theRestApiBaseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("restapi.service.url");

        OnStage.setTheStage(
                OnlineCast.whereEveryoneCan(
                        CallAnApi.at(theRestApiBaseUrl)));
    }

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @After
    public void clearPetTypes() {
        PetTypeAPI.clearCreatedPetTypes();
    }

}


