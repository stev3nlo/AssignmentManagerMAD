package com.example.lo_856348.assignmentmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Scroller;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by lo_856348 on 1/15/2016.
 */
public class AddAssignment extends Activity {

    private String[] priorities;
    Spinner dropdown;
    public static String[] info = new String[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_assignment);
        dropdown = (Spinner) findViewById(R.id.priorityInput);
        priorities = new String[3];
        priorities[0] = "High";
        priorities[1] = "Medium";
        priorities[2] = "Low";
        dropdown.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, priorities));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onPress(View v) {
        Spinner dropdown = (Spinner) findViewById(R.id.priorityInput);
        String option = dropdown.getSelectedItem().toString();
    }

    public void finishAdding(View v) {
        EditText name = (EditText) findViewById(R.id.nameInput);
        EditText description = (EditText) findViewById(R.id.descInput);
        EditText className = (EditText) findViewById(R.id.classInput);
        EditText month = (EditText) findViewById(R.id.month);
        EditText day = (EditText) findViewById(R.id.day);
        EditText year = (EditText) findViewById(R.id.year);
        String priority = dropdown.getSelectedItem().toString();
        info[0] = String.valueOf(name.getText());
        info[1] = String.valueOf(description.getText());
        info[2] = String.valueOf(className.getText());
        info[3] = String.valueOf(month.getText());
        info[4] = String.valueOf(day.getText());
        info[5] = String.valueOf(year.getText());
        info[6] = priority;

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("info", info);
    }
}
