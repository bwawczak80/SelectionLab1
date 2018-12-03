package com.example.brianwawczak.selectionlab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainClassList extends AppCompatActivity {

    Button nextButton;

    EditText firstNameTxt;
    EditText lastNameTxt;
    EditText phoneTxt;
    EditText dayTxt;
    EditText yearTxt;

    Spinner dateSpinner;
    Spinner spCertificate;
    Spinner spDegree;

    Switch swDegreeCert;

    TextView txtCertificate;
    TextView txtMajor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_class_list);

        nextButton = findViewById(R.id.idNextBtn);

        firstNameTxt = findViewById(R.id.idfirstNameTxt);
        lastNameTxt = findViewById(R.id.idLastNameTxt);
        phoneTxt = findViewById(R.id.idPhoneTxt);
        dayTxt = findViewById(R.id.idDayTxt);
        yearTxt = findViewById(R.id.idYearTxt);

        dateSpinner = findViewById(R.id.idDateSpinner);
        spCertificate = findViewById(R.id.spCertificate);
        spDegree = findViewById(R.id.spDegree);

        swDegreeCert = findViewById(R.id.swDegreeCert);

        txtCertificate = findViewById(R.id.lblCertificate);
        txtMajor = findViewById(R.id.lblDegree);

        swDegreeCert.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    spDegree.setVisibility(View.VISIBLE);
                    txtMajor.setVisibility(View.VISIBLE);
                    spCertificate.setVisibility(View.GONE);
                    txtCertificate.setVisibility(View.GONE);

                }else{
                    spDegree.setVisibility(View.GONE);
                    txtMajor.setVisibility(View.GONE);
                    spCertificate.setVisibility(View.VISIBLE);
                    txtCertificate.setVisibility(View.VISIBLE);

                }
            }
        });


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkData()) {
                    String dateOfBirth;
                    dateOfBirth = dateSpinner.getSelectedItem().toString() + "/" + dayTxt.getText().toString() + "/" + yearTxt.getText().toString();

                    Intent nextScreen = new Intent(MainClassList.this, ChooseClass.class);
                    nextScreen.putExtra("FirstName", firstNameTxt.getText().toString());

                    nextScreen.putExtra("LastName", lastNameTxt.getText().toString());

                    nextScreen.putExtra( "Phone", phoneTxt.getText().toString());

                    nextScreen.putExtra("BirthDate", dateOfBirth);

                    if (spDegree.getVisibility() == View.VISIBLE) {
                        nextScreen.putExtra("isDegreeCert", "Degree");
                        nextScreen.putExtra("degreeCert", spDegree.getSelectedItem().toString());

                    }else{
                        nextScreen.putExtra("isDegreeCert", "Certificate");
                        nextScreen.putExtra("degreeCert", spCertificate.getSelectedItem().toString());

                    }

                    startActivity(nextScreen);


                }





            }
        });
    }

    private boolean checkData () {
        if (firstNameTxt.getText().toString().isEmpty()) {
            firstNameTxt.setError("Invalid First Name");
            firstNameTxt.requestFocus();
            return false;
        }

        if (lastNameTxt.getText().toString().isEmpty()) {
            lastNameTxt.setError("Invalid Last Name");
            lastNameTxt.requestFocus();
            return false;

        }
        if (phoneTxt.getText().toString().isEmpty()) {
            phoneTxt.setError("Invalid Phone Number");
            phoneTxt.requestFocus();
            return false;

        }
        if (dayTxt.getText().toString().isEmpty()) {
            dayTxt.setError("Invalid Day of Month");
            dayTxt.requestFocus();
            return false;

        }
        if (yearTxt.getText().toString().isEmpty()) {
            yearTxt.setError("Invalid year");
            yearTxt.requestFocus();
            return false;

        }

        return true;






    }
}
