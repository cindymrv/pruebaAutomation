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
import questions.backend.ValidarNombre;
import tasks.servicios.ActualizarUsuario;
import tasks.servicios.ConsultarUsuarioCreado;
import tasks.servicios.EliminarUsuarioCreado;
import tasks.servicios.InsertarUsuario;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static utils.EnumErrorMessage.MENSAJE_ERROR_NOMBRE_USUARIO;
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
        theActorInTheSpotlight().remember(VARIABLE_SESION_ID.getVariableSesion(),
                SerenityRest.lastResponse().getBody().as(ResponseInsertarUsuario.class).getId());
    }

    @Cuando("consulte un usuario no registrado en la API")
    public void consultarUsuariosNoRegistradosAPI() {
        theActorInTheSpotlight().attemptsTo(ConsultarUsuarioCreado.deLaApiSegunElId("/users/4521lo"));
    }

    @Cuando("elimine un usuario en la API con id {int}")
    public void elimnarUsuariosNoRegistradosAPI(Integer id) {
        theActorInTheSpotlight().attemptsTo(EliminarUsuarioCreado.deLaApiSegunElId("/users/" + id));
    }

    @Cuando("actualice un usuario en la API con características")
    public void actualizarUsuarioAPI(Map<String, String> mapCaracteristicasUsuario) {
        theActorInTheSpotlight()
                .attemptsTo(ActualizarUsuario.conCaracteristicas(mapCaracteristicasUsuario));
    }

    @Y("al consultar el id del empleado creado anteriormente")
    public void consultarUsuarioAPI() {
        String id = theActorInTheSpotlight().recall(VARIABLE_SESION_ID.getVariableSesion());
        theActorInTheSpotlight().attemptsTo(ConsultarUsuarioCreado.deLaApiSegunElId("/users/" + id));
    }

    @Entonces("se debe visualizar el nombre {string} del usuario insertado")
    public void validarUsuarioCreadoAPI(String nombre) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarNombre.delUsuarioCreado(nombre),
                Matchers.equalTo(Boolean.TRUE)).orComplainWith(PruebaError.class, MENSAJE_ERROR_NOMBRE_USUARIO.getErrorMessage()));
    }

    @Entonces("el servicio me debe responder con un status code {int}")
    public void verficarStatusCode(int statusCodeEsperado) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(
                ComprobarStatusCode.delResponseServicio(statusCodeEsperado),
                Matchers.equalTo(Boolean.TRUE)).orComplainWith(PruebaError.class, MENSAJE_ERROR_STATUS_CODE.getErrorMessage()));
    }
}
