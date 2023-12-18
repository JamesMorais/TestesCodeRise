package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static String UrlBase = "https://code-rise.netlify.app/";
    public static WebDriver driver;
    public static void main(String[] args) {


    }
    public static void SetupWebDriver(String browser, String url){
        if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
    }
    public static void TesteLogin(String email, String password){
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("btn")).click();
    }
    public static void TesteCadastro(String nome, String email, String password){
        driver.findElement(By.id("nome")).sendKeys(nome);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='cadastrar perfil']")).click();
    }
    public static void TesteDeEnvioSugestoes(String autor, String area, String link){
        driver.findElement(By.xpath("/html/body/div[2]/section/div/div[2]/div/button")).click();
        driver.findElement(By.id("autor")).sendKeys(autor);
        driver.findElement(By.id("area")).sendKeys(area);
        driver.findElement(By.id("link")).sendKeys(link);
        driver.findElement(By.xpath("//*[@id='submit']")).click();
    }
    public static String Message(){
        return driver.getTitle();
    }
}