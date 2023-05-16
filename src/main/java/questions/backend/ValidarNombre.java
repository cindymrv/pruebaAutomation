package questions.backend;

import models.response.ResponseInformacionEmpleados;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static utils.EnumVariablesSesion.VARIABLE_SESION_NOMBRE;


public class ValidarNombre implements Question<Boolean> {

    private final String nombre;

    public ValidarNombre(String nombre) {

        this.nombre= nombre;
    }

    public static ValidarNombre delUsuarioCreado(String nombre) {
        return new ValidarNombre(nombre);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String nombreServicio=  actor.recall(VARIABLE_SESION_NOMBRE.getVariableSesion());
        return  nombreServicio.equals(nombre);
    }
}
