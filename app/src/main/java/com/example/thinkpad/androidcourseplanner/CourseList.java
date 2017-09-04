package com.example.thinkpad.androidcourseplanner;

/* The base of this code is from http://theopentutorials.com/tutorials/android/listview/android-multiple-selection-listview
*/

import android.app.Activity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONException;

public class CourseList extends Activity implements
        OnClickListener {
    Button button;
    ListView listView;
    ArrayAdapter<String> adapter;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);


        findViewsById();

        List<String> courses = new LinkedList<>();
        courses.add("ENGL 112");
        courses.add("MATH 100");
        courses.add("PHYS 101");
        courses.add("CHEM 101");
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, courses);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        button.setOnClickListener(this);
    }

    private void findViewsById() {
        listView = (ListView) findViewById(R.id.list);
        button = (Button) findViewById(R.id.testbutton);
    }

    public void onClick(View v) {
/*        SparseBooleanArray checked = listView.getCheckedItemPositions();
        ArrayList<String> selectedItems = new ArrayList<String>();
        for (int i = 0; i < checked.size(); i++) {
            // Item position in adapter
            int position = checked.keyAt(i);
            // Add sport if it is checked i.e.) == TRUE!
            if (checked.valueAt(i))
                selectedItems.add(adapter.getItem(position));
        }

        String[] outputStrArr = new String[selectedItems.size()];

        for (int i = 0; i < selectedItems.size(); i++) {
            outputStrArr[i] = selectedItems.get(i);*/

        Intent intent = new Intent(this, MainCourseActivity.class);
        startActivity(intent);

        }





/*        // Create a bundle object
        Bundle b = new Bundle();
        b.putStringArray("selectedItems", outputStrArr);

        // Add the bundle to the intent.
        intent.putExtras(b);

        // start the ResultActivity
        startActivity(intent);*/

}
