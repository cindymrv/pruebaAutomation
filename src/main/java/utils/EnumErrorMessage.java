package utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumErrorMessage {
  MENSAJE_ERROR_COLORES("Los colores no corresponden a los valores"),
  MENSAJE_ERROR_CUADRO_GASTOS("El cuadro de gastos no se visualizo"),
  MENSAJE_ERROR_LOGIN("Fallo el login"),
  MENSAJE_ERROR_NOMBRE_USUARIO("El nombre mostrado en la consulta del usuario no corresponde con el insertado en la creación"),
  MENSAJE_ERROR_PANORAMA_FINANCIERO("Los datos de balance total o el de crédito disponible no son correctos"),
  MENSAJE_ERROR_STATUS_CODE("El status code no es el esperado"),
  MENSAJE_ERROR_TRANSACCIONES_RECIENTES("La cantidad de transacciones no son correctas");

  private final String errorMessage;
}
