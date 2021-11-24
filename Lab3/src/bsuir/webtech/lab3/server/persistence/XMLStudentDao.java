package bsuir.webtech.lab3.server.persistence;

import bsuir.webtech.lab3.server.business.StudentService;
import bsuir.webtech.lab3.shared.Student;
import bsuir.webtech.lab3.shared.StudentScantyInfo;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLStudentDao extends StudentService {

    private final String filePath;

    private final List<Student> students;

    public XMLStudentDao(String filePath) {
        this.filePath = filePath;

        students = new ArrayList<>();

        try {
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filePath)));
            while (true) {
                try {
                    Student student = (Student) decoder.readObject();
                    students.add(student);
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }
        } catch (FileNotFoundException ignored) {

        }
    }

    @Override
    public Student getStudentById(int id) {

        if (id < 0) {
            return null;
        }

        synchronized (students) {
            if (id >= students.size()) {
                return null;
            }

            return students.get(id);
        }
    }

    @Override
    public List<StudentScantyInfo> getStudentsScantyInfo() {
        List<StudentScantyInfo> studentsScantyInfo = new ArrayList<>();
        synchronized (students) {
            for (Student student : students) {
                studentsScantyInfo.add(student.getScantyInfo());
            }
        }
        return studentsScantyInfo;
    }

    @Override
    public void updateStudent(Student student) {
        if (student.getId() < 0) {
            return;
        }

        synchronized (students) {
            if (student.getId() >= students.size()) {
                return;
            }

            students.set(student.getId(), student);
        }
    }

    @Override
    public void createStudent(Student student) {
        synchronized (students) {
            student.setId(students.size());
            students.add(student);
        }
    }

    public void saveAll() {
        try {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filePath)));
            for (Student student : students) {
                encoder.writeObject(student);
            }
            encoder.close();
        } catch (FileNotFoundException ignored) {

        }
    }
}
