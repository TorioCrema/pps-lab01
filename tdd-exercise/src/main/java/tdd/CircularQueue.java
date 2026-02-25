package tdd;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  <br>
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  <br>
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue {
    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Gets the queue's maximum capacity.
     *
     * @return The maximum capacity of the queue.
     */
    int getCapacity();

    /**
     * Pushes one element in the queue. If adding the new element makes the
     * queue size exceed max capacity the oldest element is removed.
     *
     * @param element The element to push.
     */
    void push(final int element);

    /**
     * Returns the first element in the queue, without removing it.
     *
     * @return The first element in the queue.
     * @throws IllegalStateException if the queue is empty.
     */
    int peek();

    /**
     * Returns the first element in the queue and removes it.
     *
     * @return the first element in the queue.
     * @throws IllegalStateException if the queue is empty.
     */
    int pop();
}