package com.example.mikechen.mobileclass;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by mikechen on 9/18/15.
 */
public class UserLocalStore {

    public  static final String SP_NAME="userDetails";
    SharedPreferences userLocalDatabase;


    public UserLocalStore(Context context){
        userLocalDatabase=context.getSharedPreferences(SP_NAME,0);
    }

    public void  storedUserData(User user){
        SharedPreferences.Editor spEditor= userLocalDatabase.edit();
        spEditor.putString("name",user.name);
        spEditor.putInt("age", user.age);
        spEditor.putString("password", user.password);
        spEditor.putString("skill", user.skill);
        spEditor.putString("interest",user.interest);
        spEditor.commit();

    }

    public User getLogginUser(){
        String name= userLocalDatabase.getString("name", "");
        String password= userLocalDatabase.getString("password","");
        String skill=userLocalDatabase.getString("skill","");
        String interest= userLocalDatabase.getString("interest","");
        int age = userLocalDatabase.getInt("age",-1);

        User storedUser=new User(name,age,password,skill,interest);
        return storedUser;

    }

    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor=userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn",loggedIn);
        spEditor.commit();
    }

//can use this method to check if uer login
    public boolean getUseredLogin(){
        if(userLocalDatabase.getBoolean("loggedIn",false)==true){
            return true;
        }else {
            return false;
        }
    }
    public void clearUserData(){
        SharedPreferences.Editor spEditor=userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }

}
