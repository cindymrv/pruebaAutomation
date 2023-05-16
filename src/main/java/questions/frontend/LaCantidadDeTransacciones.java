package questions.frontend;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static userinterface.InformacionDeCuenta.TABLA_DE_TRANSACCIONES;


public class LaCantidadDeTransacciones implements Question<Boolean> {

    private final Integer cantidadDeTransacciones;
    public LaCantidadDeTransacciones(Integer cantidadDeTransacciones) {
        this.cantidadDeTransacciones = cantidadDeTransacciones;
    }

    public static LaCantidadDeTransacciones enLaTablaDeGastos(Integer cantidadDeTransacciones) {
        return new LaCantidadDeTransacciones(cantidadDeTransacciones);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<WebElement> filas = TABLA_DE_TRANSACCIONES.resolveFor(actor).findElements(By.tagName("tr"));
        return cantidadDeTransacciones.equals(filas.size()-1);
    }
}
