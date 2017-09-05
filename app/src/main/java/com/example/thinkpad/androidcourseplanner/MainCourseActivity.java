package com.example.thinkpad.androidcourseplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class MainCourseActivity extends AppCompatActivity {

    ListView mListView;
    ArrayAdapter<String> adapter;
    ArrayList<String> coursesYearOneTermOne;
    TermDB mTermDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_course);
        mTermDB = TermDB.getSingletonInstance();

        coursesYearOneTermOne = getTermCourses("yearOneTermOne");

        mListView = (ListView) findViewById(R.id.yearOneTermOneListView);
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, coursesYearOneTermOne);
        mListView.setAdapter(adapter);

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
