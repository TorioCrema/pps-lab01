package tdd;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackImpl implements MinMaxStack {
    private final List<Integer> stack = new ArrayList<>();

    @Override
    public void push(int value) {
        this.stack.add(value);
    }

    @Override
    public int pop() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("Cannot pop when empty.");
        } else {
            return this.stack.remove(this.stack.size() - 1);
        }
    }

    @Override
    public int peek() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("Cannot peek when empty.");
        } else {
            return this.stack.get(this.stack.size() - 1);
        }
    }

    @Override
    public int getMin() {
        throw new IllegalStateException("Cannot get minimum value when empty.");
    }

    @Override
    public int getMax() {
        throw new IllegalStateException("Cannot get maximum value when empty.");
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public int size() {
        return this.stack.size();
    }
}
