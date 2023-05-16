package models.builders;

import models.request.RequestInsertarUsuario;

import java.util.Map;

public class RequestInsertarUsuarioBuilder {


    public static RequestInsertarUsuario conCaracteristicas(Map<String, String> mapCaracteristicasUsuario) {
        return RequestInsertarUsuario.builder().name(mapCaracteristicasUsuario.get("Nombre")).job(mapCaracteristicasUsuario.get("Trabajo")).build();
    }
}
