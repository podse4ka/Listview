package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lst;
    String[] devices = {"Бул", "Пэм", "Пайпер", "Леон"};
    String txt = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst = findViewById(R.id.ListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_multiple_choice, devices
        );
        lst.setAdapter(adapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
                if (lst.getCheckedItemCount() != 0) {
                    if (lst.isItemChecked(0)) {
                        if (txt == null)
                            txt = (String) lst.getItemAtPosition(0);
                    }

                    if (lst.isItemChecked(1)) {
                        if (txt != null)
                            txt = txt + " и " + (String) lst.getItemAtPosition(1);
                        if (txt == null)
                            txt = (String) lst.getItemAtPosition(1);
                    }

                    if (lst.isItemChecked(2)) {
                        if (txt != null)
                            txt = txt + " и " + (String) lst.getItemAtPosition(2);
                        if (txt == null)
                            txt = (String) lst.getItemAtPosition(2);
                    }

                    if (lst.isItemChecked(3)) {
                        if (txt != null)
                            txt = txt + " и " + (String) lst.getItemAtPosition(3);
                        if (txt == null)
                            txt = (String) lst.getItemAtPosition(3);
                    }
                    if (txt != null) {
                        Toast.makeText(getApplicationContext(), txt, Toast.LENGTH_SHORT).show();
                        txt = null;
                    }
                }
            }
        });
    }
}