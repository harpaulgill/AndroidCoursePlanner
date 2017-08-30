package com.example.thinkpad.androidcourseplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONException;

import java.io.IOException;

public class CourseList extends AppCompatActivity {

    private Term mTerm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        int termNum = getIntent().getIntExtra("term", 0);
        int yearNum = getIntent().getIntExtra("year", 0);
        mTerm = new Term(termNum, yearNum);
    }

    public void submitCourses(View view) throws IOException, JSONException {
        Intent intent = new Intent(this, MainCourseActivity.class);
        startActivity(intent);
    }
}
