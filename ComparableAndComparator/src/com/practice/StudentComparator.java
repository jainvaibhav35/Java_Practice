package com.practice;

import java.util.Comparator;

public class StudentComparator implements Comparator{

    private int rollNo ;
    private String name ;
    private SubStudent subStudent ;

    public StudentComparator(int rollNo, String name, SubStudent subStudent) {
        this.rollNo = rollNo;
        this.name = name;
        this.subStudent = subStudent;
    }

    public StudentComparator() {
    }

    public StudentComparator(String name) {
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

        if(((StudentComparator)o1).getRollNo() < ((StudentComparator)o2).getRollNo()){
            return -1 ;
        }
        else if(((StudentComparator)o1).getRollNo() > ((StudentComparator)o2).getRollNo()){
            return 1 ;
        }else
            return 0;

    }
}
