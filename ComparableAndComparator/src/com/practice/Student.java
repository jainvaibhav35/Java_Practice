package com.practice;

import java.util.List;

public class Student implements Comparable{

    private int rollNo ;
    private String name ;
    private SubStudent subStudent ;

    public Student(int rollNo, String name, SubStudent subStudent) {
        this.rollNo = rollNo;
        this.name = name;
        this.subStudent = subStudent;
    }

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SubStudent getSubStudent() {
        return subStudent;
    }

    public void setSubStudent(SubStudent subStudent) {
        this.subStudent = subStudent;
    }

    @Override
    public int compareTo(Object o) {

        if (this.subStudent.getSubrRollNumber() < ((Student)o).getSubStudent().getSubrRollNumber())
            return -1;
        else if (this.subStudent.getSubrRollNumber() > ((Student)o).getSubStudent().getSubrRollNumber())
            return 1;
        else
            return 0;

    }
}
