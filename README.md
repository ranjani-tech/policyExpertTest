# PolicyExpert_bdd
PolicyExpertTechChallenge

**Project scope:**
Create a simple E2E test journey for the given scenario
```
        1. Login to https://insurance.policyexpert.co.uk/home
        2. As a user
        3. I want to get a new policy quote
        4. So that I can get all policy covered
```

```
        Given User is on policy expert quote tool page
        When User is on home page
        Then I should be able to view Go to compare page
```
**About the project**

This project is am implementation of Selenium web automation framework in a page-object oriented architecture.
The different layers and their scope are as follows:

**Layer I: Feature file (Path: [src/test/resources/com/policyexpertquote/web])**

This layer contains feature files where a QA engineer writes simple scenarios in BDD format using Gherkin language.
Feature files increases the speed of writing new automated scenarios by reusing pre-existing scenario steps also allows non-engineering
team members to review test cases without getting into too much technical details.

**Layer II: Step definitions (Path: [src/test/java/com/policyexpertquote/web])**

This layer acts as a glue between scenario steps written in feature-file and their corresponding code execution setup.
The main objective of this layer is to process any/all test scenario inputs and call the relevant functions in page object
classes to cause test execution.

**Layer III: Page layer(Path: [src/main/java/com/policyexpertquote/web/pages])**

This layer converts the action cues received from step definition layer to absolute commands for the base layer.
This layer has two main responsibilities,
1. Locate business/page specific web elements.
2. Execute generic commands for the base action layer using locators and input data from step-definition.

**Layer IV: Base Action layer(Path: [src/main/java/com/policyexpertquote/web/base])**

This layer is free from business/page logic and deals with the technical mechanisms to execute framework specific commands
as required by the page layer. Usually this is the only place where platform specific actions are performed.

**Helper/Utility modules**

- Driver Provider: This class keeps a singleton driver instance to be used at framework specific operations in various test setup, initializers and page object command phases.
- Properties Provider: This class helps load project/test-run specific properties at the start of test execution so that we have a more centralized way of configuring our test environment.   

**How to run:**

Option A:
1. Open the project in IntelliJ Idea
2. Right click on project > Maven > Sync project
3. Open file policyexpertquote.feature
4. Click on "Run test" green play button on the left of the scenario
5. Incase error modify the build configuration glue = "com.policyExpertGoCompare.web"

Option B:
1. Ensure that you have maven cli installed (`brew install maven`)
2. Go to root of project directory
3. Run `mvn clean install test`

**This project is tested on Chrome and Firefox browsers only**
To change browser:
1. Open DriverProvider.java
2. Change parameter passed in `createDriver()` in `initDriver()` method

**Report:**

Refer to the below path for checking surefire report
 `PolicyExpert_bdd/surefire-reports/Cucumber-reports.html`
