package tdd;

public class MinMaxStackImpl implements MinMaxStack {
    @Override
    public void push(int value) {

    }

    @Override
    public int pop() {
        throw new IllegalStateException("Cannot pop when empty.");
    }

    @Override
    public int peek() {
        throw new IllegalStateException("Cannot peek when empty.");
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
        return true;
    }

    @Override
    public int size() {
        return 0;
    }
}
