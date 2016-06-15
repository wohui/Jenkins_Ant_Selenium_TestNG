package com.selenium.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;
import org.testng.Assert;


public class NewTestNG_Fail {

    WebDriver driver;
    @Test
    public void main() throws Exception {        
         //设置浏览器路径
        System.setProperty("webdriver.firefox.bin", "D:/Program Files (x86)/Mozilla firefox/firefox.exe"); 
        driver = new FirefoxDriver();
        driver.get("http://www.baidu.com/");
        //最大化浏览器窗口
        driver.manage().window().maximize();
        //通过name=wd找到百度输入框，并输入Glen
        WebElement txtbox = driver.findElement(By.name("wd"));
        txtbox.sendKeys("Glen");
        //通过id=su，定位百度一下按钮，并点击
        WebElement btn = driver.findElement(By.id("su"));
        btn.click();
        //定义期望的title和获取的title
        String expectedTitle = "不存在的Title";
        String actualTitle = driver.getTitle();
        System.out.println(driver.getTitle());
        //判断获取到的title是否和期望的title相等
        Assert.assertEquals(actualTitle,expectedTitle);            
    }
    
    @AfterTest
    //结束测试，退出浏览器
    public void tearDown(){
        driver.quit();
    }

}