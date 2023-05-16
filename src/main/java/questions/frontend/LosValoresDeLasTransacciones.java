package questions.frontend;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static userinterface.InformacionDeCuenta.TABLA_DE_TRANSACCIONES;

public class LosValoresDeLasTransacciones implements Question<Boolean> {

    private boolean esColorVerde = false;
    private boolean esColorRojo = false;

    public static LosValoresDeLasTransacciones tienenLosColoresCorrectos() {
        return new LosValoresDeLasTransacciones();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<WebElement> valoresTransacciones = TABLA_DE_TRANSACCIONES.resolveFor(actor).findElements(By.xpath("//td[contains(.,'USD')]"));
        for (WebElement valorTransaccion : valoresTransacciones) {
            if (valorTransaccion.getText().contains("+")) {
                validarColorVerde(valorTransaccion.findElement(By.className("text-success")));
            } else {
                validarColorRojo(valorTransaccion.findElement(By.className("text-danger")));
            }
        }
        return esColorRojo && esColorVerde;
    }

    private void validarColorRojo(WebElement valorNegativo) {
        if (valorNegativo.getCssValue("color").equals("rgba(230, 82, 82, 1)")) {
            esColorRojo = true;
        }
    }

    private void validarColorVerde(WebElement valorPositivo) {
        if (valorPositivo.getCssValue("color").equals("rgba(36, 179, 20, 1)")) {
            esColorVerde = true;
        }
    }
}
