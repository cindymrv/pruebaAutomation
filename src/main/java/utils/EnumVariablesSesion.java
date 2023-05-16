package utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumVariablesSesion {
    VARIABLE_SESION_ID("Variable de sesion para la respuesta del servicio"),
    VARIABLE_SESION_NOMBRE("Variable de sesion para guardar el nombre del usuario que de vuelve el servicio al consultar por el id");

    private final String variableSesion;
}
