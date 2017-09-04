package com.example.thinkpad.androidcourseplanner;

import java.util.ArrayList;

public class Term {
    private String termIdentifier;
    private ArrayList<Course> listOfCourses;
    private TermDB mTermDB;

    public Term(String identifier){
        //TODO: Add in a check to see if term with these traits already exists in termDB
        //      if it does than return the existing term object
        this.termIdentifier = identifier;
        listOfCourses = new ArrayList<>();
    }

    public String getIdentifier(){ return this.termIdentifier;}

    void addCourse(Course course){
        listOfCourses.add(course);
    }

    public ArrayList<Course> getListOfCourses(){
        return listOfCourses;
    }

    boolean containsCourse(Course c){
        return listOfCourses.contains(c);
    }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Term term = (Term) o;

        return termNumber == term.termNumber && year == term.year;
    }

    @Override
    public int hashCode() {
        int result = termNumber;
        result = 31 * result + year;
        return result;
    }*/
}