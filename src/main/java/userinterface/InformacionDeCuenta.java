package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InformacionDeCuenta {
    public static final Target TABLA_DE_TRANSACCIONES = Target.the("Tabla de transacciones ").located(By.xpath("//*[@id='transactionsTable']"));

}
