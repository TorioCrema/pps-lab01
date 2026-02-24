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
        return 0;
    }

    @Override
    public int getMin() {
        return 0;
    }

    @Override
    public int getMax() {
        return 0;
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
