# FreeleticsAutomation
## Steps required to run the test
### Instal JDK and add its path in environment variables
### Install Maven and add its path
### Install Intellij
### Open the freeletic_test project
## To run the tests from cmd or terminal, run the below mentioned command from your project path
#### mvn clean test -DfileName="testng.xml"

# Question 2
## 1  Which parts of the code you provided would need to be adapted to run the same tests in an Android phone, using the same browser, in the tool you chose?
### In order to run this on android broswer, we need to add following data:
We need to specify the AndroidDriver: AppiumDriver driver = new AndroidDriver(new url(https://www.freeletics.com), capabilities)
We need add the set the desired capacbilities e.g 

DesiredCapabilities capabilities = new DesiredCapabilities();

capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");

capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");

capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");

capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");

capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

## 2. How could we run these tests in a physical android phone connected to your laptop? Does the laptop need any extra software/hardware to run them properly?
### In order to run this on android broswer in a actual android device, we need to add following data:
We need to specify the AndroidDriver: AppiumDriver driver = new AndroidDriver(new url(https://www.freeletics.com), capabilities)
We need add the set the desired capacbilities and specify actual device name and udid e.g 

DesiredCapabilities capabilities = new DesiredCapabilities();

capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");

capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");

**capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsuny Galaxy");**

capabilities.setCapability("udid","Actual device id");

capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");

capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

## 3. What would be the main changes if the website was now part of a hybrid android app? 
### In case of hybrid app we will specify the AndroidDriver and desired capabilities as above but we will also specify the Driver context ie: 'NATIVE_APP' and 'WEBVIEW_1'

## 4. And if it was a native app? 
### In case app is we will speicy AndroidDriver and Desired capabilities as above and additionally we will also specify the Activity name of the app which we want to access and app pacakge
capabilities.setCapability("appActivity", "Activtiy name");
capabilities.setCapability("appPackage", "package name");



