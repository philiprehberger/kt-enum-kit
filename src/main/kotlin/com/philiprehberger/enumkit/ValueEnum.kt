package com.philiprehberger.enumkit

/** Interface for enums backed by a custom value of type [V]. */
public interface ValueEnum<V> {
    public val value: V
}

/** Returns the enum constant matching [value], or throws. */
public inline fun <reified T, V> fromValue(value: V): T where T : Enum<T>, T : ValueEnum<V> {
    return fromValueOrNull(value)
        ?: throw IllegalArgumentException("No ${T::class.simpleName} with value '$value'")
}

/** Returns the enum constant matching [value], or `null`. */
public inline fun <reified T, V> fromValueOrNull(value: V): T? where T : Enum<T>, T : ValueEnum<V> {
    return enumValues<T>().firstOrNull { it.value == value }
}
