import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resource/Login.feature"},
        glue = {"stepDefinitions"}, stepNotifications = true)
public class TestRunner {
}
