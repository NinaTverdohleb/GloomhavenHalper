# GloomhavenHalper Development Guidelines

This document provides essential information for developers working on the GloomhavenHalper project.

## Build/Configuration Instructions

### Project Setup

1. **Environment Requirements**:
   - Android Studio Hedgehog (2023.1.1) or newer
   - JDK 11
   - Kotlin 2.1.20
   - Android Gradle Plugin 8.11.1

2. **Build Configuration**:
   - The project uses Gradle with Kotlin DSL for build scripts
   - Version catalogs are used for dependency management in `gradle/libs.versions.toml`
   - Minimum SDK: 31 (Android 12)
   - Target SDK: 34 (Android 14)
   - Compile SDK: 36

3. **Key Dependencies**:
   - Jetpack Compose for UI (Material3)
   - Room for database operations
   - Hilt for dependency injection
   - Kotlin Coroutines for asynchronous operations
   - Kotlin Serialization for JSON parsing

### Important Notes

- The database is currently configured to use an in-memory database in debug mode (`isDebug = true` in GlHelperDatabase.kt). This means data won't persist between app restarts during development.
- The project uses Kotlin Symbol Processing (KSP) for annotation processing with Room and Hilt.

## Testing Information

### Test Configuration

The project uses JUnit 4 for unit testing and the AndroidX Test libraries for instrumented tests:

1. **Unit Tests**:
   - Located in `app/src/test/java/`
   - Run with `./gradlew test` or through Android Studio's test runner
   - Use the standard JUnit 4 annotations (@Test, @Before, etc.)

2. **Instrumented Tests**:
   - Located in `app/src/androidTest/java/`
   - Run with `./gradlew connectedAndroidTest` or through Android Studio
   - Use AndroidJUnit4 runner for tests that need an Android context

### Writing Tests

1. **Unit Test Example**:

```kotlin
class StringUtilsTest {
    @Test
    fun formatGold_returnsFormattedString() {
        // Arrange
        val amount = 100

        // Act
        val result = StringUtils.formatGold(amount)

        // Assert
        org.junit.Assert.assertEquals("100 g", result)
    }
}
```

2. **Testing Guidelines**:
   - Follow the Arrange-Act-Assert pattern
   - Use descriptive test method names (e.g., `methodName_condition_expectedResult`)
   - Test edge cases and boundary conditions
   - Keep tests independent of each other

3. **Testing Use Cases**:
   - For testing use cases that depend on repositories, consider creating test-specific implementations or using a mocking library like Mockito (would need to be added to the project)
   - Example of adding Mockito to the project:
     ```kotlin
     // In app/build.gradle.kts
     dependencies {
         testImplementation("org.mockito:mockito-core:5.4.0")
         testImplementation("org.mockito.kotlin:mockito-kotlin:5.1.0")
     }
     ```

## Additional Development Information

### Architecture

The project follows Clean Architecture principles with the following layers:

1. **Presentation Layer**:
   - Located in `app/src/main/kotlin/com/rumpilstilstkin/gloomhavenhelper/screens/`
   - Uses Jetpack Compose for UI components
   - ViewModels handle UI logic and state management

2. **Domain Layer**:
   - Located in `app/src/main/kotlin/com/rumpilstilstkin/gloomhavenhelper/domain/`
   - Contains business logic in use cases
   - Defines entity models used throughout the application

3. **Data Layer**:
   - Located in `app/src/main/kotlin/com/rumpilstilstkin/gloomhavenhelper/data/`
   - Repositories coordinate data operations
   - Data sources (Room database) handle data persistence

### Navigation

- The app uses Jetpack Navigation Compose for screen navigation
- Navigation routes are defined in `GlHelperScreens.kt`
- The main navigation graph is in `GlHelperNavHost.kt`

### Dependency Injection

- Hilt is used for dependency injection
- Main module is defined in `GlHelperModule.kt`
- Additional modules may be defined for specific features

### Database

- Room is used for database operations
- Database schema is defined in `GlHelperDatabase.kt`
- Entity classes are in `bd/entity/` directory
- DAOs are in `bd/dao/` directory
- Schema migrations should be handled carefully to preserve user data

### Code Style

- Follow Kotlin coding conventions
- Use meaningful variable and function names
- Document public APIs with KDoc comments
- Use extension functions for utility operations on existing classes
- Prefer immutable data structures when possible
