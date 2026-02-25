# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Gloomhaven Helper is an Android companion app for the Gloomhaven board game. It tracks teams, characters, scenarios, items, perks, and personal quests using a local Room database.

## Build Commands

```bash
# Build the project
./gradlew build

# Build debug APK
./gradlew assembleDebug

# Run unit tests
./gradlew test

# Run a single unit test class
./gradlew test --tests "com.rumpilstilstkin.gloomhavenhelper.YourTestClass"

# Run instrumented tests (requires connected device/emulator)
./gradlew connectedAndroidTest

# Clean build
./gradlew clean build

# Generate Room schema (exports to app/schemas/)
./gradlew kspDebugKotlin
```

## Architecture

The project follows Clean Architecture with four layers:

- **Presentation** (`screens/`): Jetpack Compose UI + ViewModels with `StateFlow<UiState>`
- **Domain** (`domain/`): Use cases for business logic, entity models
- **Data** (`data/`): Repositories coordinating between domain and persistence
- **Persistence** (`bd/`): Room database with DAOs, entities, and migrations

### Key Patterns

- **Reactive data flow**: Room DAOs return `Flow<Entity>` → Repositories transform to `Flow<DomainModel>` → ViewModels emit `StateFlow<UiState>` → Compose collects via `collectAsStateWithLifecycle()`
- **Navigation**: Type-safe routes defined in `navigation/GlHelperScreens.kt` using `@Serializable` data classes
- **DI**: Hilt with `@Singleton` scope for database, DAOs, and repositories; defined in `di/GlHelperModule.kt`

### Database

- Room database configured in `bd/GlHelperDatabase.kt`
- Schema exports to `app/schemas/` for migration validation
- Migrations in `bd/migrations/DatabaseMigrations.kt` - add to `ALL_MIGRATIONS` array
- **Debug mode uses in-memory database** - data won't persist between restarts

When changing database schema:
1. Increment version in `GlHelperDatabase.kt`
2. Create migration object (e.g., `MIGRATION_1_2`) in `DatabaseMigrations.kt`
3. Add migration to `ALL_MIGRATIONS` array
4. Build to export new schema

## Tech Stack

- Kotlin 2.3, JDK 11
- Jetpack Compose with Material3
- Room 2.8+ for persistence
- Hilt for dependency injection
- Kotlin Coroutines + Flow for async
- Kotlin Serialization for JSON
- KSP for annotation processing

## Project Structure

```
app/src/main/kotlin/com/rumpilstilstkin/gloomhavenhelper/
├── bd/           # Room database, DAOs, entities, migrations
├── data/         # Repositories and datasources
├── di/           # Hilt modules
├── domain/       # Use cases and domain entities
├── navigation/   # Navigation routes and nav host
├── screens/      # Compose screens and ViewModels
├── ui/           # Shared UI components and theme
└── utils/        # Utility functions
```
