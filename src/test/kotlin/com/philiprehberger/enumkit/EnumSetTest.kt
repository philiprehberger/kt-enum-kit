package com.philiprehberger.enumkit

import kotlin.test.*

class EnumSetTest {
    @Test fun `enumSetOf`() { val s = enumSetOf(Color.RED, Color.BLUE); assertTrue(Color.RED in s); assertFalse(Color.GREEN in s) }
    @Test fun `empty`() = assertEquals(0, enumSetOf<Color>().size)
}
