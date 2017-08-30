package com.example.thinkpad.androidcourseplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class MainCourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_course);
    }

    public void goToCourseList(View view) throws IOException, JSONException {
        Log.v("tag", "message");
        Intent intent = new Intent(this, CourseList.class);
/*        CourseDB courseDB = new CourseDB(this);
        ArrayList<Course> courseArray = courseDB.getAllCourses();
        String message = courseArray.get(0).getSubject();
        intent.putExtra(EXTRA_MESSAGE, message);*/
        startActivity(intent);
    }
}
