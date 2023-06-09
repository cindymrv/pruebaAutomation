package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/informacion_de_la_cuenta.feature",
        glue = "stepdefinitions"
)
public class InformacionDeCuentaRunner {
}
