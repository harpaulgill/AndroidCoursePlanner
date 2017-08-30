package com.example.thinkpad.androidcourseplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONException;

import java.io.IOException;

public class CourseList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
    }

    public void submitCourses(View view) throws IOException, JSONException {
        Log.v("tag", "message");
        Intent intent = new Intent(this, MainCourseActivity.class);
/*        CourseDB courseDB = new CourseDB(this);
        ArrayList<Course> courseArray = courseDB.getAllCourses();
        String message = courseArray.get(0).getSubject();
        intent.putExtra(EXTRA_MESSAGE, message);*/
        startActivity(intent);
    }
}
