package com.rishidholkheria.todolist;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class ToDoList2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list2);

        final ListView listView = (ListView) findViewById(R.id.Listview);
        Button AddBtn = (Button) findViewById(R.id.AddBtn);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText EditItem = (EditText) findViewById(R.id.EditItem);


        final ArrayList<String> array = new ArrayList<>();

        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Item = EditItem.getText().toString();
                array.add(Item);
            }
        });

        ArrayAdapter adapt = new ArrayAdapter(this, android.R.layout.simple_list_item_1, array);

        listView.setAdapter(adapt);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflat = getMenuInflater();
        inflat.inflate(R.menu.menu2_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menu) {
        switch (menu.getItemId()) {
            case (R.id.save):
                openDialog();

                return true;
            default:
                return super.onOptionsItemSelected(menu);

        }
    }

    public void openDialog(){

        TitleDialog titledilog = new TitleDialog();
        titledilog.show(getSupportFragmentManager(),"titledialog");

    }


}