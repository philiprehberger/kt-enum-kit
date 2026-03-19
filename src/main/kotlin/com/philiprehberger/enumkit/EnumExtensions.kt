package com.philiprehberger.enumkit

/**
 * Returns the enum constant matching [name], or `null` if not found.
 */
public inline fun <reified T : Enum<T>> valueOfOrNull(name: String, ignoreCase: Boolean = false): T? {
    return enumValues<T>().firstOrNull {
        if (ignoreCase) it.name.equals(name, ignoreCase = true) else it.name == name
    }
}

/** Returns all enum constant names. */
public inline fun <reified T : Enum<T>> enumNames(): List<String> = enumValues<T>().map { it.name }

/** Returns a random enum constant. */
public inline fun <reified T : Enum<T>> enumRandom(): T {
    val values = enumValues<T>()
    return values[values.indices.random()]
}

/** Returns the next enum constant, wrapping around. */
public inline fun <reified T : Enum<T>> T.next(): T {
    val values = enumValues<T>()
    return values[(this.ordinal + 1) % values.size]
}

/** Returns the previous enum constant, wrapping around. */
public inline fun <reified T : Enum<T>> T.previous(): T {
    val values = enumValues<T>()
    return values[(this.ordinal - 1 + values.size) % values.size]
}
