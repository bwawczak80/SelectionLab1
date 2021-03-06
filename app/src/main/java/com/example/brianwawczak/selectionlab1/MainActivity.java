package com.example.brianwawczak.selectionlab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public enum LoginSuccess {
        login(1),
        password(2),
        success(0);

        private int intValue;
        LoginSuccess(int value){
            intValue = value;
        }

        public int getIntValue() {
            return intValue;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txtLogin = findViewById(R.id.idEnterUserName);
        final TextView txtPass = findViewById(R.id.idEnterPassword);
        Button btnLogin = findViewById(R.id.idLoginButton);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch(CheckLogin(txtLogin.getText().toString(), txtPass.getText().toString())){
                    case login:
                        Toast.makeText(getApplicationContext(),getString(R.string.errorMsgLogin), Toast.LENGTH_LONG).show();
                        txtLogin.requestFocus();
                        break;

                    case password:
                        Toast.makeText(getApplicationContext(), getString(R.string.errorMsgPW), Toast.LENGTH_LONG).show();
                        txtPass.requestFocus();
                        break;
                    default:
                        startActivity(new Intent(MainActivity.this, MainClassList.class));
                        Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }

    LoginSuccess CheckLogin(String txtLogin, String txtPassword){
        String holdLogin = "Brian";
        String holdPassword = "password";

        if(!(holdLogin.equals(txtLogin))){
            return LoginSuccess.login;
        }
        if(!(holdPassword.equals(txtPassword))){
            return LoginSuccess.password;
        }
        return LoginSuccess.success;
    }


}
