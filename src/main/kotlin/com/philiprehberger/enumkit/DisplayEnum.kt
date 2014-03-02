package com.philiprehberger.enumkit

/** Interface for enums with human-readable display names. */
public interface DisplayEnum {
    public val displayName: String
}

/** Returns the enum constant matching [displayName], or throws. */
public inline fun <reified T> fromDisplayName(displayName: String): T where T : Enum<T>, T : DisplayEnum {
    return fromDisplayNameOrNull(displayName)
        ?: throw IllegalArgumentException("No ${T::class.simpleName} with displayName '$displayName'")
}

/** Returns the enum constant matching [displayName], or `null`. */
public inline fun <reified T> fromDisplayNameOrNull(displayName: String): T? where T : Enum<T>, T : DisplayEnum {
    return enumValues<T>().firstOrNull { it.displayName == displayName }
}
