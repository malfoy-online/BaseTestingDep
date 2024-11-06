package org.example;

import org.basetest.browsermanager.DriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertNotNull;

public class TestBrowserInitialization {

    @Test
    public void testChromeBrowserInstantiation(){
        WebDriver driver = DriverManager.getDriver("Chrome");
        assertNotNull(driver);
    }
}
