package com.philiprehberger.enumkit

import kotlin.test.*

enum class Color { RED, GREEN, BLUE }

class EnumExtensionsTest {
    @Test fun `valueOfOrNull valid`() = assertEquals(Color.RED, valueOfOrNull<Color>("RED"))
    @Test fun `valueOfOrNull invalid`() = assertNull(valueOfOrNull<Color>("YELLOW"))
    @Test fun `valueOfOrNull ignoreCase`() = assertEquals(Color.RED, valueOfOrNull<Color>("red", ignoreCase = true))
    @Test fun `enumNames`() = assertEquals(listOf("RED", "GREEN", "BLUE"), enumNames<Color>())
    @Test fun `enumRandom`() { assertTrue(enumRandom<Color>() in Color.entries) }
    @Test fun `next wraps`() { assertEquals(Color.GREEN, Color.RED.next()); assertEquals(Color.RED, Color.BLUE.next()) }
    @Test fun `previous wraps`() { assertEquals(Color.BLUE, Color.RED.previous()); assertEquals(Color.GREEN, Color.BLUE.previous()) }
    @Test fun `enumContains valid`() = assertTrue(enumContains<Color>("RED"))
    @Test fun `enumContains invalid`() = assertFalse(enumContains<Color>("YELLOW"))
    @Test fun `enumContains ignoreCase`() = assertTrue(enumContains<Color>("red", ignoreCase = true))
    @Test fun `enumContains ignoreCase false`() = assertFalse(enumContains<Color>("red"))
}
