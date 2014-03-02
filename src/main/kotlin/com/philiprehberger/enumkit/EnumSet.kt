package com.philiprehberger.enumkit

/** Creates a [Set] containing the specified enum constants. */
public fun <T : Enum<T>> enumSetOf(vararg values: T): Set<T> {
    return if (values.isEmpty()) emptySet() else java.util.EnumSet.copyOf(values.toList())
}
