package com.example.studentsproject1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {

    private String[] llibres = {"El ninot de neu", "Senyoria", "Els assassins de l'emperador"};
    private String[] autors = {"JO Nesbo", "Jaume Cabré", "Santiago Posteguillo"};
    private int[] portades = {R.drawable.ninot_de_neu, R.drawable.senyoria, R.drawable.assassins_emperador};
    private ListView myBooks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, R.layout.activity_my_books, R.id.bookName, llibres);
        myBooks = findViewById(R.id.lstOptions);
        myBooks.setAdapter(adapter);
        myBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                buildDialog ( llibres[position], "Autor: " + autors [position], position );
            }
        });

    }

    // Out of onCreate
    public void buildDialog (String title, String message, int position) {
        // Imprescindible instanciar una nova imatge cada vegada!!!
        // Per evitar problemes del tipus: The specified child already has a parent.
        final ImageView image = new ImageView(this); image.setImageResource(portades[position]);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);     builder.setMessage(message);   builder.setPositiveButton("OK", null);
        builder.setView(image);         builder.create();         builder.show();
    }
}
