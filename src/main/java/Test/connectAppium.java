package Test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class connectAppium {

    private final static String APP_PACKAGE_NAME = "cs486.nmnhut.gogo";
    private final static String APP_ACTIVITY_NAME = "cs486.nmnhut.gogo.MainActivity";
    private final static String PASSWORD = "123456";

    public static void main(String[] args) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "6");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "cs486.nmnhut.gogo");
        caps.setCapability("appActivity", "cs486.nmnhut.gogo.Login");
        caps.setCapability("autoGrantPermissions", true);

        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);

        driver.resetApp();
    }
}
