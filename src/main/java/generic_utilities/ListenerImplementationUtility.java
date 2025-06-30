package generic_utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * 
 * This class provides implementation to the methods from ITestListeners interface of TestNG
 */
public class ListenerImplementationUtility implements ITestListener{
	ExtentReports report;
	ExtentTest testlog;

	@Override
	public void onTestStart(ITestResult result) {
		
		//Capture method name
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+":Test execution started");
		//create test in Extent Reports
		testlog = report.createTest(methodname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		//Capture method name
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+":Test PASS");
		
		//log the test result in Extent Reports
		testlog.log(Status.PASS, methodname+"-Test PASS");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//Capture method name
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+":Test FAIL");
		
		//log the test result in Extent Reports
		
		
		testlog.log(Status.FAIL, methodname +"-Test FAIL");
		
		
		//Capture Exception
		System.out.println(result.getThrowable());
		
		//Capture Exception in extent Reports
		testlog.log(Status.WARNING, result.getThrowable());
		
		
		
		//Capture  Screenshot
		SeleniumUtility sl = new SeleniumUtility();
		JavaUtility jl = new JavaUtility();
		
			
		
		//Configure Screenshot name
		String screenshotname= methodname+"-"+jl.getSystemDate(); 
		try  {
			String path = sl.captureScreenShot(BaseClass.takescreenshotdriver,screenshotname);
			//Attach screen shot to extent reports
			testlog.addScreenCaptureFromPath(path, screenshotname);
			
		}catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		//Capture method name
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+":Test SKIP");
		
		//Capture Exception
				System.out.println(result.getThrowable());
				
	//log the test result in Extent Reports	
				testlog.log(Status.SKIP, methodname +"-Test SKIP");
				
//Capture Exception in extent Reports
				testlog.log(Status.WARNING, result.getThrowable());
				
				
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite execution started");
		//Basic settings of Extent reports
		ExtentSparkReporter esr= new ExtentSparkReporter(".\\ExtentReoprts\\ReportGroupExecution\\Report-"+new JavaUtility().getSystemDate()+".html");
		esr.config().setDocumentTitle("Swag labs report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Inventory Module Batch Eexecution");
		
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Env", "Test Env");
		report.setSystemInfo("Reporter Name", "Vrunda");
		report.setSystemInfo("TE NAME", "RAVI");
		
		
			
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite execution finished");
		report.flush();
	}
	
	
	

}
