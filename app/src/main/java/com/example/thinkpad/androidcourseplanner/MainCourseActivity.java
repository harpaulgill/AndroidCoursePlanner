package com.example.thinkpad.androidcourseplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.json.JSONException;

import java.io.IOException;

public class MainCourseActivity extends AppCompatActivity {

    CourseDB courseDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_course);
        courseDB = new CourseDB(this);
    }

    public void goToCourseList(View view) throws IOException, JSONException {
        Intent intent = new Intent(this, CourseList.class);

        switch(view.getId()) {
            case (R.id.yearOneTermOneButton):
                //TODO: create a new term object here or retrieve existing term
                intent.putExtra("term", 1);
                intent.putExtra("year", 1);
                startActivity(intent);
                break;
            case (R.id.yearOneTermTwoButton):
                //TODO: create a new term object here or retrieve existing term
                intent.putExtra("term", 2);
                intent.putExtra("year", 1);
                startActivity(intent);
                break;
        }
    }
}
