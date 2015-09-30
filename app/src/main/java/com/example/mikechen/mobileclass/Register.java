package com.example.mikechen.mobileclass;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Register extends Activity implements View.OnClickListener{


    Button bRegister;
    EditText  etAge, etUserName,etPassword,etSkill,etInterest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etAge=(EditText) findViewById(R.id.etUserAge);
        etUserName=(EditText) findViewById(R.id.etUserName);
       etPassword=(EditText) findViewById(R.id.etPassword);
        bRegister=(Button)findViewById(R.id.bRegister);
        etSkill=(EditText)findViewById(R.id.etUserSkill);
        etInterest=(EditText)findViewById(R.id.etUserInterest);



        bRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bRegister:
                String name= etUserName.getText().toString();
                String password=etPassword.getText().toString();
                int age = Integer.parseInt(etAge.getText().toString());
                String skill=etSkill.getText().toString();
                String interst=etInterest.getText().toString();

                User user=new User(name,age,password,skill,interst);

                break;
        }
    }

}
