package PageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private AndroidDriver<AndroidElement> driver;
    private WebDriverWait wait;
    private String firstActivity;
    private String secondActivity;

    public LoginPage(AndroidDriver<AndroidElement>  driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // find element:
    @AndroidFindBy(id = "cs486.nmnhut.gogo:id/txtUsername")
    public MobileElement emailEditText;

    @AndroidFindBy(id = "cs486.nmnhut.gogo:id/txtPassword")
    public MobileElement passwordEditText;

    @AndroidFindBy(id = "cs486.nmnhut.gogo:id/btnLogin")
    public MobileElement loginElement;

    //clear all entered key:
    public void clearKeys(){
        wait.until(ExpectedConditions.visibilityOf(emailEditText));
        if(emailEditText.getText()!=""){
            emailEditText.clear();
        }
        wait.until(ExpectedConditions.visibilityOf(passwordEditText));
        if(passwordEditText.getText()!=""){
            passwordEditText.clear();
        }
    }

    //action:
    public void typeEmail(String email){
        wait.until(ExpectedConditions.visibilityOf(emailEditText));
        if(emailEditText.getText()!=""){
            emailEditText.clear();
        }
        emailEditText.sendKeys(email);
    }

    public void typePassword(String password){
        wait.until(ExpectedConditions.visibilityOf(passwordEditText));
        if(passwordEditText.getText()!=""){
            passwordEditText.clear();
        }
        passwordEditText.sendKeys(password);
    }

    public void clickLogin(){
        wait.until(ExpectedConditions.visibilityOf(loginElement));
        loginElement.click();
    }

    public void login(String email, String password){
        firstActivity = driver.currentActivity();
        System.out.println( "first activity: " + firstActivity);
        // enter information:
        typeEmail(email);
        typePassword(password);
        clickLogin();
        //get activity 2 name
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        secondActivity = driver.currentActivity();
        System.out.println( "second activity: " + secondActivity);

    }

    public boolean loginResult(){
        if(!firstActivity.equals(secondActivity)){
            return true;
        }
        else{
            return false;
        }
    }

}
