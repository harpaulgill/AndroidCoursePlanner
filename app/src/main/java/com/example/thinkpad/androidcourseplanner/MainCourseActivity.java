package com.example.thinkpad.androidcourseplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONException;

import java.io.IOException;

public class MainCourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_course);

    }

    public void goToCourseList(View view) throws IOException, JSONException {
        Intent intent = new Intent(this, CourseList.class);
        String viewId = getResources().getResourceName(view.getId()).substring(45);
        intent.putExtra("termIdentifier", viewId);
        Log.v("idName", viewId);
        startActivity(intent);

//        switch(view.getId()) {
//            case (R.id.yearOneTermOneButton):
//                //TODO: create a new term object here or retrieve existing term
//                intent.putExtra("id", 1);
//                intent.putExtra("year", 1);
//
//                break;
//            case (R.id.yearOneTermTwoButton):
//                //TODO: create a new term object here or retrieve existing term
//                intent.putExtra("term", 2);
//                intent.putExtra("year", 1);
//                startActivity(intent);
//                break;
//        }
    }
}
