package Test;

import PageObject.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class loginTest {
    @Test
    public void LoginTestFunction() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "6");
        caps.setCapability("deviceName", "emulator-5562");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "cs486.nmnhut.gogo");
        caps.setCapability("appActivity", "cs486.nmnhut.gogo.Login");
        caps.setCapability("autoGrantPermissions", true);

        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);

        driver.resetApp();
        TimeUnit.SECONDS.sleep(5);

//        List<String> accounts = new ArrayList();
//        accounts.add("lhnam@apcs.vn");
//        accounts.add("nmnhut@apcs.vn");
//        accounts.add("ndtquang@apcs.vn");
//        accounts.add("hello");
//
//        for(int i =0;i<accounts.size(); ++i){
//
//            LoginPage firstLoginPage = new LoginPage(driver);
//            String email = (String) accounts.get(i);
//            firstLoginPage.login(email, PASSWORD);
//            //delay
//            TimeUnit.SECONDS.sleep(3);
//
//            if(firstLoginPage.loginResult()){
//                LogoutPage logoutPage = new LogoutPage(driver);
//                logoutPage.logout();
//            }
//        }
        LoginPage login = new LoginPage(driver);
        System.out.println("DOING LOGIN TEST .......");
        login.login("lhnam@apcs.vn" , "123456");


    }
}
