package utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumErrorMessage {
  MENSAJE_ERROR_PANORAMA_FINANCIERO("Los datos de balance total o el de crédito disponible no son correctos"),
  MENSAJE_ERROR_LOGIN("Fallo el login"),
  MENSAJE_ERROR_TRANSACCIONES_RECIENTES("La cantidad de transacciones no son correctas"),
  MENSAJE_ERROR_COLORES("Los colores no corresponden a los valores");

  private final String errorMessage;
}
