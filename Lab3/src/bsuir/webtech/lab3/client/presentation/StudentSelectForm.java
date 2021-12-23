package bsuir.webtech.lab3.client.presentation;

import bsuir.webtech.lab3.client.business.StudentService;
import bsuir.webtech.lab3.shared.StudentScantyInfo;

import java.io.IOException;
import java.util.List;

public class StudentSelectForm {
    private final UserIO userIO;
    private final StudentService studentService;

    public StudentSelectForm(UserIO userIO, StudentService studentService) {
        this.userIO = userIO;
        this.studentService = studentService;
    }

    public StudentScantyInfo show() throws IOException {
        List<StudentScantyInfo> studentsScantyInfo = studentService.getStudentsScantyInfo();
        int index = 1;
        for(StudentScantyInfo studentScantyInfo : studentsScantyInfo) {
            userIO.print(String.format("%d. %s\n", index++, studentScantyInfo.toString()));
        }
        userIO.print("\n0. Назад\n");

        int selected = userIO.getIntInBoundaries(0, studentsScantyInfo.size()) - 1;

        if (selected == -1) {
            return null;
        }

        return studentsScantyInfo.get(selected);
    }
}
