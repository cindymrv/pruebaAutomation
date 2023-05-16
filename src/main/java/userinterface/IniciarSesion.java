package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class IniciarSesion {
    public static final Target BTN_NEXT_CORREO = Target.the("Botón inicar sesion ").located(By.xpath("//button[@id='log-in']"));
    public static final Target TXT_CONTRASENA = Target.the("Caja de texto para ingresar la contraseña ").located(By.xpath("//input[@id='password']"));
    public static final Target TXT_USUARIO = Target.the("Caja de texto para contraseña ").located(By.xpath("//input[@id='username']"));
    public static final Target LBL_TABLA_TRANSACCION = Target.the("Label de tabla de transacciones recientes ").located(By.xpath("//h6[contains(.,'Recent Transactions')]"));
}
