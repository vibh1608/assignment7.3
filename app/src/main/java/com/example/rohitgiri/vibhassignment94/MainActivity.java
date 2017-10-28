package com.example.rohitgiri.vibhassignment94;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

//creating a class which is extending AppCompatActivity
public class MainActivity extends AppCompatActivity {
    private ListView listView;                     //declaring listView
    private ArrayList<String> arrayList;           //declaring arraylist


    //onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);      //setting content view UI
        getSupportActionBar();
        listView= (ListView) findViewById(R.id.list);   //assigning listview by it's ID
        arrayList = new ArrayList<>();                  // assigning values to array list
        for (int i = 0; i < 10; i++) {
            arrayList.add("Item " + i);
        }

        //creating a array Adapter to link list view and array list
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);             //setting adapter
        registerForContextMenu(listView);
    }


    //onCreateContextMenu method
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Context Menu");  //giving heading
        menu.add(0, 101, 1, "Action 1");     //items
        menu.add(0, 102, 2, "Action 2");
        menu.add(0, 103, 3, "Action 3");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    //onContextItemSelected method
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id;
        id=item.getItemId();
        if(id==101)               //if id matches with 101 displaying a text
        {
            Toast.makeText(MainActivity.this,"You Have Clicked Action 1",Toast.LENGTH_SHORT).show();
        }
        else  if(id==102)             //if id matches with 102 displaying a text
        {
            Toast.makeText(MainActivity.this,"You Have Clicked Action 2",Toast.LENGTH_SHORT).show();
        }
        else if(id==103)              //if id matches with 103 displaying a text
        {
            Toast.makeText(MainActivity.this, "You Have Clicked Action 3", Toast.LENGTH_SHORT).show();
        }return super.onOptionsItemSelected(item);

    }
}
