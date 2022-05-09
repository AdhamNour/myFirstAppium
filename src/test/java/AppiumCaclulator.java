import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
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
        capabilities.setCapability("deviceName", "Android SDK built for x86");
        capabilities.setCapability("udid","emulator-5554");
        capabilities.setCapability("appPackage", "com.example.todo");
        capabilities.setCapability("appActivity", "com.example.todo.MainActivity");

        URL url = new URL("http://127.0.0.1:4725/wd/hub");
        driver = new AndroidDriver(url,capabilities);
        System.out.println("Application is Started ...");

        var increment = driver.findElement(By.xpath(
                "//android.widget.Button[@content-desc=\"Increment\"]"));
        for (int i = 0; i < 10; i++) {
            increment.click();
        }
        try {
            var result = driver.findElement(By.xpath("//android.view.View[@content-desc=\"10\"]"));

        } catch (Exception e) {
            System.out.println("Failed");
        }
    }
}
