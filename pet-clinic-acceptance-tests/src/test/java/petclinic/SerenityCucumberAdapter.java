package petclinic;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;


public class SerenityCucumberAdapter {
    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        theRestApiBaseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("restapi.service.url");
    }

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }
}
