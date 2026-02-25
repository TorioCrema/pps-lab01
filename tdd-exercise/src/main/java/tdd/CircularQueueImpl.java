package tdd;

import java.util.ArrayList;
import java.util.List;

public class CircularQueueImpl implements CircularQueue {

    private final int capacity = 5;
    private final List<Integer> list = new ArrayList<>();

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
        if (this.list.size() > this.capacity) {
            this.pop();
        }
    }

    @Override
    public int peek() {
        this.throwIfEmpty("Cannot peek when queue is empty.");
        return this.list.get(0);
    }

    @Override
    public int pop() {
        this.throwIfEmpty("Cannot pop when queue is empty.");
        return this.list.remove(0);
    }

    private void throwIfEmpty(final String message) {
        if (this.isEmpty()) {
            throw new IllegalStateException(message);
        }
    }
}
