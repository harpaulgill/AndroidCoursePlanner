package com.example.thinkpad.androidcourseplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class MainCourseActivity extends AppCompatActivity {

    ListView mListViewCoursesYearOneTermOne;
    ArrayAdapter<String> adapterCoursesYearOneTermOne;
    ArrayList<String> coursesYearOneTermOne;

    ListView mListViewCoursesYearOneTermTwo;
    ArrayAdapter<String> adapterCoursesYearOneTermTwo;
    ArrayList<String> coursesYearOneTermTwo;

    TermDB mTermDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_course);
        mTermDB = TermDB.getSingletonInstance();

        coursesYearOneTermOne = getTermCourses("yearOneTermOne");
        coursesYearOneTermTwo = getTermCourses("yearOneTermTwo");

        mListViewCoursesYearOneTermOne = (ListView) findViewById(R.id.yearOneTermOneListView);
        adapterCoursesYearOneTermOne = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, coursesYearOneTermOne);

        mListViewCoursesYearOneTermTwo = (ListView) findViewById(R.id.yearOneTermTwoListView);
        adapterCoursesYearOneTermTwo = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, coursesYearOneTermTwo);


        mListViewCoursesYearOneTermOne.setAdapter(adapterCoursesYearOneTermOne);
        mListViewCoursesYearOneTermTwo.setAdapter(adapterCoursesYearOneTermTwo);

    }

    private ArrayList<String> getTermCourses(String termId){
        Term term = mTermDB.getTerm(termId);
        return term.getAllCourseNames();
    }

    public void goToCourseList(View view) throws IOException, JSONException {
        Intent intent = new Intent(this, CourseList.class);
        String viewId = getResources().getResourceName(view.getId()).substring(45);
        intent.putExtra("termIdentifier", viewId);
        Log.v("idName", viewId);
        startActivity(intent);
    }
}
