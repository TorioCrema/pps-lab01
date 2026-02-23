package tdd;

import java.util.Optional;
import java.util.concurrent.locks.Lock;

public class SmartDoorLockImpl implements SmartDoorLock{

    private static final int MAX_PIN = 9999;
    private static final int MIN_PIN = 0;
    private static final int MAX_FAILED_ATTEMPTS = 3;
    private Optional<Integer> pin = Optional.empty();
    private boolean locked;
    private int failCounter;

    @Override
    public void setPin(int pin) {
        if (pin <= MAX_PIN && pin >= MIN_PIN) {
            this.pin = Optional.of(pin);
        }
    }

    @Override
    public void unlock(int pin) {
        if (this.pin.isEmpty() || this.isBlocked() || !this.isLocked()) {
            return;
        }
        if (this.pin.get().equals(pin)) {
            this.locked = false;
        } else {
            this.failCounter++;
        }
    }

    @Override
    public void lock() {
        if (this.pin.isEmpty()) {
            throw new IllegalStateException("Cannot lock without pin");
        }
        this.locked = true;
    }

    @Override
    public boolean isLocked() {
        return this.locked;
    }

    @Override
    public boolean isBlocked() {
        return this.failCounter >= MAX_FAILED_ATTEMPTS;
    }

    @Override
    public int getMaxAttempts() {
        return MAX_FAILED_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return this.failCounter;
    }

    @Override
    public void reset() {
        this.locked = false;
        this.failCounter = 0;
    }
}
