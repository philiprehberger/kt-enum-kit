# enum-kit

[![Tests](https://github.com/philiprehberger/kt-enum-kit/actions/workflows/publish.yml/badge.svg)](https://github.com/philiprehberger/kt-enum-kit/actions/workflows/publish.yml)
[![Maven Central](https://img.shields.io/maven-central/v/com.philiprehberger/enum-kit.svg)](https://central.sonatype.com/artifact/com.philiprehberger/enum-kit)
[![Last updated](https://img.shields.io/github/last-commit/philiprehberger/kt-enum-kit)](https://github.com/philiprehberger/kt-enum-kit/commits/main)

Enhanced enum utilities: safe parsing, display names, and value mapping.

## Installation

### Gradle (Kotlin DSL)

```kotlin
implementation("com.philiprehberger:enum-kit:0.2.0")
```

### Maven

```xml
<dependency>
    <groupId>com.philiprehberger</groupId>
    <artifactId>enum-kit</artifactId>
    <version>0.2.0</version>
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

### Membership Checking

```kotlin
enumContains<Color>("RED")                    // true
enumContains<Color>("YELLOW")                 // false
enumContains<Color>("red", ignoreCase = true) // true
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
| `enumContains<T>(name, ignoreCase)` | Check if a name matches any enum constant |
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

## Support

If you find this project useful:

⭐ [Star the repo](https://github.com/philiprehberger/kt-enum-kit)

🐛 [Report issues](https://github.com/philiprehberger/kt-enum-kit/issues?q=is%3Aissue+is%3Aopen+label%3Abug)

💡 [Suggest features](https://github.com/philiprehberger/kt-enum-kit/issues?q=is%3Aissue+is%3Aopen+label%3Aenhancement)

❤️ [Sponsor development](https://github.com/sponsors/philiprehberger)

🌐 [All Open Source Projects](https://philiprehberger.com/open-source-packages)

💻 [GitHub Profile](https://github.com/philiprehberger)

🔗 [LinkedIn Profile](https://www.linkedin.com/in/philiprehberger)

## License

[MIT](LICENSE)
