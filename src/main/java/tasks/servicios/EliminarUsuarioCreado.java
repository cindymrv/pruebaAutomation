package tasks.servicios;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class EliminarUsuarioCreado implements Task {

    private final String recurso;

    public EliminarUsuarioCreado(String recurso) {
        this.recurso = recurso;
    }

    public static EliminarUsuarioCreado deLaApiSegunElId(String recurso) {
        return instrumented(EliminarUsuarioCreado.class, recurso);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.rest().log().all().delete(CallAnApi.as(actor).resolve(recurso)).then().log().all();
        actor.should(
                seeThatResponse(response -> response.log().all()));
    }
}
