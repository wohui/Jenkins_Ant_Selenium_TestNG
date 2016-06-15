package com.selenium.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;
import org.testng.Assert;

@Test
public class TestNGReport {

    WebDriver driver;
    public void main() throws Exception {        
         //设置浏览器路径
        System.setProperty("webdriver.firefox.bin", "D:/Program Files (x86)/Mozilla firefox/firefox.exe"); 
        driver = new FirefoxDriver();
        driver.get("http://www.baidu.com/");
        //最大化浏览器窗口
        driver.manage().window().maximize();
        //通过name=wd找到百度输入框，并输入Glen
        String mytextString ="把百度设为主页";
		String findtextString=driver.findElement(By.id("setf")).getText();
		System.out.println(findtextString);
        //判断获取到的文本是否和期望的文本相等    
	    Assert.assertEquals(mytextString, findtextString);
    }    
    @AfterTest
    //结束测试，退出浏览器
    public void tearDown(){
        driver.quit();
    }
}
