package tdd;

import java.util.Optional;
import java.util.concurrent.locks.Lock;

public class SmartDoorLockImpl implements SmartDoorLock{

    private Optional<Integer> pin = Optional.empty();
    private LockState state = LockState.OPEN;

    @Override
    public void setPin(int pin) {
        this.pin = Optional.of(pin);
    }

    @Override
    public void unlock(int pin) {
        if (this.pin.isPresent() && this.pin.get().equals(pin)) {
            this.state = LockState.OPEN;
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
        return 0;
    }

    @Override
    public void reset() {

    }
}
