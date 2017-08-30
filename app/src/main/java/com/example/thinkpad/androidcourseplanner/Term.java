package com.example.thinkpad.androidcourseplanner;

import java.util.ArrayList;

/**
 * Created by kgrover on 2017-08-30.
 */

public class Term {
    private int termNumber;
    private int year;
    private ArrayList<Course> listOfCourses;
    TermDB mTermDB = TermDB.getSingletonInstance();

    public Term(int termNumber, int year){
        //TODO: Add in a check to see if term with these traits already exists in termDB
        //      if it does than return the existing term object
        this.termNumber = termNumber;
        this.year = year;
        listOfCourses = new ArrayList<>();
    }

    public int getYear(){
        return year;
    }

    public int getTermNumber(){
        return termNumber;
    }

    public void addCourse(Course course){
        listOfCourses.add(course);
    }

    public ArrayList<Course> getListOfCourses(){
        return listOfCourses;
    }
}