# Selenium POM Framework (TestNG + Allure)
Professional Java Selenium framework built for saucedemo.com example tests.

## Deliverables (what to push to GitHub)
- Source code of the test automation framework (all files in this repo)
- README.md (this file) — contains:
  - How to run the tests
  - Test structure explanation
  - Dependencies and setup instructions
- Allure report (generate locally and add `allure-report` or screenshots folder to repo if you want to include static report)

## How to run locally
1. Requirements:
   - Java 17 or later
   - Maven
   - Chrome browser
2. Run tests:
   ```bash
   mvn clean test
   ```
3. Generate Allure report:
   ```bash
   mvn allure:report
   # or serve locally
   mvn allure:serve
   ```
   After `mvn allure:report`, generated report files will be in `target/site/allure-maven-plugin/index.html`.

## Project structure
```
src/
  main/
    java/
      base/           - BasePage
      drivers/        - DriverFactory
      pages/          - Page objects (Login, Inventory, Cart, Checkout, OrderConfirmation)
      utils/          - ConfigReader, TestListeners
    resources/
      config.properties
  test/
    java/
      tests/          - TestNG test classes
pom.xml
testng.xml
README.md
```

## Tests implemented
- LoginTests: valid and invalid login
- CartTests: add two products and verify cart contents
- CheckoutTests: checkout flow with user details
- LogoutTests: verify logout


## Allure screenshots (recommended)
- The framework already captures screenshots on test failure and attaches them to Allure results.
- After running tests, copy the `allure-results` folder into the repository (or generate the HTML report and include `allure-report` folder) to satisfy the deliverable requirement.

