package jpetStore.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import jpetStore.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener 
{  
	ExtentTest test;
	ExtentReports extent= ExtentReporterNG.getReportObject();
	
	@Override		
    public void onFinish(ITestContext context) {					
        				
        		extent.flush();
    }		

    @Override		
    public void onStart(ITestContext context) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailure(ITestResult result) {					
        // TODO Auto-generated method stub
    	test.fail(result.getThrowable());
    	
    	try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    			
    	
    	String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			
			e.printStackTrace();
		}		
    	test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    }		

    @Override		
    public void onTestSkipped(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestStart(ITestResult result) {					
        
    	test = extent.createTest(result.getMethod().getMethodName());
        		
    }		

    @Override		
    public void onTestSuccess(ITestResult result) {					
        test.log(Status.PASS, "Test Passed");
    	
        		
    }		
	

}
