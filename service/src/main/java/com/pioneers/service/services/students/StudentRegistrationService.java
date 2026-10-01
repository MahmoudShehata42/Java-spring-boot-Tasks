package com.pioneers.service.services.students;

import com.pioneers.service.models.entities.Student;
import com.pioneers.service.utils.validators.ValidationRulesService;

public class StudentRegistrationService {

    public boolean validateStudent(final Student student) {
        if (student == null) {
            return false;
        }

        return ValidationRulesService.isValidStudentRegistration(student.getFullName(), student.getAge());
    }

    public void registerStudent(final Student student, final Runnable onSuccess, final Runnable onFailure) {
        if (validateStudent(student)) {
            if (onSuccess != null) {
                onSuccess.run();
            }
            return;
        }

        if (onFailure != null) {
            onFailure.run();
        }
    }

    public void registerStudent(final String name, final int age, final Runnable onSuccess, final Runnable onFailure) {
        if (ValidationRulesService.isValidStudentRegistration(name, age)) {
            if (onSuccess != null) {
                onSuccess.run();
            }
            return;
        }

        if (onFailure != null) {
            onFailure.run();
        }
    }
}
