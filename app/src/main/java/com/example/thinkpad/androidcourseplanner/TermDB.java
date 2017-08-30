package com.example.thinkpad.androidcourseplanner;

import java.util.HashSet;

/**
 * Created by kgrover on 2017-08-30.
 */

public class TermDB {
    private HashSet<Term> mTermHashSet;
    private static TermDB singletonInstance;

    private TermDB() {
        mTermHashSet = new HashSet<>();
    }

    public static TermDB getSingletonInstance() {
        if (null == singletonInstance) {
            singletonInstance = new TermDB();
        }
        return singletonInstance;
    }

    //TODO: Override equals and hashCode function such that any two Terms with same term and year field are equal
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        TermDB termDB = (TermDB) o;
//
//        return mTermHashSet != null ? mTermHashSet.equals(termDB.mTermHashSet) : termDB.mTermHashSet == null;
//
//    }
//
//    @Override
//    public int hashCode() {
//        return mTermHashSet != null ? mTermHashSet.hashCode() : 0;
//    }
}
