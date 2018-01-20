package com.practice;

public class SubStudent {

    private int subrRollNumber ;
    private String subName  ;


    public SubStudent(int subrRollNumber, String subName) {
        this.subrRollNumber = subrRollNumber;
        this.subName = subName;
    }

    public int getSubrRollNumber() {
        return subrRollNumber;
    }

    public void setSubrRollNumber(int subrRollNumber) {
        this.subrRollNumber = subrRollNumber;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }
}
