package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {
    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("target/screenshots/" + screenshotName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotName;
    }
}
