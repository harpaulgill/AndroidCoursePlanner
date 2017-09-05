package com.example.thinkpad.androidcourseplanner;

/**
 * Created by Harpaul on 8/19/2017.
 * This class is used to make new course objects for every entry in the json data
 */

public class Course {

    private final String subject;
    private final String courseId;
    private final String credits;
    private final String faculty;
    private final Boolean isSelected;
    private int term;

    /**
     * Create a new Course Object with all of its attributes
     * @param subject
     *            the course's subject ENGL, MATH etc.
     * @param courseId
     *            the sourse number
     * @param credits
     *            the amount of credits this course is worth
     */
    Course(String subject, String courseId, String credits, String faculty) {
        this.subject = subject;
        this.courseId = courseId;
        this.credits = credits;
        this.faculty = faculty;
        this.isSelected = false;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public String getCredits() {
        return this.credits;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public Boolean isSelected() {
        return this.isSelected;
    }

    public void setTerm(int term){
        this.term = term;
    }

    public int getTerm(){
        return this.term;
    }

}