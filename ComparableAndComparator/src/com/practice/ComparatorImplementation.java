package com.practice;

import java.util.*;

public class ComparatorImplementation {


    StudentComparator studentOne ;
    StudentComparator studentTwo ;
    StudentComparator studentThree ;

    public static void main(String[] args){

        new ComparatorImplementation().useComparableToSort();

    }

    public void useComparableToSort(){


        SubStudent subStu1 = new SubStudent(3,"raju");
        SubStudent subStu2 =new SubStudent(1,"raju");
        SubStudent subStu3 =new SubStudent(2,"raju");

        List<StudentComparator> arrList = new ArrayList<>();

        studentOne = new StudentComparator(4,"Vaibhav",subStu2);
        studentTwo = new StudentComparator(3,"Sulabh",subStu3);
//        studentThree = new StudentComparator(2,"Amar",subStu1);

        arrList.add(studentOne);
        arrList.add(studentTwo);
//        arrList.add(studentThree);

        Collections.sort(arrList,new StudentComparator());

        /**
         * here output order is
         *
         * Vaibhav
         * Sulabh
         * Amar
         */
        for(StudentComparator student : arrList){
            System.out.println("Roll No is " + student.getName());
        }

        /**
         * First of all comparator has sort data usign the logic behind
         * StudentComparator() , has our data set for StudentComparator has two same roll number
         * so after that it sort two records having the same roll number on the basis of
         * second comparator that's why it return alphabatical order on the basis of
         * name
         *
         */

        Collections.sort(arrList,new StudentComparator());


        /**
         * Here output is
         * Sulabh
         * Vaibhav
         * Amar
         *
         * Because second comparator i.e string comparator furhter sort the object which
         * are equal on the basis of first comparator as rollNo is same,
         *
         * Vaibhav and Sulabh are sorted alphabitecally as result is discussed
         *
         */
        for(StudentComparator student : arrList){
            System.out.println("Roll No is " + student.getName());
        }

    }

}
