package bsuir.webtech.lab3.client.presentation;

import bsuir.webtech.lab3.client.business.StudentService;
import bsuir.webtech.lab3.shared.FullName;
import bsuir.webtech.lab3.shared.Student;

import java.io.IOException;

public class StudentFileCreate {
    private final UserIO userIO;
    private final StudentService studentService;

    public StudentFileCreate(UserIO userIO, StudentService studentService) {
        this.userIO = userIO;
        this.studentService = studentService;
    }

    public void show() throws IOException {
        Student student = new Student();
        FullName fullName = new FullName();

        userIO.print("Введите имя");
        fullName.setName(userIO.getString());
        userIO.print("\n");

        userIO.print("Введите фамилию");
        fullName.setSurname(userIO.getString());
        userIO.print("\n");

        userIO.print("Введите отчество");
        fullName.setPatronymic(userIO.getString());
        userIO.print("\n");

        student.setFullName(fullName);

        userIO.print("Введите группу");
        student.setGroup(userIO.getString());
        userIO.print("\n");

        userIO.print("Введите год рождения");
        student.setYearOfBirth(userIO.getInt());
        userIO.print("\n");

        userIO.print("Введите пол");
        student.setGender(userIO.getChar());
        userIO.print("\n");

        userIO.print("Введите телефон");
        student.setPhoneNumber(userIO.getString());
        userIO.print("\n");

        userIO.print("Введите адрес");
        student.setAddress(userIO.getString());

        studentService.createStudent(student);
        userIO.print("\n");
    }
}
