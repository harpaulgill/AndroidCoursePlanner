package com.example.thinkpad.androidcourseplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONException;

import java.io.IOException;

public class CourseList extends AppCompatActivity {

    private CourseDB mCourseDB;
    private TermDB mTermDB = TermDB.getSingletonInstance();
    Term term;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        mCourseDB = new CourseDB(this);
        String termNum = getIntent().getStringExtra("termIdentifier");
        term = mTermDB.getTerm(termNum);
        String testString = term.getIdentifier();

    }

    public void submitCourses(View view) throws IOException, JSONException {
        Intent intent = new Intent(this, MainCourseActivity.class);
        startActivity(intent);
    }
}
