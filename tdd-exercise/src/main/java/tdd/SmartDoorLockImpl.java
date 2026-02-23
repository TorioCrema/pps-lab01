package tdd;

import java.util.Optional;
import java.util.concurrent.locks.Lock;

public class SmartDoorLockImpl implements SmartDoorLock{

    private static final int MAX_PIN = 9999;
    private static final int MIN_PIN = 0;
    private Optional<Integer> pin = Optional.empty();
    private LockState state = LockState.OPEN;
    private int failCounter;

    @Override
    public void setPin(int pin) {
        if (pin <= MAX_PIN && pin >= MIN_PIN) {
            this.pin = Optional.of(pin);
        }
    }

    @Override
    public void unlock(int pin) {
        if (this.pin.isEmpty()) {
            return;
        }
        if (this.pin.get().equals(pin)) {
            this.state = LockState.OPEN;
        } else {
            this.failCounter++;
        }
    }

    @Override
    public void lock() {
        if (this.pin.isEmpty()) {
            throw new IllegalStateException("Cannot lock without pin");
        }
        this.state = LockState.LOCKED;
    }

    @Override
    public boolean isLocked() {
        return this.state.equals(LockState.LOCKED);
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return this.failCounter;
    }

    @Override
    public void reset() {

    }
}
