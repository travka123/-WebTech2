package bsuir.webtech.lab3.client.presentation;

import bsuir.webtech.lab3.client.business.AuthorizationService;
import bsuir.webtech.lab3.client.business.StudentService;
import bsuir.webtech.lab3.shared.AccessRights;
import bsuir.webtech.lab3.shared.Student;
import bsuir.webtech.lab3.shared.StudentScantyInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final UserIO userIO;
    private final AuthorizationService authorizationService;
    private final StudentService studentService;

    public Main(UserIO userIO, StudentService studentService, AuthorizationService authorizationAlgorithm) {
        this.userIO = userIO;
        this.authorizationService = authorizationAlgorithm;
        this.studentService = studentService;
    }

    public void show() throws IOException {

            AccessRights accessRights = new LoginForm(userIO, authorizationService).show();

            List<Integer> options = new ArrayList<>();
            String text = BuildMenu(options, accessRights);


            int selected = askUser(options, text);
            while (selected != 0) {
                switch (selected) {
                    case 1 -> ReadStudentFile();
                    case 2 -> UpdateStudentFile(accessRights.canRead());
                    case 3 -> new StudentFileCreate(userIO, studentService).show();
                }
                selected = askUser(options, text);
            }


    }

    private String BuildMenu(List<Integer> options, AccessRights accessRights) {
        StringBuilder stringBuilder = new StringBuilder();

        if (accessRights.canRead()) {
            options.add(1);
            stringBuilder.append(String.format("%d. Получить дело студента\n", options.size()));
        }

        if (accessRights.canUpdate()) {
            options.add(2);
            stringBuilder.append(String.format("%d. Изменить дело студента\n", options.size()));
        }

        if (accessRights.canCreate()) {
            options.add(3);
            stringBuilder.append(String.format("%d. Создать дело студента\n", options.size()));
        }

        stringBuilder.append("\n0. Выход.\n");

        return stringBuilder.toString();
    }

    private int askUser(List<Integer> options, String text) {
        userIO.print(text);
        int selected = userIO.getIntInBoundaries(0, options.size());
        return selected == 0 ? 0 : options.get(selected - 1);
    }

    private void ReadStudentFile() throws IOException {
        StudentSelectForm studentSelectDialog = new StudentSelectForm(userIO, studentService);

        StudentScantyInfo studentScantyInfo = studentSelectDialog.show();
        while (studentScantyInfo != null) {

            new StudentFile(userIO, studentService.getStudentById(studentScantyInfo.getId()), true).show();
            studentScantyInfo = studentSelectDialog.show();;
        }
    }

    private void UpdateStudentFile(boolean canRead) throws IOException {
        StudentSelectForm studentSelectDialog = new StudentSelectForm(userIO, studentService);

        StudentScantyInfo studentScantyInfo = studentSelectDialog.show();
        while (studentScantyInfo != null) {

            Student student;
            if (canRead) {
                student = studentService.getStudentById(studentScantyInfo.getId());
            }
            else {
                student = new Student(studentScantyInfo);
            }
            new StudentFileUpdate(userIO, studentService, student).show();

            studentScantyInfo = studentSelectDialog.show();
        }
    }
}
