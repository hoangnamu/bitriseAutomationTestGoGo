package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

    private AndroidDriver<AndroidElement> driver;
    private WebDriverWait wait;

    public LogoutPage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void logoutPage(){

    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.support.v7.widget.LinearLayoutCompat[4]/android.widget.CheckedTextView")
    public AndroidElement logoutButton;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")
    public AndroidElement openMenu;

    public void clickLogout(){
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();
    }

    public void clickMenu(){
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        openMenu.click();
    }
    public void logout(){
        openMenu.click();
        logoutButton.click();

    }
}


