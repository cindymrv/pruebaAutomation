package utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RecursoFront {

  URL_APPLITOOLS("https://demo.applitools.com/hackathonV2.html"),
  TRANSACCIONES_RECIENTES("Recent Transactions");

  private final String recursoFront;
}
