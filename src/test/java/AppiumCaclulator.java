import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumCaclulator {
    static AndroidDriver driver;

    public static void main(String[] args) {
        try {
            openCalc();
        } catch (MalformedURLException e) {
            System.out.println("Error Here");
            e.printStackTrace();
        }
    }

    public  static  void  openCalc() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "sdk_gphone64_x86_64");
        capabilities.setCapability("udid","emulator-5554");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        URL url = new URL("http://127.0.0.1:5723/wd/hub");
        driver = new AndroidDriver(url,capabilities);
        System.out.println("Application is Started ...");
    }
}
