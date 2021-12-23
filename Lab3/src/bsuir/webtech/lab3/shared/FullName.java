package bsuir.webtech.lab3.shared;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class FullName {
    private String name;
    private String surname;
    private String patronymic;

    public FullName() {

    }

    public FullName(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", surname, name, patronymic);
    }

    public boolean isValid() {
        return (name != null) && (surname != null) && (patronymic != null);
    }

    public static FullName deserialize(DataInputStream inputStream) throws IOException {
        String n = inputStream.readUTF();
        String s = inputStream.readUTF();
        String p = inputStream.readUTF();
        return new FullName(n, s, p);
    }

    public void serialize(DataOutputStream outputStream) throws IOException {
        outputStream.writeUTF(name);
        outputStream.writeUTF(surname);
        outputStream.writeUTF(patronymic);
    }
}
