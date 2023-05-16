package stepdefinitions;

import exceptions.PruebaError;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import models.response.ResponseInsertarUsuario;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;



import questions.backend.ComprobarStatusCode;
import tasks.servicios.ConsultarEmpleados;
import tasks.servicios.InsertarUsuario;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static utils.EnumErrorMessage.MENSAJE_ERROR_PANORAMA_FINANCIERO;
import static utils.EnumErrorMessage.MENSAJE_ERROR_STATUS_CODE;
import static utils.EnumVariablesSesion.VARIABLE_SESION_ID;

public class ConsumoServicioStepDefinition {

    @Dado("que {string} realiza el consumo de la url base {string}")
    public void configurarInicioAutomatizacion(String nombreActor, String urlBase) {
        setTheStage(new OnlineCast());
        theActorCalled(nombreActor).whoCan(CallAnApi.at(urlBase));
    }

    @Cuando("inserte un usuario en la API con características")
    public void insertarUsuarioAPI(Map<String, String> mapCaracteristicasUsuario) {
        theActorInTheSpotlight()
                .attemptsTo(InsertarUsuario.conCaracteristicas(mapCaracteristicasUsuario));
        theActorInTheSpotlight().remember(VARIABLE_SESION_ID.getVariableSesion(), SerenityRest.lastResponse().getBody().as(ResponseInsertarUsuario.class).getId());
    }

    @Y("al consultar el id del empleado creado en el servicio")
    public void consultarUsuarioCreadoAPI() {
        String id= theActorInTheSpotlight().recall(VARIABLE_SESION_ID.getVariableSesion());
        theActorInTheSpotlight().attemptsTo(ConsultarEmpleados.deLaApiSegunRecurso("/users/"+id));
    }

    @Entonces("el servicio me debe responder con un status code {int}")
    public void verficarStatusCode(int statusCodeEsperado) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                ComprobarStatusCode.delResponseServicio(statusCodeEsperado),
                Matchers.equalTo(Boolean.TRUE)).orComplainWith(PruebaError.class, MENSAJE_ERROR_STATUS_CODE.getErrorMessage()));
    }
}
