package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private CircularQueue queue;
    private int default_capacity;

    @BeforeEach
    public void beforeEach() {
        this.queue = new CircularQueueImpl();
        this.default_capacity = 5;
    }

    @Test
    public void testListIsInitiallyEmpty() {
        assertTrue(this.queue.isEmpty());
    }

    @Test
    public void testCapacity() {
        assertEquals(this.default_capacity, this.queue.getCapacity());
    }

    @Test
    public void testPushAndPeek() {
        final int element = 1;
        this.queue.push(element);
        assertFalse(this.queue.isEmpty());
        assertEquals(element, this.queue.peek());
    }

    @Test
    public void testPopRemovesFirstElement() {
        final int element = 1;
        final int lastElement = 2;
        this.queue.push(element);
        this.queue.push(lastElement);
        assertEquals(element, this.queue.pop());
        assertEquals(lastElement, this.queue.peek());
        assertFalse(this.queue.isEmpty());
    }

    @Test
    public void testPushExceedingCapacityRemovesFirstElements() {
        final int numLostElements = 1;
        final int exceedingElement = this.default_capacity + numLostElements;
        IntStream.rangeClosed(1, exceedingElement).forEach(x -> this.queue.push(x));
        IntStream.rangeClosed(1 + numLostElements, exceedingElement).forEach(x -> assertEquals(x, this.queue.pop()));
        assertTrue(this.queue.isEmpty());
    }
}
