package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import tasks.frontend.IniciarSesion;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static utils.RecursoFront.URL_APPLITOOLS;

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
    public void el_sistema_deberá_direccionarlo_a_la_página_de_de_la_tabla_de_gastos() {

    }


}
