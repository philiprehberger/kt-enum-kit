package com.philiprehberger.enumkit

import kotlin.test.*

enum class Priority(override val value: Int) : ValueEnum<Int> { LOW(0), NORMAL(1), HIGH(2), CRITICAL(3) }

class ValueEnumTest {
    @Test fun `fromValue`() = assertEquals(Priority.HIGH, fromValue<Priority, Int>(2))
    @Test fun `fromValueOrNull null`() = assertNull(fromValueOrNull<Priority, Int>(99))
    @Test fun `fromValue throws`() { assertFailsWith<IllegalArgumentException> { fromValue<Priority, Int>(99) } }
}
