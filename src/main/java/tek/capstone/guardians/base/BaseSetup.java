package tek.capstone.guardians.base;


import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import tek.capstone.guardians.config.Browser;
import tek.capstone.guardians.config.ChromeBrowser;
import tek.capstone.guardians.config.ChromeHeadless;
import tek.capstone.guardians.config.EdgeBrowser;
import tek.capstone.guardians.config.FireFoxBrowser;
import tek.capstone.guardians.utilities.ReadYamlFiles;

public class BaseSetup {
	
	 private static WebDriver webDriver;
	    private final ReadYamlFiles environmentVariables;
	    public static Logger logger;
	    
	    public BaseSetup() {
	        String filePath = System.getProperty("user.dir") + "/src/main/resources/env_config.yml";
	        String log4jPath = System.getProperty("user.dir")+ "/src/main/resources/log4j.properties";
	        try {
	            environmentVariables = ReadYamlFiles.getInstance(filePath);
	        } catch (FileNotFoundException e) {
	            System.out.println("Failed for Load environment context. check possible file path errors");
	            throw new RuntimeException("Failed for Load environment context with message " + e.getMessage());
	        }
	        
	        logger = logger.getLogger("logger_file");
	        PropertyConfigurator.configure(log4jPath);
	        
	    }
	        
	        
	    public WebDriver getDriver() {
	        return webDriver;
	    }
	    
	    public void setupBrowser() {
		
		
	        HashMap uiProperties = environmentVariables.getYamlProperty("ui");
	        System.out.println(uiProperties);
	        String url = uiProperties.get("url").toString();
	        Browser browser;
	        switch (uiProperties.get("browser").toString().toLowerCase()) {
	        case "chrome":
	            if ((boolean) uiProperties.get("headless")) {
	                browser = new ChromeHeadless();
	            } else {
	                browser = new ChromeBrowser();
	            }
	            webDriver = browser.openBrowser(url);
	            break;
	        case "firefox":
	            browser = new FireFoxBrowser();
	            webDriver = browser.openBrowser(url);
	            break;
	        case "edge":
	            browser = new EdgeBrowser();
	            webDriver = browser.openBrowser(url);
	            break;
	        default:
	            throw new RuntimeException("Unknown Browser check environment properties");
	        }
	        webDriver.manage().window().maximize();
	        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	       
	        
	    }   
	        
	     public void quitBrowser() {
	        if(webDriver != null)
	            webDriver.quit();
	    }
	}   
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	      
	        
	    
	    
	    
	    

