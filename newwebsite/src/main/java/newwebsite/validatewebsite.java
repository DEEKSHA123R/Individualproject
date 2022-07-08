package newwebsite;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class validatewebsite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String path1 = "D:\\selenium\\selenium-java-4.2.2\\chromedriver_win32/chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", path1);
				WebDriver driver = new ChromeDriver();
				driver.get("file:///D:/newwebsite/index.html");

				// the home page is displayed along with heading star book store
				WebElement HeaderElement = driver.findElement(By.className("header"));
				if (HeaderElement.isDisplayed()) {
					WebElement HeaderElement1 = HeaderElement.findElement(By.xpath("/html/body/header/div[1]/h1"));
					String Header = HeaderElement1.getText().trim();
					String ExpectedHeader = "Star Book Store";
					Assert.assertEquals(Header, ExpectedHeader);
					List<WebElement> NavigationBarsAtag = HeaderElement.findElements(By.tagName("a"));
					WebElement loginNav = NavigationBarsAtag.get(0);
					NavigationBarsAtag.get(1).click();

					// able to see page with heading about us
					WebElement HeadingElements = driver.findElement(By.xpath("/html/body/div/div/h1"));
					String AboutHeader = HeadingElements.getText().trim();
					String ExpectedAboutHeader = "ABOUT US";
					Assert.assertEquals(AboutHeader, ExpectedAboutHeader);
					// validating back to home button
					WebElement BacktoHomeButtondiv = driver.findElement(By.className("skills"));
					WebElement BacktoHomeButton = BacktoHomeButtondiv.findElement(By.tagName("a"));
					if (BacktoHomeButton.isDisplayed()) {
						driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
						BacktoHomeButton.click();
					}
				}
				// navigating to login page
				boolean HeaderElement1 = driver.findElement(By.className("header")).isDisplayed();
				Assert.assertEquals(true, HeaderElement1);
				WebElement LoginNavBardiv = driver.findElement(By.xpath("/html/body/header/div[2]/nav/div/a[1]"));
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				LoginNavBardiv.click();

				// Login page for student and admin is visible
				WebElement LoginHeadingElements = driver.findElement(By.xpath("/html/body/div/div[1]/div/h1"));
				String LoginHeader = LoginHeadingElements.getText().trim();
				String ExpectedLoginHeader = "Book World";
				Assert.assertEquals(LoginHeader, ExpectedLoginHeader);
				// Validating navigation bar login and about us

				List<WebElement> LoginNavBar = driver.findElement(By.xpath("/html/body/div/div[1]/nav/ul"))
						.findElements(By.tagName("li"));
				LoginNavBar.get(0);
				LoginNavBar.get(1);
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				LoginNavBar.get(2).click();

				// Validating login and Register page
				// Validating login and register page displayed or not if displayed click on
				// register button
				WebElement LoginandRegisterPageElement = driver.findElement(By.className("form-box"));
				if (LoginandRegisterPageElement.isDisplayed() == true) {
					WebElement RegisterDivElements = LoginandRegisterPageElement.findElement(By.className("button-box"));
					List<WebElement> LoginandRegisterButtons = driver.findElement(By.className("button-box"))
							.findElements(By.tagName("button"));
					WebElement RegisterButton = LoginandRegisterButtons.get(1);
					RegisterButton.click();
				}
				// Validating Register page
				WebElement RegisterPageForm = LoginandRegisterPageElement.findElement(By.className("input-group-register"));
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				String Email = "Shettyd963@gmail.com";
				String password = "Deeksha12";
				RegisterPageForm.findElement(By.id("fname")).sendKeys("Deeksha");
				RegisterPageForm.findElement(By.id("laname")).sendKeys("Shetty");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				RegisterPageForm.findElement(By.id("email")).sendKeys(Email);
				RegisterPageForm.findElement(By.id("pass")).sendKeys(password);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				RegisterPageForm.findElement(By.id("con")).sendKeys("Deeksha122");
				RegisterPageForm.findElement(By.xpath("/html/body/div/div[2]/div/form[2]/input[6]")).click();
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				RegisterPageForm.findElement(By.xpath("/html/body/div/div[2]/div/form[2]/button")).click();
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

				// validating password and confirm password not matching error
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				String ErrorMessage = RegisterPageForm.findElement(By.id("Error-Message")).findElement(By.tagName("h6"))
						.getText();
				String LoginErrorMessage = ErrorMessage.trim();
				String ExpectedErrorMessage = "Paasword and confirm password not matching";
				Assert.assertEquals(LoginErrorMessage, ExpectedErrorMessage);

				// Validating success message
				RegisterPageForm.findElement(By.id("con")).clear();
				RegisterPageForm.findElement(By.id("con")).sendKeys("Deeksha12");
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				RegisterPageForm.findElement(By.xpath("/html/body/div/div[2]/div/form[2]/button")).click();
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
//							String SuccessMessage=RegisterPageForm.findElement(By.id("Message")).findElement(By.tagName("h6")).getText();
//							String LoginSucessMessage=SuccessMessage.trim();
//							String ExpectedSucessMessage="Registration sucessfull";
//							Assert.assertEquals(LoginSucessMessage,ExpectedSucessMessage);
//							 driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);

				// Validating login page
				WebDriverWait wait = new WebDriverWait(driver, 5000);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/nav/ul/li[3]/button")));
				driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
				WebElement LoginNavigationBar = driver.findElement(By.xpath("/html/body/div/div[1]/nav/ul/li[3]/button"));
				LoginNavigationBar.click();
				driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
				WebElement LoginPageForm = driver.findElement(By.className("input-group-login"));
				LoginPageForm.findElement(By.id("e-mail")).sendKeys("Sehettyd@gmail.com");
				LoginPageForm.findElement(By.id("pass-id")).sendKeys("Shetty123#");
				LoginPageForm.findElement(By.xpath("/html/body/div/div[2]/div/form[1]/input[3]")).click();
				// driver.manage().timeouts().ImplicitWait = Timestamp.fromSeconds(20);
				LoginPageForm.findElement(By.xpath("/html/body/div/div[2]/div/form[1]/button")).click();
				driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
				// validating password and confirm password not matching error
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				WebElement ErrorMessage1 = driver.findElement(By.xpath("/html/body/div/div[2]/div/form[1]/div[2]/h6"));
				driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
				String LoginErrorMessages = ErrorMessage1.getText().trim();
				String ExpectedLoginErrorMessage = "Paasword and email not matching";
				Assert.assertEquals(LoginErrorMessages, ExpectedLoginErrorMessage);
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

				// Validating success message
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
				driver.findElement(By.xpath("/html/body/div/div[2]/div/form[1]/input[1]")).clear();
				driver.findElement(By.xpath("/html/body/div/div[2]/div/form[1]/input[1]")).sendKeys(Email);
				driver.findElement(By.xpath("/html/body/div/div[2]/div/form[1]/input[2]")).clear();
				driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
				driver.findElement(By.xpath("/html/body/div/div[2]/div/form[1]/input[2]")).sendKeys("Deeksha12");
				driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
				driver.findElement(By.xpath("/html/body/div/div[2]/div/form[1]/button")).click();
				driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
