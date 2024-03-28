package com.nicolas;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {

        String pesquisa = "Oque é RPA?";
        String pesquisa2 = "busca de cep";
        String pesquisaYoutube = "Cep a sua escolha";

        System.out.println("RPA Iniciado!");

        //Comandos para indicar aonde esta o executavel do navegado
        System.setProperty("webdriver.chrome.driver", "src\\drive\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        //Entrando na pagina web abaixo
        navegador.get("https://google.com");

        //Clicando e setando o valor de pesquisa
        navegador.findElement(By.xpath("//*[@id=\"APjFqb\"]")).click();
        navegador.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(pesquisa, Keys.ENTER);

        //Comando de delay
        Thread.sleep(1000);

        navegador.findElement(By.xpath("//*[@id=\"tads\"]/div[1]/div/div/div/div[2]/a/div[1]/span")).click();
        navegador.findElement(By.xpath("//*[@id=\"truste-consent-button\"]")).click();
        navegador.findElement(By.xpath("//*[@id=\"rich-text-84c4052591\"]/p[4]/a")).click();

        navegador.get("https://google.com");
        navegador.findElement(By.xpath("//*[@id=\"APjFqb\"]")).click();
        navegador.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(pesquisa2, Keys.ENTER);

        Thread.sleep(1000);

        navegador.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")).click();

        Thread.sleep(2000);

        navegador.findElement(By.xpath("//*[@id=\"endereco\"]")).click();
        navegador.findElement(By.xpath("//*[@id=\"endereco\"]")).sendKeys(pesquisaYoutube, Keys.ENTER);


        //Aqui ele esta pegando o Objeto logradou q esta na tela e setando em uma variavel e imprimindo no console
        Thread.sleep(2000);
        WebElement logradouro = navegador.findElement(By.cssSelector("#resultado-DNEC > tbody > tr > td:nth-child(1)"));
        String logradouroCapturado = logradouro.getText();
        System.out.println(logradouroCapturado);


        //Fazendo registro com Captura de tela
        // Converte o driver para TakesScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)navegador);

        // Captura o screenshot como um arquivo
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

        // Especifica o local onde o screenshot será salvo
        File destFile = new File("C:/Users/Ti/Pictures/Screenshots/screenshot.png");

        // Copia o arquivo do screenshot para o local especificado
        FileUtils.copyFile(srcFile, destFile);

        //Fechando o navegador
        navegador.quit();

    }
}