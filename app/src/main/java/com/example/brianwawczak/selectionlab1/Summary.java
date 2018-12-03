package com.example.brianwawczak.selectionlab1;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    private String firstName = "";
    private String lastName = "";
    private String phone = "";
    private String birthDate = "";
    private String isDegreeCert = "";
    private String degreeCert = "";
    private String class1 = "";
    private String selected1 = "";
    private String class2 = "";
    private String selected2 = "";
    private String class3 = "";
    private String selected3 = "";
    private String class4 = "";
    private String selected4 = "";


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            firstName = extras.getString("FirstName");
            lastName = extras.getString("LastName");
            phone = extras.getString("Phone");
            birthDate = extras.getString("BirthDate");
            isDegreeCert = extras.getString("isDegreeCert");
            degreeCert = extras.getString("degreeCert");
            class1 = extras.getString("Class1");
            selected1 = extras.getString("Selected1");
            class2 = extras.getString("Class2");
            selected2 = extras.getString("Selected2");
            class3 = extras.getString("Class3");
            selected3 = extras.getString("Selected3");
            class4 = extras.getString("Class4");
            selected4 = extras.getString("Selected4");

        }


        final TextView txtStudent = findViewById(R.id.txtStudent);
        final TextView txtPhone = findViewById(R.id.txtPhone);
        final TextView txtBirthDate = findViewById(R.id.txtBirthdate);
        final TextView txtDegreePlan = findViewById(R.id.txtDegree);
        final TextView txtMajor = findViewById(R.id.txtMajor);
        final TextView txtClassSchedule = findViewById(R.id.txtClassSchedule);

        txtStudent.setText(firstName + " " + lastName);
        txtPhone.setText(phone);
        txtBirthDate.setText(birthDate);
        txtDegreePlan.setText(isDegreeCert);
        txtMajor.setText(degreeCert);

        StringBuilder ClassSchedule = new StringBuilder(250);



        if(!class1.equals("")){
            ClassSchedule.append(class1).append("\n ").append(selected1).append("\n\n");

        }
        if(!class2.equals("")){
            ClassSchedule.append(class2).append("\n ").append(selected2).append("\n\n");

        }
        if(!class3.equals("")){
            ClassSchedule.append(class3).append("\n ").append(selected3).append("\n\n");

        }
        if(!class4.equals("")){
            ClassSchedule.append(class4).append("\n ").append(selected4).append("\n\n");

        }


        txtClassSchedule.setText(ClassSchedule);



    }
}
