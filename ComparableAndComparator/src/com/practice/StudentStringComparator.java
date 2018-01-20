package com.practice;

import java.util.Comparator;

public class StudentStringComparator implements Comparator{

    private int rollNo ;
    private String name ;
    private SubStudent subStudent ;

    public StudentStringComparator(int rollNo, String name, SubStudent subStudent) {
        this.rollNo = rollNo;
        this.name = name;
        this.subStudent = subStudent;
    }

    public StudentStringComparator() {
    }

    public StudentStringComparator(String name) {
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
    public int compare(Object o1, Object o2) {

        return ((StudentComparator)o1).getName().compareTo(((StudentComparator)o2).getName()) ;
    }
}
