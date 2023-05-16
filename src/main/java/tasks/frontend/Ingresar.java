package tasks.frontend;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterface.InformacionDeCuenta.BTN_MOSTRAR_CUADRO_GASTOS;

public class Ingresar implements Task {
    public static Ingresar mostrarCuadroDeGastos() {
        return instrumented(Ingresar.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BTN_MOSTRAR_CUADRO_GASTOS));
    }
}
