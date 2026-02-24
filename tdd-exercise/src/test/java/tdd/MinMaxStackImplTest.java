package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    private MinMaxStack stack;

    @BeforeEach
    public void beforeEach() {
        this.stack = new MinMaxStackImpl();
    }

    @Test
    public void testStackIsInitiallyEmpty() {
        assertTrue(this.stack.isEmpty());
    }

    @Test
    public void testPopThrowsWhenEmpty() {
        assertThrows(IllegalStateException.class, this.stack::pop);
    }

    @Test
    public void testPeekThrowsWhenEmpty() {
        assertThrows(IllegalStateException.class, this.stack::peek);
    }

    @Test
    public void testGetMinThrowsWhenEmpty() {
        assertThrows(IllegalStateException.class, this.stack::getMin);
    }

    @Test
    public void testGetMaxThrowsWhenEmpty() {
        assertThrows(IllegalStateException.class, this.stack::getMax);
    }
}