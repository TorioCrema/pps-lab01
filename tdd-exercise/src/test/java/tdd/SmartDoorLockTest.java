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
    public void testSmartDoorLockSetPinAndLock() {
        final int pin = 1234;
        this.lock.setPin(pin);
        this.lock.lock();
        assertTrue(this.lock.isLocked());
    }
}
