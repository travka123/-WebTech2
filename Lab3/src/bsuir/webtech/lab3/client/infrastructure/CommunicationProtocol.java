package bsuir.webtech.lab3.client.infrastructure;

import bsuir.webtech.lab3.client.business.StudentService;
import bsuir.webtech.lab3.shared.OperationsCodes;
import bsuir.webtech.lab3.shared.Student;
import bsuir.webtech.lab3.shared.StudentScantyInfo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CommunicationProtocol extends StudentService {

    private final ServerIO serverIO;

    public CommunicationProtocol(ServerIO serverIO) {
        this.serverIO = serverIO;
    }

    @Override
    public Student getStudentById(int id) throws IOException {
        serverIO.out.writeInt(OperationsCodes.getStudentById);
        serverIO.out.writeInt(id);
        return Student.deserialize(serverIO.in);
    }

    @Override
    public List<StudentScantyInfo> getStudentsScantyInfo() throws IOException {
        serverIO.out.writeInt(OperationsCodes.getStudentsScantyInfo);

        int count = serverIO.in.readInt();

        StudentScantyInfo[] studentsScantyInfo = new StudentScantyInfo[count];
        for (int i = 0; i < count; i++) {
            studentsScantyInfo[i] = StudentScantyInfo.deserialize(serverIO.in);
        }

        return Arrays.asList(studentsScantyInfo);
    }

    @Override
    public void updateStudent(Student student) throws IOException {
        serverIO.out.writeInt(OperationsCodes.updateStudent);

        student.serialize(serverIO.out);
    }

    @Override
    public void createStudent(Student student) throws IOException {
        serverIO.out.writeInt(OperationsCodes.createStudent);

        student.serialize(serverIO.out);
    }
}
