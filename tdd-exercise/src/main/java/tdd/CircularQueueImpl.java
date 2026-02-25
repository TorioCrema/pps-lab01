package tdd;

public class CircularQueueImpl implements CircularQueue {
    private static final int DEFAULT_CAPACITY = 5;
    private final int capacity;

    /**
     * Creates a circular queue with given maximum capacity.
     *
     * @param capacity The maximum capacity of the queue.
     */
    public CircularQueueImpl(final int capacity) {
        this.capacity = capacity;
    }

    public CircularQueueImpl() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }
}
