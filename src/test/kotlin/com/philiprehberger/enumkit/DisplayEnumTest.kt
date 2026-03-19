package com.philiprehberger.enumkit

import kotlin.test.*

enum class OrderStatus(override val displayName: String) : DisplayEnum {
    PENDING("Pending"), IN_PROGRESS("In Progress"), SHIPPED("Shipped");
}

class DisplayEnumTest {
    @Test fun `fromDisplayName`() = assertEquals(OrderStatus.IN_PROGRESS, fromDisplayName<OrderStatus>("In Progress"))
    @Test fun `fromDisplayNameOrNull null`() = assertNull(fromDisplayNameOrNull<OrderStatus>("Unknown"))
    @Test fun `fromDisplayName throws`() { assertFailsWith<IllegalArgumentException> { fromDisplayName<OrderStatus>("Unknown") } }
}
