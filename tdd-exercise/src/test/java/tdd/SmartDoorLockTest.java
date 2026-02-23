package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    private SmartDoorLock lock;

    @BeforeEach
    public void beforeEach() {
        this.lock = new SmartDoorLockImpl();
    }
    @Test
    public void testSmartDoorLockInitialState() {
        assertFalse(this.lock.isLocked());
        assertFalse(this.lock.isBlocked());
    }

    @Test
    public void testSmartDoorLockLockThrowsException() {
        assertThrows(IllegalStateException.class, this.lock::lock);
    }

    @Test
    public void testSmartDoorLockSetPinAndLockAndUnlock() {
        final int pin = 1234;
        this.lock.setPin(pin);
        this.lock.lock();
        assertTrue(this.lock.isLocked());
        this.lock.unlock(pin);
        assertFalse(this.lock.isLocked());
    }

    @Test
    public void testSmartDoorLockIncorrectPin() {
        final int correctPin = 1234;
        final int incorrectPin = 1111;
        this.lock.setPin(correctPin);
        this.lock.lock();
        this.lock.unlock(incorrectPin);
        assertTrue(this.lock.isLocked());
    }

    @Test
    public void testSmartDoorLockInvalidPin() {
        final int invalidPinTooGreat = 10_000;
        final int invalidPinTooSmall = -1;
        this.lock.setPin(invalidPinTooGreat);
        assertThrows(IllegalStateException.class, lock::lock);
        this.lock.setPin(invalidPinTooSmall);
        assertThrows(IllegalStateException.class, lock::lock);
    }
}
