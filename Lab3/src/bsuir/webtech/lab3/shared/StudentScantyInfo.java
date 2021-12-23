package bsuir.webtech.lab3.shared;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class StudentScantyInfo {
    private final int id;
    private final FullName fullName;
    private final String group;

    public StudentScantyInfo(int id, FullName fullName, String group) {
        this.id = id;
        this.fullName = fullName;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public FullName getFullName() {
        return fullName;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return String.format("%s %s", fullName.toString(), group);
    }

    public static StudentScantyInfo deserialize(DataInputStream inputStream) throws IOException {
        int id = inputStream.readInt();
        FullName fullName = FullName.deserialize(inputStream);
        String group = inputStream.readUTF();
        return new StudentScantyInfo(id, fullName, group);
    }

    public void serialize(DataOutputStream outputStream) throws IOException {
        outputStream.writeInt(id);
        fullName.serialize(outputStream);
        outputStream.writeUTF(group);
    }
}
