package bsuir.webtech.lab3.client.presentation;

import bsuir.webtech.lab3.shared.Student;

public class StudentFile {
    private final UserIO userIO;
    private final Student student;
    private final boolean waitForInput;

    public StudentFile(UserIO userIO, Student student, boolean waitForInput) {
        this.userIO = userIO;
        this.student = student;
        this.waitForInput = waitForInput;
    }

    public void show() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Имя: %s\n", student.getFullName().getName()));
        sb.append(String.format("Фамилия: %s\n", student.getFullName().getSurname()));
        sb.append(String.format("Отчество: %s\n", student.getFullName().getPatronymic()));
        sb.append(String.format("Группа: %s\n", student.getGroup() ));

        int yearOfBirth = student.getYearOfBirth();
        sb.append(String.format("Год рождения: %s\n", yearOfBirth != 0 ? yearOfBirth : "???"));

        char gender = student.getGender();
        sb.append(String.format("Пол: %s\n", gender != '\0' ? gender : "???"));

        String phoneNumber = student.getPhoneNumber();
        sb.append(String.format("Телефон: %s\n", phoneNumber != null ? phoneNumber : "???"));

        String address =  student.getAddress();
        sb.append(String.format("Адрес: %s\n", address != null ? address : "???"));

        if (waitForInput) {
            sb.append("\n0. Назад\n");
            userIO.print(sb.toString());

            while (userIO.getInt() != 0) {
                userIO.printError();
            }
        }
        else {
            userIO.print(sb.toString());
        }
    }
}
