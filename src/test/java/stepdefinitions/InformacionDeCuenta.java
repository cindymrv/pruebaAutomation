package stepdefinitions;

import exceptions.PruebaError;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import questions.frontend.EnLaPaginaDeBalance;
import questions.frontend.LaCantidadDeTransacciones;
import questions.frontend.LosValoresDeLasTransacciones;

import java.util.Map;

import static java.lang.Boolean.TRUE;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;
import static utils.EnumErrorMessage.*;

public class InformacionDeCuenta {
    @Entonces("el usuario debe ver {int} transacciones en la sección de transacciones recientes")
    public void verificarCantidadDeTransacciones(Integer cantidadDeTransacciones) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(LaCantidadDeTransacciones.enLaTablaDeGastos(cantidadDeTransacciones
        ), equalTo(TRUE)).orComplainWith(PruebaError.class,MENSAJE_ERROR_TRANSACCIONES_RECIENTES.getErrorMessage() ));
    }

    @Entonces("los valores positivos de las transacciones deben visualizarse en color verde y los valores negativos en color rojo")
    public void verificarColoresTransacciones() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(LosValoresDeLasTransacciones.tienenLosColoresCorrectos(), equalTo(TRUE)).orComplainWith(PruebaError.class, MENSAJE_ERROR_COLORES.getErrorMessage()));
    }

    @Entonces("el usuario debe ver en la sección de Panorama financiero el balance total y el valor del crédito disponible")
    public void verificarBalanceTotal(Map<String, String> mapInformacionPanoramaFinanciero) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(EnLaPaginaDeBalance.laInformacionDelPanoramaFinanciero(mapInformacionPanoramaFinanciero
        ), equalTo(TRUE)).orComplainWith(PruebaError.class, MENSAJE_ERROR_PANORAMA_FINANCIERO.getErrorMessage()));
    }
}
