package tasks.servicios;

import models.response.ResponseListaEmpleados;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;


import static io.restassured.RestAssured.sessionId;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarEmpleados implements Task {

    private final String recurso;

    public ConsultarEmpleados(String recurso) {
        this.recurso = recurso;
    }

    public static ConsultarEmpleados deLaApiSegunRecurso(String recurso) {
        return instrumented(ConsultarEmpleados.class,recurso);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.rest().log().all().get(CallAnApi.as(actor).resolve(recurso)).then().log().all();
        SerenityRest.lastResponse().as(ResponseListaEmpleados.class);
    }
}
