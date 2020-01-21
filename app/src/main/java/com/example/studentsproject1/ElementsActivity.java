package com.example.studentsproject1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ElementsActivity extends AppCompatActivity {

    EditText myName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elements);

        myName = findViewById(R.id.editTextName);
    }

    public void onCheckboxClicked (View view) { // Ver. 2
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Using an only one if
        String text = ((CheckBox) view).getText().toString();
        if (checked) displayToast ("Seleccionat l'element: " + text);
        else displayToast ("Deseleccionat l'element: " + text);
    }

    public void displayToast (String text) {
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(this, text, duration);
        toast.show();
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which checkbox was clicked
        String text = ((RadioButton) view).getText().toString();
        if (checked) displayToast ("Seleccionat l'element: " + text);
        else displayToast ("Deseleccionat l'element: " + text);
    }

    public void buildDialog(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("Aceptar", null);
        builder.create();
        builder.show();
    }

    public void onImageButtonClicked(View view) {
        buildDialog ("Alert Dialog", "Hola " + myName.getText().toString());
    }
}
