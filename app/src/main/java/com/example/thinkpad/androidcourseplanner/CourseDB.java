package com.example.thinkpad.androidcourseplanner;

import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.res.AssetManager;
import android.util.Log;

import com.example.thinkpad.androidcourseplanner.Course;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


public class CourseDB {

    private Context context;
//    private static CourseDB mCourseDBInstance;
    HashMap<String, Course> allCourses;

    CourseDB(Context context) {
        this.context = context;
        // Reading text file from assets folder
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        HashMap<String, Course> courses = new HashMap<>();

        try {
            AssetManager assetManager = context.getAssets();
            InputStream is = assetManager.open("jsondata.txt");
            br = new BufferedReader(new InputStreamReader(is));
            String temp;
            while ((temp = br.readLine()) != null)
                sb.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //TODO: Handle case where NULL
                br.close(); // stop reading
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String jsonString = sb.toString();


        try {
            // Creating JSONObject from String
            JSONObject jsonObjMain = new JSONObject(jsonString);
            // Creating JSONArray from JSONObject
            JSONArray jsonArray = jsonObjMain.getJSONArray("courses");

            for (int i = 0; i < jsonArray.length(); i++) {
                // Creating JSONObject from JSONArray
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String courseSubject = jsonObj.getString("courseSubject");
                String courseId = jsonObj.getString("courseId");
                String credits = jsonObj.getString("credits");
                String faculty = jsonObj.getString("faculty");

                Course course = new Course(courseSubject, courseId, credits, faculty);
                courses.put(courseId, course);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        allCourses = courses;
    }

    // Implementation of Singleton design pattern for CourseDB
//    static CourseDB getCourseDBInstance(Context context) {
//        if (mCourseDBInstance == null) {
//            mCourseDBInstance = new CourseDB(context);
//        }
//        return mCourseDBInstance;
//    }

    public Course getCourse(String courseId){
        return allCourses.get(courseId);
    }

    public HashMap<String, Course> getAllCourses(){
        return allCourses;
    }
}
