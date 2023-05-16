package utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RecursoFront {
  TRANSACCIONES_RECIENTES("Recent Transactions"),
  URL_APPLITOOLS("https://demo.applitools.com/hackathonV2.html");

  private final String recursoFront;
}
