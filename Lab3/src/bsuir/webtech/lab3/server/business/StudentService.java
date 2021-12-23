package bsuir.webtech.lab3.server.business;

import bsuir.webtech.lab3.shared.Student;
import bsuir.webtech.lab3.shared.StudentScantyInfo;

import java.util.List;

public abstract class StudentService {
    public abstract Student getStudentById(int id);
    public abstract List<StudentScantyInfo> getStudentsScantyInfo();
    public abstract void updateStudent(Student student);
    public abstract void createStudent(Student student);
}
