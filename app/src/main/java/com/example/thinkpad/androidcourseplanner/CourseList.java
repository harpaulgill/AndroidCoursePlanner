package com.example.thinkpad.androidcourseplanner;

/* The base of this code is from http://theopentutorials.com/tutorials/android/listview/android-multiple-selection-listview
*/

import android.app.Activity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.CorrectionInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONException;

public class CourseList extends Activity implements
        OnClickListener {
    Button button;
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> courses;
    CourseDB mCourseDB;
    TermDB mTermDB;
    Term term;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        getCoursesList();
        listView = (ListView) findViewById(R.id.list);
        button = (Button) findViewById(R.id.testbutton);
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_multiple_choice, courses);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        button.setOnClickListener(this);
        mTermDB = TermDB.getSingletonInstance();
        term = mTermDB.getTerm(getIntent().getStringExtra("termIdentifier"));
    }

    private void getCoursesList(){
        courses = new ArrayList<>();
        mCourseDB = new CourseDB(this);
        HashMap<String, Course> courseHashMap = mCourseDB.getAllCourses();
        Iterator iterator = courseHashMap.entrySet().iterator();
        while(iterator.hasNext()){
            HashMap.Entry entryPair = (HashMap.Entry) iterator.next();
            String courseId = (String) entryPair.getKey();
            courses.add(courseId);
        }
    }

    public void onClick(View v) {
        SparseBooleanArray checked = listView.getCheckedItemPositions();
        ArrayList<String> selectedItems = new ArrayList<String>();
        for (int i = 0; i < checked.size(); i++) {
            // Item position in adapterCoursesYearOneTermOne
            int position = checked.keyAt(i);
            // Add course if it is checked i.e.) == TRUE!
            if (checked.valueAt(i))
                selectedItems.add(adapter.getItem(position));
        }

        for(String s : selectedItems){
            Course course = mCourseDB.getCourse(s);
            term.addCourse(course);
        }

        Intent intent = new Intent(this, MainCourseActivity.class);
        startActivity(intent);
//
//        String[] outputStrArr = new String[selectedItems.size()];

//        for (int i = 0; i < selectedItems.size(); i++) {
//            outputStrArr[i] = selectedItems.get(i);
//
//
        }





/*        // Create a bundle object
        Bundle b = new Bundle();
        b.putStringArray("selectedItems", outputStrArr);

        // Add the bundle to the intent.
        intent.putExtras(b);

        // start the ResultActivity
        startActivity(intent);*/

}
