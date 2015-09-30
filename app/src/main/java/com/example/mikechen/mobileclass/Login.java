package com.example.mikechen.mobileclass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Login extends Activity implements OnClickListener{


    Button bLogin;
    EditText etUsername, etPassword;
    TextView registerLink;

    UserLocalStore userLocalStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername=(EditText) findViewById(R.id.etUserName);
        etPassword=(EditText)findViewById(R.id.etPassword);
        registerLink=(TextView)findViewById(R.id.tvRegiseterLink);

        bLogin=(Button)findViewById(R.id.bLogin);

        bLogin.setOnClickListener(this);
        registerLink.setOnClickListener(this);

        userLocalStore=new UserLocalStore(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogin:
                User user = new User(null,null);

                userLocalStore.storedUserData(user);
                userLocalStore.setUserLoggedIn(true);


                break;

            case R.id.tvRegiseterLink:

                startActivity(new Intent(this,Register.class));


                break;
       }
    }
}
