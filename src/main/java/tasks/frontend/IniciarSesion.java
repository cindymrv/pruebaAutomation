package tasks.frontend;

import interactions.front.DiligenciarInformacion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IniciarSesion implements Task {

    private final Map<String, String> mapInformacionUsuario;

    public IniciarSesion(Map<String, String> mapInformacionUsuario) {
        this.mapInformacionUsuario = mapInformacionUsuario;
    }

    public static IniciarSesion conUsuarioYContrasena(Map<String, String> mapInformacionUsuario) {
        return instrumented(IniciarSesion.class, mapInformacionUsuario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(DiligenciarInformacion.conCredenciales(mapInformacionUsuario));
    }
}
