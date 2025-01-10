package br.com.estudo.automationpratice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

class loginTests {

	@Test
	@DisplayName("Sem usuario Sem senha")
	void Tests_SemUsuarioSemSenha() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");

		
		WebElement edt_email = driver.findElement(By.id("email"));
		WebElement edt_password = driver.findElement(By.name("passwd"));
		WebElement btn_login = driver.findElement(By.id("SubmitLogin"));

		//codigo para limpar os campos quando a pagina é aberta
		edt_email.clear();
		edt_password.clear();
		btn_login.click();


		//codigo para procurar o texto na pagina
		WebElement msg_alerta = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/ol/li"));
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));

		//codigo para verificar o conteudo da mensagem
		assertEquals("An email address required.", msg_alerta.getText(), "Verificando mensagem");

		driver.close();
	}

	@Test
	@DisplayName("Com usuario Sem senha")
	void Tests_ComUsuarioSemSenha() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");

		WebElement edt_email = driver.findElement(By.id("email"));
		WebElement edt_password = driver.findElement(By.name("passwd"));
		WebElement btn_login = driver.findElement(By.id("SubmitLogin"));

		edt_email.clear();
		edt_password.clear();

		edt_email.sendKeys("abc@gmail.com");
		btn_login.click();
		
		//codigo para procurar o texto na pagina
		WebElement msg_alerta = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/ol/li"));
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));

		//codigo para verificar o conteudo da mensagem
		assertEquals("Password is required.", msg_alerta.getText(), "Verificando mensagem");


		driver.close();
	}

	@Test
	@DisplayName("Sem usuario Com senha")
	void Tests_SemUsuarioComSenha() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");

		//codigo para procurar o texto na pagina
		//WebElement title = driver.findElement(By.cssSelector("h1"));

		WebElement edt_email = driver.findElement(By.id("email"));
		WebElement edt_password = driver.findElement(By.name("passwd"));
		WebElement btn_login = driver.findElement(By.id("SubmitLogin"));

		edt_email.clear();
		edt_password.clear();

		edt_password.sendKeys("1234567890");
		btn_login.click();

		//codigo para procurar o texto na pagina
		WebElement msg_alerta = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/ol/li"));
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));

		//codigo para verificar o conteudo da mensagem
		assertEquals("An email address required.", msg_alerta.getText(), "Verificando mensagem");

		driver.close();
	}
}
