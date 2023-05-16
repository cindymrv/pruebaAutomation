package tasks.servicios;

import models.response.ResponseInformacionEmpleados;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.EnumVariablesSesion.VARIABLE_SESION_NOMBRE;

public class ConsultarUsuarioCreado implements Task {
    private final String recurso;

    public ConsultarUsuarioCreado(String recurso) {
        this.recurso = recurso;
    }

    public static ConsultarUsuarioCreado deLaApiSegunElId(String recurso) {
        return instrumented(ConsultarUsuarioCreado.class, recurso);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.rest().log().all().get(CallAnApi.as(actor).resolve(recurso));
        if (SerenityRest.lastResponse().getStatusCode() == 404) {
            actor.remember(VARIABLE_SESION_NOMBRE.getVariableSesion(), "Null");
        } else {
            actor.remember(VARIABLE_SESION_NOMBRE.getVariableSesion(),
                    SerenityRest.lastResponse().getBody().as(ResponseInformacionEmpleados.class).getData().getFirstName());
        }

    }
}
