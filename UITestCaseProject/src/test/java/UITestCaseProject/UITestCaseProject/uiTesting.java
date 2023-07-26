package UITestCaseProject.UITestCaseProject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class uiTesting {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		TakesScreenshot ts = (TakesScreenshot)driver;
		driver.get(" https://www.getcalley.com/page-sitemap.xml");
		List<WebElement> formTag = driver.findElements(By.xpath("//tbody/tr"));
		for (WebElement Links : formTag) {
			Links.click();
			Dimension dimension = new Dimension(1920, 1080);
			driver.manage().window().setSize(dimension);
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			String dateTime = LocalDateTime.now().toString().replace(':', '-');
			File destFile = new File("./ScreenShots/UI "+ dateTime + " .png");
			FileUtils.copyFile(srcFile, destFile);
			driver.navigate().back();
		}
		driver.quit();
	}
}
