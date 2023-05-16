package tasks.servicios;

import models.builders.RequestInsertarUsuarioBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;


import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class InsertarUsuario implements Task {

    private final Map<String, String> mapCaracteristicasUsuario;

    public InsertarUsuario(Map<String, String> mapCaracteristicasUsuario) {
        this.mapCaracteristicasUsuario = mapCaracteristicasUsuario;
    }

    public static InsertarUsuario conCaracteristicas(Map<String, String> mapCaracteristicasUsuario) {
        return instrumented(InsertarUsuario.class, mapCaracteristicasUsuario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to("/users").with(requestSpecification ->
                requestSpecification
                        .body(RequestInsertarUsuarioBuilder.conCaracteristicas(mapCaracteristicasUsuario))));

        actor.should(seeThatResponse(response -> response.log().all()));




    }
}
