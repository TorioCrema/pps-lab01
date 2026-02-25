package tdd;

import java.util.ArrayList;
import java.util.List;

public class CircularQueueImpl implements CircularQueue {
    private static final int DEFAULT_CAPACITY = 5;
    
    private final int capacity;
    private final List<Integer> list = new ArrayList<>();

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
        return this.list.isEmpty();
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public void push(final int element) {
        this.list.add(element);
    }

    @Override
    public int peek() {
        return this.list.get(this.list.size() - 1);
    }
}
