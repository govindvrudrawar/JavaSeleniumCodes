package AutomationSyntax;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class HowToTakeScreenshotByAShot {
	
	/*public static void main(String[] args) throws IOException {
		WebDriver driver = null;
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.naukri.com");
		driver.manage().window().maximize();
		AShot shot = new AShot();
		Screenshot sc =shot.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(sc.getImage(), "jpg", new File("C:\\Users\\sony\\Desktop\\New folder.ElementScreenshot.jpg"));
		driver.quit();	
		*/		
				
		
	
	
	@Test
	public static void TakeScreenShot() throws IOException {
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver = new FirefoxDriver();
	driver.get("https://www.naukri.com");
	driver.manage().window().maximize();
	
	AShot ashot = new AShot();
	Screenshot sc=ashot.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	ImageIO.write(sc.getImage(),"PNG", new File("C:\\Users\\sony\\Desktop\\New folder.png"));
	driver.quit();
	
}
}
