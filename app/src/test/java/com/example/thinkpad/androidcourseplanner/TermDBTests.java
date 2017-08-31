package com.example.thinkpad.androidcourseplanner;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class TermDBTests {
    private TermDB mTermDB = TermDB.getSingletonInstance();
    private Term term1 = new Term(1,1);
    private Term term1Duplicate = new Term(1,1);
    private Term term2 = new Term(2,1);
    private Term term3 = new Term(3,1);
    private Term term4 = new Term(3,2);
    private Term term5 = new Term(2,3);

    @Before
    public void setUp() {
        mTermDB.deleteAllTerms();
    }

    @Test
    public void testDeleteAllTerms(){
        mTermDB.addTerm(term1);
        mTermDB.addTerm(term2);
        mTermDB.deleteAllTerms();
        assertEquals(0, mTermDB.getSize());
    }

    @Test
    public void testHashSetDuplicate(){
        mTermDB.addTerm(term1);
        mTermDB.addTerm(term1Duplicate);
        assertEquals(1, mTermDB.getSize());
    }

    @Test
    public void testTermDBAddTerm(){
        Course course = new Course("ENGL", "ENGL112", "3", "Art");
        term1.addCourse(course);
        mTermDB.addTerm(term1);
        assertEquals(1, mTermDB.getSize());
        assertEquals(term1, mTermDB.addTerm(term1Duplicate));

    }


}