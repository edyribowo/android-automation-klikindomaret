# 🛒 Klik Indomaret Android Automation 

This repository contains the mobile test automation suite for the **Klik Indomaret** Android application. It is built with a modern technology stack to ensure robustness, readability, and rich reporting.

## 🛠 Technology Stack
* **Java 17** - Core programming language
* **Appium (v9.x)** - Mobile automation framework
* **Cucumber (v7.x)** - Behavior-Driven Development (BDD) framework
* **Serenity BDD (v4.x)** - Living documentation and test reporting
* **JUnit 5** - Test runner engine
* **Maven** - Dependency and build management

## 📋 Prerequisites
Before running the tests, ensure you have the following installed and configured on your machine:

1. **Java JDK 17** (Verify with `java -version`)
2. **Maven** (Verify with `mvn -version`)
3. **Appium Server** (Install via npm: `npm install -g appium`)
4. **Android SDK & ADB** properly set in your system environment variables (`ANDROID_HOME`).
5. **An Android Emulator or Physical Device** connected and authorized via ADB (Verify with `adb devices`).

## ⚙️ Configuration
All device and Appium server configurations are managed in the `config.properties` file located in the root of the project.

```properties
# config.properties
platformName = Android
deviceName = RRCT200R3ER              # Change to your connected device/emulator ID
automationName = UiAutomator2
appiumURL = http://127.0.0.1:4723/    # Default Appium Server URL
appPackage = com.indomaret.klikindomaret
appActivity = .ngsCexmFBytBw          # The main launcher activity
noReset = true                        # Set to 'false' if you want the app data to clear on each run
```

*Note: Ensure your `deviceName` matches the output of `adb devices`.*

## 🚀 Running the Tests

1. **Start the Appium Server**:
   Open a new terminal and simply run:
   ```bash
   appium
   ```
   Wait until you see the REST http interface listener started on `0.0.0.0:4723`.

2. **Execute the Test Suite**:
   Open a separate terminal in the root of this project and run the Maven test command:
   ```bash
   mvn clean test
   ```

## 📊 Generating Serenity Reports
Serenity BDD provides highly detailed, rich HTML reports. To generate the report after a test run:

```bash
mvn serenity:aggregate
```
Once completed, you can view the report by opening the following file in your browser:
`target/site/serenity/index.html`

## 📁 Project Structure
The framework utilizes the **Page Object Model (POM)** and **Step Definition** design patterns:

* `src/test/java/com/indomaret/klikindomaret/identifier/` - Contains element locators (IDs, XPaths) for individual screens.
* `src/test/java/com/indomaret/klikindomaret/pages/` - Contains Page Object classes (`BasePage`, `CartPage`, `LoginPage`, etc.) that define UI interactions.
* `src/test/java/com/indomaret/klikindomaret/steps/` - Contains Cucumber step definitions mapping feature files to Java code.
* `src/test/java/com/indomaret/klikindomaret/utils/` - Contains utilities like `ConfigReader` and `DriverUtils` (Appium setup & teardown).
* `src/test/resources/features/` - *(If applicable)* Contains `.feature` files written in Gherkin syntax.

## ⚠️ Limitations & Known Issues

https://github.com/user-attachments/assets/e1b17a01-914a-4811-8623-f1c2a9820161

During the development of this automation suite, the target application experienced intermittent system instability and backend disturbances. Due to these external dependencies, full end-to-end assertions (reaching the absolute final payment confirmation pages) could not always be consistently verified. The framework itself is architected to handle the complete flow, but test executions may fail prematurely due to these unpredictable app-side issues.
