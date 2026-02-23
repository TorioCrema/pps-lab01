package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    private static final int DEFAULT_TEST_PIN = 1234;
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
        this.setDefaultTestPinAndLock();
        assertTrue(this.lock.isLocked());
        this.lock.unlock(DEFAULT_TEST_PIN);
        assertFalse(this.lock.isLocked());
    }

    @Test
    public void testSmartDoorLockIncorrectPin() {
        final int incorrectPin = 1111;
        this.setDefaultTestPinAndLock();
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

    @Test
    public void testSmartDoorLockFailAttemptsCounterIncrements() {
        final int incorrectPin = 1111;
        this.setDefaultTestPinAndLock();
        assertEquals(0, this.lock.getFailedAttempts());
        this.lock.unlock(incorrectPin);
        assertEquals(1, this.lock.getFailedAttempts());
    }

    @Test
    public void testSmartDoorLockBlockState() {
        this.setDefaultTestPinAndLock();
        this.blockLock();
        assertTrue(this.lock.isBlocked());
    }

    @Test
    public void testSmartDoorLockResets() {
        this.setDefaultTestPinAndLock();
        this.blockLock();
        this.lock.reset();
        assertFalse(this.lock.isLocked());
        assertFalse(this.lock.isBlocked());
        assertEquals(0, this.lock.getFailedAttempts());
    }

    private void setDefaultTestPinAndLock() {
        this.lock.setPin(DEFAULT_TEST_PIN);
        this.lock.lock();
    }

    private void blockLock() {
        final int incorrectPin = 1111;
        IntStream.range(0, this.lock.getMaxAttempts()).forEach(x -> this.lock.unlock(incorrectPin));
    }
}
