package bsuir.webtech.lab3.client.business;

import bsuir.webtech.lab3.shared.Student;
import bsuir.webtech.lab3.shared.StudentScantyInfo;

import java.io.IOException;
import java.util.List;

public abstract class StudentService {
    public abstract Student getStudentById(int id) throws IOException;
    public abstract List<StudentScantyInfo> getStudentsScantyInfo() throws IOException;
    public abstract void updateStudent(Student student) throws IOException;
    public abstract void createStudent(Student student) throws IOException;
}
