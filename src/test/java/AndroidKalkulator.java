import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidKalkulator {

    AndroidDriver<WebElement> driver;

    DesiredCapabilities dc;

    @BeforeClass
    public void  setUpMobile() throws MalformedURLException {

        dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"SM A515F");
        dc.setCapability(MobileCapabilityType.UDID,"RR8N102A6XA");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"12");

        dc.setCapability("appPackage", "com.google.android.calculator");
        dc.setCapability("appActivity", "com.android.calculator2.Calculator");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new  AndroidDriver<WebElement>(url, dc);

        delay(5);

    }

    @Test(priority = 1)
    public void testPenjumlahan(){

        //step action
        WebElement btn1 = driver.findElementById("com.google.android.calculator:id/digit_1");  //button 1
        btn1.click();

        WebElement btnTambah = driver.findElement(By.id("com.google.android.calculator:id/op_add")); //button add
        btnTambah.click();

        WebElement btn2 = driver.findElementById("com.google.android.calculator:id/digit_2"); //button 2
        btn2.click();

        WebElement btnSamaDengan = driver.findElementById("com.google.android.calculator:id/eq"); //button equals
        btnSamaDengan.click();

        delay(3);

        WebElement result = driver.findElementById("com.google.android.calculator:id/result_final"); //resul gettext
        result.getText();

        //step verify
        Assert.assertEquals(result.getText(),"3");
        System.out.println("Hasil penjumlahan 1 + 2 adalah = "+result.getText());
        delay(3);
    }

    @Test(priority = 2)
    public void testPerkalian(){

        //step action
        WebElement btn3 = driver.findElementById("com.google.android.calculator:id/digit_3");  //button 3
        btn3.click();

        WebElement btnKali = driver.findElementById("com.google.android.calculator:id/op_mul"); //button multiplication
        btnKali.click();

        WebElement btn4 = driver.findElementById("com.google.android.calculator:id/digit_4"); //button 4
        btn4.click();

        WebElement btnSamaDengan = driver.findElementById("com.google.android.calculator:id/eq"); //button equals
        btnSamaDengan.click();

        delay(3);

        WebElement result = driver.findElementById("com.google.android.calculator:id/result_final"); //resul gettext
        result.getText();

        //step verify
        Assert.assertEquals(result.getText(),"12");
        System.out.println("Hasil penjumlahan 3 * 4 adalah = "+result.getText());
        delay(3);

    }

    @AfterClass
    public void quitApp(){
        delay(3);
        //untuk menutup Android
        driver.quit();
        System.out.println("Browser Quit");
    }

    static void delay(int detik){
        //biar tidak redudant
        //untuk delay 3 detik
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
