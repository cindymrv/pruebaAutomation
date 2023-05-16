package questions.frontend;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static userinterface.InformacionDeCuenta.CANVAS;

public class LosValores implements Question<Boolean> {
    public static LosValores enElCuadroDeGastos() {
        return new LosValores();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return CANVAS.resolveFor(actor).isDisplayed();
    }
}
