package interactions.front;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterface.IniciarSesion.*;

public class DiligenciarInformacion implements Interaction {

    private final Map<String, String> mapInformacionUsuario;

    public DiligenciarInformacion(Map<String, String> mapInformacionUsuario) {
        this.mapInformacionUsuario = mapInformacionUsuario;
    }

    public static DiligenciarInformacion conCredenciales(Map<String, String> mapInformacionUsuario) {
        return instrumented(DiligenciarInformacion.class, mapInformacionUsuario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(mapInformacionUsuario.get("Usuario")).into(TXT_USUARIO));
        actor.attemptsTo(Enter.theValue(mapInformacionUsuario.get("Contraseña")).into(TXT_CONTRASENA));
        actor.attemptsTo(Click.on(BTN_NEXT_CORREO));
    }
}
