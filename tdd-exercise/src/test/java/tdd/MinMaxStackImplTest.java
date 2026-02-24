package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    private MinMaxStack stack;
    private int element;
    private int pushTimes;
    private int lastElement;
    private int smallerElement;
    private int biggerElement;

    @BeforeEach
    public void beforeEach() {
        this.stack = new MinMaxStackImpl();
        this.element = 3;
        this.smallerElement = this.element - 1;
        this.biggerElement = this.element + 1;
        this.pushTimes = 5;
        this.lastElement = 2;
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

    @Test
    public void testPeekShowsLastElement() {
        this.stack.push(this.element);
        this.stack.push(this.lastElement);
        assertEquals(this.lastElement, this.stack.peek());
    }

    @Test
    public void testSizeIncreasesAfterPush() {
        this.pushMany(this.pushTimes);
        assertEquals(this.pushTimes, this.stack.size());
    }

    @Test
    public void testPopReturnsLastElement() {
        this.stack.push(this.element);
        this.stack.push(this.lastElement);
        assertEquals(this.lastElement, this.stack.pop());
    }

    @Test
    public void testSizeDecreasesAfterPop() {
        this.pushMany(this.pushTimes);
        this.stack.pop();
        assertEquals(this.pushTimes - 1, this.stack.size());
    }

    @Test
    public void testStackIsNotEmptyAfterPush() {
        this.stack.push(this.element);
        assertFalse(this.stack.isEmpty());
    }

    @Test
    public void testGetMin() {
        this.stack.push(this.element);
        assertEquals(this.element, this.stack.getMin());
        this.stack.push(this.biggerElement);
        assertEquals(this.element, this.stack.getMin());
        this.stack.push(this.smallerElement);
        assertEquals(this.smallerElement, this.stack.getMin());
    }

    @Test
    public void testGetMax() {
        this.stack.push(this.element);
        assertEquals(this.element, this.stack.getMax());
        this.stack.push(this.smallerElement);
        assertEquals(this.element, this.stack.getMax());
        this.stack.push(this.biggerElement);
        assertEquals(this.biggerElement, this.stack.getMax());
    }

    private void pushMany(final int times) {
        IntStream.range(0, times).forEach(x -> this.stack.push(this.element));
    }

    @Test
    public void testPopChangesMaxValue() {
        this.stack.push(this.element);
        this.stack.push(this.biggerElement);
        this.stack.pop();
        assertEquals(this.element, this.stack.getMax());
    }

    @Test
    public void testPopChangesMinValue() {
        this.stack.push(this.element);
        this.stack.push(this.smallerElement);
        this.stack.pop();
        assertEquals(this.element, this.stack.getMin());
    }

}