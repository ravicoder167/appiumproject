# Feature:

- Parallel Execution support
- Page object model
- Generate HTML report
- Genarate Log for debugging purpose
- Retry Logic
- Send Report over Email


# Test scenario:
1. open Amazon app
1. Click Menu
1. Click Shop by department 
1. Click Electronics 
1. Scroll to Kindle
1. Click Kindle
1. Verify Kindle got loaded

## Project Structure

# src
1. main/java/com/tcs/rbc/appium/poc/automation/mobiledriver/
	1. MobileDriver.java- Class is for driver operation find element change context ,scroll to element
1. main/java/com/tcs/rbc/appium/poc/automation/model/
	1. TestConfigModel.java- Class for setter getter method to hold input data
1. main/java/com/tcs/rbc/appium/poc/automation/pageobject/
	1. 1.PageObjectBase.java
	2. 	ElectronicsDepartmentScreen.java
	3. 	HomeScreen.java
	4. 	ProductDescriptionScreen.java
1. main/java/com/tcs/rbc/appium/poc/automation/report
	1. 	AnnotationTransformer.java- class to  set Retry Analyzer
	2. 	ExtentManager.java- Class to handle report
	3. 	ExtentTestManager.java-Class to handle report
	4. 	RetryHandler.java-Class to handle retry for fail test cases
	5. 	TestListener.java-Class to monitor execution
1. main/java/com/tcs/rbc/appium/poc/automation/testcases/
	1. AmazonTestCase.java
	1. TestBase.java
1. src/main/java/com/tcs/rbc/appium/poc/automation/utils/
	1. Constants.java
	2. DeviceOperation.java-Class to handle Device operation like click back, home   button 
	3. LogLevel.java
	4. LogManager.java-Class to logging log
	5. SendReportInEmail.java-Class to send report over mail
	6. Utils.java
	7. Zip.java

# resources
1. Apps- Contains .apk file
2. Config-Contains Framework config file & logJ Config file
3. TestData-Contains input test data
4. locator-Contains element locator file

# Tool used
1.  TestNg
2. Appium
3. log4J
4. Extent Report
5. Maven
