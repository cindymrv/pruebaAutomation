package stepdefinitions;

import exceptions.PruebaError;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.frontend.PaginaTablaDeGastos;
import tasks.frontend.IniciarSesion;

import java.util.Map;

import static java.lang.Boolean.TRUE;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static utils.EnumErrorMessage.MENSAJE_ERROR_LOGIN;
import static utils.RecursoFront.*;

public class Login {

    @Dado("que el {string} se encuentra en la página web de Applitools")
    public void abrirPaginaWeb(String usuario) {
        setTheStage(new OnlineCast());
        theActorCalled(usuario).wasAbleTo(Open.url(URL_APPLITOOLS.getRecursoFront()));
    }

    @Cuando("ingrese el usuario y contraseña")
    public void iniciarSesion(Map<String, String> mapInformacionUsuario) {
        theActorInTheSpotlight()
                .attemptsTo(IniciarSesion.conUsuarioYContrasena(mapInformacionUsuario));
    }

    @Entonces("el sistema deberá direccionarlo a la página de de la tabla de gastos")
    public void verificarInicoSesionUsuario() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(PaginaTablaDeGastos.enPantallaPrincipal(
                TRANSACCIONES_RECIENTES.getRecursoFront()), equalTo(TRUE)).orComplainWith(PruebaError.class, MENSAJE_ERROR_LOGIN.getErrorMessage()));
    }

}
