package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableImplementation{

    Student studentOne ;
    Student studentTwo ;
    Student studentThree ;

    public static void main(String[] args){

        new ComparableImplementation().useComparableToSort();

    }

    public void useComparableToSort(){


        SubStudent subStu1 = new SubStudent(3,"raju");
        SubStudent subStu2 =new SubStudent(1,"raju");
        SubStudent subStu3 =new SubStudent(2,"raju");



        List<Student> arrList = new ArrayList<>();

        studentThree = new Student(3,"Amar",subStu1);
        studentOne = new Student(2,"Vaibhav",subStu2);
        studentTwo = new Student(1,"Sulabh",subStu3);


        arrList.add(studentOne);
        arrList.add(studentTwo);
        arrList.add(studentThree);

        Collections.sort(arrList);

        for(Student student : arrList){
            System.out.println("Roll No is " + student.getSubStudent().getSubrRollNumber());
        }

    }
}
