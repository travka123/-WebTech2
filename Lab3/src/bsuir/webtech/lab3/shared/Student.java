package bsuir.webtech.lab3.shared;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Student {

    private int id;
    private FullName fullName;
    private String group;
    private char gender;
    private int yearOfBirth;
    private String phoneNumber;
    private String address;

    public Student() {

    }

   public Student(StudentScantyInfo studentScantyInfo) {
       id = studentScantyInfo.getId();
       fullName = studentScantyInfo.getFullName();
       group = studentScantyInfo.getGroup();
   }

    public Student(int id, FullName fullName, String group, char gender, int yearOfBirth, String phoneNumber, String address) {
        this.id = id;
        this.fullName = fullName;
        this.group = group;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isValid() {
        return fullName.isValid() && (group != null) && (gender != '\0') && (yearOfBirth != 0) &&
                (phoneNumber != null) && (address != null);
    }


    public StudentScantyInfo getScantyInfo() {
        return new StudentScantyInfo(id, fullName, group);
    }

    public static Student deserialize(DataInputStream inputStream) throws IOException {
        int id = inputStream.readInt();
        FullName fullName = FullName.deserialize(inputStream);
        String group = inputStream.readUTF();
        char gender = inputStream.readChar();
        int yearOfBirth = inputStream.readInt();
        String phoneNumber = inputStream.readUTF();
        String address = inputStream.readUTF();
        return new Student(id, fullName, group, gender, yearOfBirth, phoneNumber, address);
    }

    public void serialize(DataOutputStream outputStream) throws IOException {
        outputStream.writeInt(id);
        fullName.serialize(outputStream);
        outputStream.writeUTF(group);
        outputStream.writeChar(gender);
        outputStream.writeInt(yearOfBirth);
        outputStream.writeUTF(phoneNumber);
        outputStream.writeUTF(address);
    }
}
