# HCL Mini Project: E-commerce Automation

This project is a Selenium-based test automation framework designed to validate the end-to-end user journey on the **Automation Exercise** e-commerce platform. It demonstrates advanced automation techniques including Page Object Model (POM), data-driven testing, and Windows-based file uploading.

## 🚀 Automated Workflow
The test suite performs the following sequence:
1.  **User Registration:** Creates a new account with a dynamic email to avoid duplication.
2.  **Authentication:** Logs in with the newly created credentials.
3.  **Product Selection:** Navigates to a specific product, adds it to the cart, and handles the "Continue Shopping" pop-up.
4.  **Checkout:** Proceeds to the checkout page from the cart.
5.  **Support & Upload:** Navigates to the 'Contact Us' page and performs a **File Upload** using an **AutoIt** script to handle the Windows file dialog.

## 🛠️ Tech Stack
* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Test Framework:** TestNG
* **Design Pattern:** Page Object Model (POM)
* **External Tool:** AutoIt (for Windows GUI interaction)
* **Build Tool:** Maven

## 📋 Prerequisites
* Java JDK 11 or higher
* Maven installed
* Google Chrome (latest version)
* Compiled AutoIt script (`.exe`) located in the path specified in `config.properties`

## ⚙️ Configuration
Update the `src/test/resources/config.properties` file with your local paths:
```properties
browser=chrome
url=[https://automationexercise.com/login](https://automationexercise.com/login)
autoit_path=C:/path/to/your/upload_script.exe
image_path=C:/path/to/your/test_image.jpg
```

## 🏃 How to Run
1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/dhathri25/HClMiniProject-E-commerce.git](https://github.com/dhathri25/HClMiniProject-E-commerce.git)
    ```
2.  **Run via Maven:**
    ```bash
    mvn clean test
    ```
3.  **Run via TestNG:**
    Right-click `testng.xml` in Eclipse and select **Run As > TestNG Suite**.

## 📁 Project Structure
* `src/main/java/pages`: Contains Page Objects.
* `src/test/java/tests`: Contains the TestNG test classes.
* `src/main/java/utils`: Utility classes for File Upload, Configuration, and Drivers.

## ✨ Key Features
* **Dynamic Data Generation:** Uses `System.currentTimeMillis()` to generate unique emails, ensuring the Signup test never fails due to duplicate accounts.
* **Robust Navigation:** Uses direct URL routing and explicit waits (2s) to bypass flaky home-page overlays and advertisements.
* **Hybrid Automation:** Combines Selenium (Web) with AutoIt (Windows GUI) to handle file uploads that standard Selenium cannot reach.
* **Page Object Model:** Ensures high maintainability; changing a locator in one page class updates the entire test suite.

## ⚠️ Troubleshooting
* **AutoIt Fails:** Ensure the `autoit_path` in `config.properties` points to the `.exe` file, not the `.au3` source code.
* **Browser Version:** If you get a "SessionNotCreated" error, update your `pom.xml` Selenium version or download the matching `chromedriver.exe`.
* **GitHub Push:** Remember to use your **Personal Access Token (PAT)** as the password when pushing from Eclipse.
