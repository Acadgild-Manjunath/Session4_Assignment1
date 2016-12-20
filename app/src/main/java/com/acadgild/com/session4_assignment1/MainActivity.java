package com.acadgild.com.session4_assignment1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        private Button btnAsc, btnDesc;
        private ListView lstItems;
    ArrayAdapter<String> adp;
        String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September",
                                        "October", "November", "December"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAsc = (Button) findViewById(R.id.btnAscending);
        btnAsc.setOnClickListener(this);

        btnDesc = (Button) findViewById(R.id.btnDescending);
        btnDesc.setOnClickListener(this);

        lstItems = (ListView) findViewById(R.id.list);
        adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, months);
        lstItems.setAdapter(adp);

        lstItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long itemId) {
                Toast.makeText(getApplicationContext(),"You clicked on "+ lstItems.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.btnAscending:

                sortAscending();
                adp.notifyDataSetChanged();
                break;

            case R.id.btnDescending:
                sortDescending();
                adp.notifyDataSetChanged();
                break;
        }
    }

    private void sortAscending () {
        Arrays.sort(months);
    }

    private void sortDescending () {
        Arrays.sort(months, Collections.<String>reverseOrder());
    }
}
