# Changelog
## 0.1.2 (2026-03-20)- Standardize README: fix title, badges, version sync, remove Requirements section

## [0.1.1] - 2026-03-18

- Upgrade to Kotlin 2.0.21 and Gradle 8.12
- Enable explicitApi() for stricter public API surface
- Add issueManagement to POM metadata

## [0.1.0] - 2026-03-18

### Added

- `valueOfOrNull()` safe enum parsing with case-insensitive option

- `DisplayEnum` interface with bidirectional display name lookup

- `ValueEnum<T>` interface with custom backing value lookup

- `next()` / `previous()` navigation extensions

- `enumNames()`, `enumRandom()`, `enumSetOf()` utilities
