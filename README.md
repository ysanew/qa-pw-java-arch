# Playwright Java Test Automation Framework

This repository contains a test automation framework built with Playwright for Java, designed to test the [Sauce Demo](https://www.saucedemo.com/) web application. The framework follows modern test automation practices and design patterns to provide a maintainable, scalable, and efficient testing solution.

## Technologies Used

- **Java 11+**: Programming language
- **Playwright**: Browser automation library
- **JUnit 5**: Test runner with parallel execution support
- **Gradle**: Build and dependency management
- **Allure**: Test reporting
- **Lombok**: Reduces boilerplate code
- **Owner**: Type-safe configuration management
- **SLF4J**: Logging facade

## Project Structure

```
src/
├── test/
│   ├── java/
│   │   ├── com/
│   │   │   ├── components/       # Reusable UI components
│   │   │   ├── config/           # Configuration management
│   │   │   ├── models/           # Data models
│   │   │   ├── pages/            # Page objects
│   │   │   ├── tests/            # Test classes
│   │   │   └── utils/            # Utility classes
│   └── resources/
│       ├── allure.properties     # Allure configuration
│       ├── config.properties     # Framework configuration
│       └── junit-platform.properties # JUnit configuration
```

## Architecture and Design Patterns

The framework implements several design patterns:

1. **Page Object Model (POM)**: Each page of the application is represented by a class that encapsulates the page's elements and actions.
2. **Component Object Pattern**: Reusable UI components (like headers, menus) are encapsulated in separate classes.
3. **Factory Pattern**: Used for creating page objects and browser instances.
4. **Builder Pattern**: Used for creating complex objects (e.g., ShipInfo).
5. **Fluent Interface**: Method chaining for more readable test code.

## Parallel Execution

The framework supports parallel test execution using JUnit 5's parallel execution features:
- Tests within the same class run in the same thread
- Different test classes run concurrently
- Dynamic strategy with a factor of 0.5 (uses approximately half of available processors)

## Setup Instructions

### Prerequisites

- Java 11 or higher
- Gradle

### Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd pw-java-arch
   ```

2. Install Playwright browsers:
   ```bash
   ./gradlew installPlaywrightBrowsers
   ```

## Running Tests

### Run all tests

```bash
./gradlew test
```

### Run specific test class

```bash
./gradlew test --tests "com.tests.LoginTest"
```

### Generate Allure Report

```bash
./gradlew allureReport
./gradlew allureServe  # Opens the report in your browser
```

## Configuration

The framework can be configured through the `src/test/resources/config.properties` file:

- `base.url`: Application URL
- `browser`: Browser to use (chromium, firefox, webkit)
- `headless`: Run in headless mode (true/false)
- `slow.motion`: Slow down test execution for debugging (in milliseconds)
- `timeout`: Default timeout for actions (in milliseconds)
- `video`: Enable/disable video recording (true/false)

## Features

- **Cross-browser Testing**: Support for Chromium, Firefox, and WebKit
- **Video Recording**: Automatic recording of test execution
- **Screenshot on Failure**: Automatic screenshot capture when tests fail
- **Parallel Execution**: Run tests in parallel for faster execution
- **Comprehensive Reporting**: Detailed Allure reports with environment information
- **Type-safe Configuration**: Using Owner library for type-safe configuration management

## Implemented Test Cases

1. **Login Tests**:
   - Successful login with valid credentials
   - Failed login with invalid credentials

2. **Products Tests**:
   - Logout functionality
   - Product sorting
   - Complete checkout flow (add to cart, checkout, fill shipping info, complete order)

