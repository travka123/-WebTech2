package bsuir.webtech.lab3.client.presentation;

import bsuir.webtech.lab3.client.business.StudentService;
import bsuir.webtech.lab3.shared.Student;

import java.io.IOException;

public class StudentFileUpdate {
    private final UserIO userIO;
    private final StudentService studentService;
    private final Student student;

    public StudentFileUpdate(UserIO userIO, StudentService studentService, Student student) {
        this.userIO = userIO;
        this.studentService = studentService;
        this.student = student;
    }

    public void show() throws IOException {
        String text = """
                2. Изменить имя
                3. Изменить фамилию
                4. Изменить отчество
                5. Изменить группу
                6. Изменить год рождения
                7. Изменить пол
                8. Изменить телефон
                9. Изменить адрес

                1. Сохранить
                0. Назад
                """;


        int selected = askUser(text);
        while (selected != 0) {
            switch (selected) {
                case 1 -> studentService.updateStudent(student);
                case 2 -> student.getFullName().setName(userIO.getString());
                case 3 -> student.getFullName().setSurname(userIO.getString());
                case 4 -> student.getFullName().setPatronymic(userIO.getString());
                case 5 -> student.setGroup(userIO.getString());
                case 6 -> student.setYearOfBirth(userIO.getInt());
                case 7 -> student.setGender(userIO.getChar());
                case 8 -> student.setPhoneNumber(userIO.getString());
                case 9 -> student.setAddress(userIO.getString());
            }
            selected = askUser(text);
        }
    }

    private int askUser(String text) {
        new StudentFile(userIO, student, false).show();
        userIO.print("\n");
        userIO.print(text);
        return userIO.getIntInBoundaries(0, 9);
    }
}
