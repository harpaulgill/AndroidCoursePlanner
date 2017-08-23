package com.example.thinkpad.androidcourseplanner;

import android.content.Context;
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

/**
 * Created by kgrover on 2017-07-09.
 */

public class CourseDB {

    Context context;

    protected CourseDB(Context context) {
        this.context = context;
    }

    public ArrayList<Course> getAllCourses() throws IOException, JSONException {
        // Reading text file from assets folder
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
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
                br.close(); // stop reading
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String myjsonstring = sb.toString();

        // Creating JSONObject from String
        JSONObject jsonObjMain = new JSONObject(myjsonstring);

        // Creating JSONArray from JSONObject
        JSONArray jsonArray = jsonObjMain.getJSONArray("courses");

        ArrayList<Course> courses = new ArrayList<Course>();

        for (int i = 0; i < jsonArray.length(); i++) {
            // Creating JSONObject from JSONArray
            JSONObject jsonObj = jsonArray.getJSONObject(i);
            String courseSubject = jsonObj.getString("courseSubject");
            String courseId = jsonObj.getString("courseId");
            String credits = jsonObj.getString("credits");
            String faculty = jsonObj.getString("faculty");

            Course course = new Course(courseSubject, courseId, credits, faculty);
            courses.add(course);
        }

        return courses;
    }
}
