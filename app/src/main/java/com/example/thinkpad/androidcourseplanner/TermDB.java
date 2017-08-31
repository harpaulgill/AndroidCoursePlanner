package com.example.thinkpad.androidcourseplanner;

import java.util.HashSet;

class TermDB {
    private HashSet<Term> mTermHashSet;
    private static TermDB singletonInstance;

    private TermDB() {
        mTermHashSet = new HashSet<>();
    }

    static TermDB getSingletonInstance() {
        if (null == singletonInstance) {
            singletonInstance = new TermDB();
        }
        return singletonInstance;
    }

    Term addTerm(Term term){
        if(mTermHashSet.contains(term)){
            for(Term t : mTermHashSet){
                if(term.equals(t)){
                    return t;
                }
            }
        }
        mTermHashSet.add(term);
        return term;
    }

    boolean termExists(int term, int year){
        Term termObj = new Term(term, year);
        return mTermHashSet.contains(termObj);
    }

    void deleteAllTerms(){
        mTermHashSet.clear();
    }

    int getSize(){
        return mTermHashSet.size();
    }

}
