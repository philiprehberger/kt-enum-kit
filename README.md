# enum-kit

[![CI](https://github.com/philiprehberger/kt-enum-kit/actions/workflows/publish.yml/badge.svg)](https://github.com/philiprehberger/kt-enum-kit/actions/workflows/publish.yml)
[![Maven Central](https://img.shields.io/maven-central/v/com.philiprehberger/enum-kit)](https://central.sonatype.com/artifact/com.philiprehberger/enum-kit)

Enhanced enum utilities: safe parsing, display names, and value mapping.

## Requirements

- Kotlin 1.9+ / Java 17+

## Installation

### Gradle (Kotlin DSL)

```kotlin
dependencies {
    implementation("com.philiprehberger:enum-kit:0.1.0")
}
```

### Maven

```xml
<dependency>
    <groupId>com.philiprehberger</groupId>
    <artifactId>enum-kit</artifactId>
    <version>0.1.0</version>
</dependency>
```

## Usage

### Safe Parsing

```kotlin
import com.philiprehberger.enumkit.*

enum class Color { RED, GREEN, BLUE }

valueOfOrNull<Color>("RED")                    // Color.RED
valueOfOrNull<Color>("invalid")                // null
valueOfOrNull<Color>("red", ignoreCase = true) // Color.RED
```

### Display Names

```kotlin
enum class Status(override val displayName: String) : DisplayEnum {
    PENDING("Pending"), IN_PROGRESS("In Progress");
}

fromDisplayName<Status>("In Progress") // Status.IN_PROGRESS
```

### Value Mapping

```kotlin
enum class Priority(override val value: Int) : ValueEnum<Int> {
    LOW(0), NORMAL(1), HIGH(2);
}

fromValue<Priority, Int>(2) // Priority.HIGH
```

### Navigation

```kotlin
Color.RED.next()      // Color.GREEN
Color.BLUE.next()     // Color.RED (wraps)
enumNames<Color>()    // ["RED", "GREEN", "BLUE"]
```

## API

| Function / Class | Description |
|------------------|-------------|
| `valueOfOrNull<T>(name, ignoreCase)` | Safe enum parsing, returns `null` instead of throwing |
| `enumNames<T>()` | List all enum constant names |
| `enumRandom<T>()` | Random enum constant |
| `T.next()` / `T.previous()` | Navigate enum constants (wraps around) |
| `DisplayEnum` | Interface for human-readable display names |
| `fromDisplayName<T>(name)` | Look up by display name |
| `ValueEnum<V>` | Interface for custom backing values |
| `fromValue<T, V>(value)` | Look up by backing value |
| `enumSetOf(vararg)` | Create a Set of enum constants |

## Development

```bash
./gradlew test       # Run tests
./gradlew build      # Build JAR
```

## License

MIT
