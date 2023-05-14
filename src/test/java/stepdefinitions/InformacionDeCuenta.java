package stepdefinitions;

import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import questions.frontend.LaCantidadDeTransacciones;

import static java.lang.Boolean.TRUE;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class InformacionDeCuenta {
    @Entonces("el usuario debe ver {int} transacciones en la tabla de gastos")
    public void verificarCantidadDeTransacciones(Integer cantidadDeTransacciones) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(LaCantidadDeTransacciones.enLaTablaDeGastos(cantidadDeTransacciones
                ),equalTo(TRUE)));
    }
}
