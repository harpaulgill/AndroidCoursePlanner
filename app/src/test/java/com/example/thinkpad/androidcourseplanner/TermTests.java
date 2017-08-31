package com.example.thinkpad.androidcourseplanner;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TermTests {
    Term term1;
    Term term2;
    Term term3;
    Term term4;
    Term term5;
    @Before
    public void setUp() {
        term1 = new Term(1,1);
        term2 = new Term(2,1);
        term3 = new Term(3,1);
        term4 = new Term(3,2);
        term5 = new Term(2,3);
    }

    @Test
    public void termEqualsIsCorrect(){
        Term termOneDuplicate = new Term(1,1);
        if(!term1.equals(termOneDuplicate)){
            fail();
        }
    }

    @Test
    public void testTermAddCourse(){
        Course course = new Course("ENGL", "ENGL112", "3", "Art");
        term1.addCourse(course);
        assertTrue(term1.containsCourse(course));
    }
}
