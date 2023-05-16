package questions.backend;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class ComprobarStatusCode implements Question<Boolean> {

    private final int statusCodeEsperado;

    public ComprobarStatusCode(int statusCodeEsperado) {
        this.statusCodeEsperado = statusCodeEsperado;
    }

    public static ComprobarStatusCode delResponseServicio(int statusCodeEsperado) {
        return new ComprobarStatusCode(statusCodeEsperado);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getStatusCode() == statusCodeEsperado;
    }
}
