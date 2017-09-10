package com.example.thinkpad.androidcourseplanner;

import java.util.ArrayList;

public class Term {
    private String termIdentifier;
    private ArrayList<Course> listOfCourses;

    public Term(String identifier){
        //TODO: Add in a check to see if term with these traits already exists in termDB
        //      if it does than return the existing term object
        this.termIdentifier = identifier;
        listOfCourses = new ArrayList<>();
    }

    public String getIdentifier(){ return termIdentifier;}

    void addCourse(Course course){
        listOfCourses.add(course);
    }

    public ArrayList<Course> getListOfCourses(){
        return listOfCourses;
    }

    boolean containsCourse(Course c){
        return listOfCourses.contains(c);
    }

    public ArrayList<String> getAllCourseNames() {
        ArrayList<String> courseList = new ArrayList<>();
        for (Course course : listOfCourses){
            courseList.add(course.getCourseId());
        }
        return courseList;
    }

    public int getCredits(){
        int numCredits = 0;
        for (Course course : listOfCourses){
            numCredits += Integer.parseInt(course.getCredits());
        }
        return numCredits;
    }

    void deleteCourses(){ listOfCourses.clear();}

}