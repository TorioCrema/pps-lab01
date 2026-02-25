package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    @Test
    public void testListIsInitiallyEmpty() {
        final CircularQueue queue = new CircularQueueImpl();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testCapacity() {
        final int capacity = 3;
        final CircularQueue queue = new CircularQueueImpl(capacity);
        assertEquals(capacity, queue.getCapacity());
    }
}
