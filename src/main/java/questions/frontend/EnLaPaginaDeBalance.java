package questions.frontend;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

import static userinterface.InformacionDeCuenta.LBL_CREDITO_DISPONIBLE;
import static userinterface.InformacionDeCuenta.LBL_TOTAL_BALANCE;

public class EnLaPaginaDeBalance implements Question<Boolean> {

    private final Map<String, String> mapInformacionPanoramaFinanciero;

    public EnLaPaginaDeBalance(Map<String, String> mapInformacionPanoramaFinanciero) {
        this.mapInformacionPanoramaFinanciero = mapInformacionPanoramaFinanciero;
    }

    public static EnLaPaginaDeBalance laInformacionDelPanoramaFinanciero(Map<String, String> balanceTotal) {
        return new EnLaPaginaDeBalance(balanceTotal);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
      return  LBL_TOTAL_BALANCE.resolveFor(actor).getText().substring(1).contains(mapInformacionPanoramaFinanciero.get("Balance total")) &&
        LBL_CREDITO_DISPONIBLE.resolveFor(actor).getText().substring(1).contains(mapInformacionPanoramaFinanciero.get("Crédito disponible"));
    }
}
