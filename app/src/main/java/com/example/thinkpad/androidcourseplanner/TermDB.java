package com.example.thinkpad.androidcourseplanner;

import java.util.HashMap;

class TermDB {
    private HashMap<String, Term> mTermHashMap;
    private static TermDB singletonInstance;

    private TermDB() {
        mTermHashMap = new HashMap<String, Term>();
        Term yearOneTermOne = new Term("yearOneTermOne");
//        Course course1 = new Course("ENGL", "ENGL 112", "3","Art");
//        Course course2 = new Course("ENGL", "ENGL 110", "3","Art");
//        yearOneTermOne.addCourse(course1);
//        yearOneTermOne.addCourse(course2);
        mTermHashMap.put("yearOneTermOne", yearOneTermOne);
        mTermHashMap.put("yearOneTermTwo", new Term("yearOneTermTwo"));
        mTermHashMap.put("yearTwoTermOne", new Term("yearTwoTermOne"));
        mTermHashMap.put("yearTwoTermTwo", new Term("yearTwoTermTwo"));
        mTermHashMap.put("yearThreeTermOne", new Term("yearThreeTermOne"));
        mTermHashMap.put("yearThreeTermTwo", new Term("yearThreeTermTwo"));
        mTermHashMap.put("yearFourTermOne", new Term("yearFourTermOne"));
        mTermHashMap.put("yearFourTermTwo", new Term("yearFourTermTwo"));
    }

    static TermDB getSingletonInstance() {
        if (null == singletonInstance) {
            singletonInstance = new TermDB();
        }
        return singletonInstance;
    }

    Term getTerm(String identifier){
        return mTermHashMap.get(identifier);
    }

    void deleteAllTerms(){
        mTermHashMap.clear();
    }

    int getSize(){
        return mTermHashMap.size();
    }

}
