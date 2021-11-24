package bsuir.webtech.lab3.server.protocols;

import bsuir.webtech.lab3.server.business.StudentService;
import bsuir.webtech.lab3.shared.AccessRights;
import bsuir.webtech.lab3.shared.OperationsCodes;
import bsuir.webtech.lab3.shared.Student;
import bsuir.webtech.lab3.shared.StudentScantyInfo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class AuthorizedCommunication {
    private final StudentService studentService;

    public AuthorizedCommunication(StudentService studentService) {
        this.studentService = studentService;
    }

    public void Communicate(DataInputStream in, DataOutputStream out, AccessRights accessRights) throws IOException {
        int opcode = in.readInt();
        while (opcode != OperationsCodes.exit) {
            switch (opcode) {
                case OperationsCodes.getStudentById -> execGetStudentById(in, out, accessRights);
                case OperationsCodes.getStudentsScantyInfo -> execGetStudentsScantyInfo(in, out);
                case OperationsCodes.updateStudent -> execUpdateStudent(in, out, accessRights);
                case OperationsCodes.createStudent -> execCreateStudent(in, out, accessRights);
                default -> throw new IOException();
            }
            opcode = in.readInt();
        }
    }

    private void execCreateStudent(DataInputStream in, DataOutputStream out,
                                   AccessRights accessRights) throws IOException {

        if (!accessRights.canCreate()) {
            throw new IOException();
        }

        studentService.createStudent(Student.deserialize(in));
    }

    private void execUpdateStudent(DataInputStream in, DataOutputStream out,
                                   AccessRights accessRights) throws IOException {

        if (!accessRights.canUpdate()) {
            throw new IOException();
        }

        studentService.updateStudent(Student.deserialize(in));
    }

    private void execGetStudentById(DataInputStream in, DataOutputStream out,
                                    AccessRights accessRights) throws IOException {

        if (!accessRights.canRead()) {
            throw new IOException();
        }

        int id = in.readInt();
        Student student = studentService.getStudentById(id);

        if (student == null) {
            throw new IOException();
        }

        student.serialize(out);
    }

    private void execGetStudentsScantyInfo(DataInputStream in, DataOutputStream out) throws IOException {
        List<StudentScantyInfo> studentsScantyInfo = studentService.getStudentsScantyInfo();

        out.writeInt(studentsScantyInfo.size());

        for (StudentScantyInfo student : studentsScantyInfo) {
            student.serialize(out);
        }
    }
}
