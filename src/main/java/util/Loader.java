package util;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public interface Loader {

    DesiredCapabilities loadCapabilities();

    URL loadUrl();
}