//							String SuccessMessages=LoginPageForm.findElement(By.id("LoginMessage")).findElement(By.tagName("h6")).getText();
//							String LoginSuccessMessages=SuccessMessages.trim();
//							String ExpectedLoginSucessMessage="Login sucessful";
//							Assert.assertEquals(LoginSuccessMessages,ExpectedLoginSucessMessage);
//							 driver.manage().timeouts().implicitlyWait(20000,TimeUnit.SECONDS);

				// Add cart here
				driver.findElement(By.tagName("a")).click();

				// Admin page login validation
				WebElement AdminNavigationBar = driver.findElement(By.xpath("/html/body/div/div[1]/nav/ul/li[2]/a"));
				AdminNavigationBar.click();
				WebElement AdminPageForm = driver.findElement(By.id("form_id"));
				AdminPageForm.findElement(By.id("username")).sendKeys("Sehettyd963@gmail.com");
				AdminPageForm.findElement(By.id("password")).sendKeys("Shetty123#");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				AdminPageForm.findElement(By.id("submit")).click();

				// validating password and confirm password not matching error
				String ErrorMessage11 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/div[2]/h6")).getText();
				driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
				String AdminErrorMessages = ErrorMessage11.trim();
				String AdminLoginErrorMessage = "Paasword and email not matching";
				Assert.assertEquals(AdminErrorMessages, AdminLoginErrorMessage);
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

				// Validating sucess message
				driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/input[1]")).clear();
				driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/input[1]")).sendKeys(Email);
				driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/input[2]")).clear();
				driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/input[2]")).sendKeys("Deeksha12");
				driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/input[3]")).click();

				// Validating Book details displayed or not
				WebElement AdminPageOuterDiv = driver.findElement(By.className("table-wrapper"));
				if (AdminPageOuterDiv.isDisplayed() == true) {
					String AdminPageHeader = AdminPageOuterDiv.findElement(By.className("table-title"))
							.findElement(By.tagName("h2")).getText();
					if (AdminPageHeader == "Book Details") {
						boolean IsBookDetailDisplayed = AdminPageOuterDiv.findElement(By.className("table table-bordered"))
								.isDisplayed();
						Assert.assertEquals(true, IsBookDetailDisplayed);
					}
					driver.close();
					driver.quit();
				}

				// Logout button validation
				WebElement AdminPageLogoutButton = driver.findElement(By.xpath("/html/body/div/div/div/div/div/a"));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				AdminPageLogoutButton.click();

				// Validate Redirection to Login page
				WebElement LoginHeadingElements1 = driver.findElement(By.className("navbar"))
						.findElement(By.className("Login-Heading"));
				if (LoginHeadingElements1.isDisplayed()) {
					WebElement LoginNavigationBars = driver.findElement(By.className("navbar"));
					List<WebElement> LoginNavigationBardiv = LoginNavigationBars.findElements(By.tagName("li"));
					WebElement HomeNavigations = LoginNavigationBardiv.get(0);
					HomeNavigations.click();
					WebElement HomeHeaderElement = driver.findElement(By.className("ui-treetable-tbody"));
					if (HomeHeaderElement.isDisplayed())
						Assert.assertEquals(true, HomeHeaderElement);

				}
			}
		}
