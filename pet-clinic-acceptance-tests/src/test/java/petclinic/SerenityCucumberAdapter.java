package petclinic;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
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
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("http://localhost:9966/petclinic/api");
    }

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }
}
