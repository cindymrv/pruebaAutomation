package questions.frontend;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static userinterface.IniciarSesion.LBL_TABLA_TRANSACCION;

public class PaginaTablaDeGastos implements Question<Boolean> {

    private final String tablaDeTransacciones;

    public PaginaTablaDeGastos(String tablaDeTransacciones) {
        this.tablaDeTransacciones = tablaDeTransacciones;
    }

    public static PaginaTablaDeGastos enPantallaPrincipal(String tablaDeTransacciones) {
        return new PaginaTablaDeGastos(tablaDeTransacciones);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return LBL_TABLA_TRANSACCION.resolveFor(actor).getText().contains(tablaDeTransacciones);
    }
}
