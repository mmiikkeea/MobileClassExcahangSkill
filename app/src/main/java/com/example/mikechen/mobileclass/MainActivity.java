package com.example.mikechen.mobileclass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements View.OnClickListener{
    Button bLogout;
    EditText etName,etSkill,etInterest,etAge;
    UserLocalStore userLocalStore;


    protected void onCreate(Bundle savedIndstanceState){
        super.onCreate(savedIndstanceState);
        setContentView(R.layout.activity_main);


        etName=(EditText) findViewById(R.id.etUserName);
        etSkill=(EditText)findViewById(R.id.etUserSkill);
        etInterest=(EditText)findViewById(R.id.etUserInterest);
        etAge=(EditText)findViewById(R.id.etUserAge);

        bLogout=(Button)findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);

    }

    @Override
    public void onStart(){
      super.onStart();
        if(authenticate()==true){
            displayUserDetails();
        }

    }

    private void displayUserDetails(){
        User user=userLocalStore.getLogginUser();
        etName.setText(user.name);
        etSkill.setText(user.skill);
        etAge.setText(user.age+"");
        etInterest.setText(user.interest);
    }
    public boolean authenticate(){
        return userLocalStore.getUseredLogin();
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogout:

                startActivity(new Intent(this, Login
                        .class));
                break;
        }
    }
}