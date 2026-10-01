package com.pioneers.service.services.students;

import com.pioneers.service.models.entities.Student;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentRegistrationServiceTest {

    private final StudentRegistrationService service = new StudentRegistrationService();

    @Test
    void shouldInvokeOnSuccessWhenNameAndAgeAreValid() {
        final Student student = Student.builder()
                .fullName("Alice")
                .age(22)
                .build();
        final AtomicBoolean successCalled = new AtomicBoolean(false);
        final AtomicBoolean failureCalled = new AtomicBoolean(false);

        service.registerStudent(student, () -> successCalled.set(true), () -> failureCalled.set(true));

        assertTrue(successCalled.get());
        assertFalse(failureCalled.get());
    }

    @Test
    void shouldInvokeOnFailureWhenNameIsTooShort() {
        final Student student = Student.builder()
                .fullName("Al")
                .age(22)
                .build();
        final AtomicBoolean successCalled = new AtomicBoolean(false);
        final AtomicBoolean failureCalled = new AtomicBoolean(false);

        service.registerStudent(student, () -> successCalled.set(true), () -> failureCalled.set(true));

        assertFalse(successCalled.get());
        assertTrue(failureCalled.get());
    }

    @Test
    void shouldInvokeOnFailureWhenAgeIsOutsideRange() {
        final Student student = Student.builder()
                .fullName("Alice")
                .age(17)
                .build();
        final AtomicBoolean successCalled = new AtomicBoolean(false);
        final AtomicBoolean failureCalled = new AtomicBoolean(false);

        service.registerStudent(student, () -> successCalled.set(true), () -> failureCalled.set(true));

        assertFalse(successCalled.get());
        assertTrue(failureCalled.get());
    }
}
