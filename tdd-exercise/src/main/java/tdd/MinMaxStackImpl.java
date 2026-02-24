package tdd;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackImpl implements MinMaxStack {
    private final List<Integer> stack = new ArrayList<>();
    private int min;
    private int max;

    @Override
    public void push(int value) {
        this.min = this.isEmpty() ? value : Math.min(value, this.min);
        this.max = this.isEmpty() ? value : Math.max(value, this.max);
        this.stack.add(value);
    }

    @Override
    public int pop() {
        this.throwIfEmpty("Cannot pop when empty.");
        final int popped = this.stack.remove(this.stack.size() - 1);
        if (popped == this.max) {
            this.max = this.stack.stream().max((x, y) -> x > y ? x : y).orElseGet(() -> this.max);
        }
        if (popped == this.min) {
            this.min = this.stack.stream().min((x, y) -> x > y ? y : x).orElseGet(() -> this.min);
        }
        return popped;
    }

    @Override
    public int peek() {
        this.throwIfEmpty("Cannot peek when empty.");
        return this.stack.get(this.stack.size() - 1);
    }

    @Override
    public int getMin() {
        this.throwIfEmpty("Cannot get minimum value when empty.");
        return this.min;
    }

    @Override
    public int getMax() {
        this.throwIfEmpty("Cannot get maximum value when empty.");
        return this.max;
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public int size() {
        return this.stack.size();
    }

    private void throwIfEmpty(final String msg) {
        if (this.isEmpty()) {
            throw new IllegalStateException(msg);
        }
    }
}
