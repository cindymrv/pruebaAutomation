package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InformacionDeCuenta {
    public static final Target TABLA_DE_TRANSACCIONES = Target.the("Tabla de transacciones ").located(By.xpath("//*[@id='transactionsTable']"));
    public static final Target LBL_TOTAL_BALANCE = Target.the("Label con total de balance ").located(By.xpath("//span[.='$350']"));
    public static final Target LBL_CREDITO_DISPONIBLE = Target.the("Label con total de balance ").located(By.xpath("//div[@id='creditAvailable']/div[@class='balance-value']"));

}
