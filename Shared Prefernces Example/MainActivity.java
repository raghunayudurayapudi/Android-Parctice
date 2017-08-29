package com.example.sai.sharedpreferences;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chkbx1,chkbx2,chkbx3,chkbx4;
    EditText et1;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkbx1=(CheckBox)findViewById(R.id.checkBox1);
        chkbx2=(CheckBox)findViewById(R.id.checkBox2);
        chkbx3=(CheckBox)findViewById(R.id.checkBox3);
        chkbx4=(CheckBox)findViewById(R.id.checkBox4);
        et1=(EditText)findViewById(R.id.editText1);

        btn1=(Button)findViewById(R.id.saveButton);
        btn2=(Button)findViewById(R.id.exitButton);

        loadSavedPreferences();
    }

    private  void loadSavedPreferences(){

        SharedPreferences sharedPrefs= PreferenceManager.getDefaultSharedPreferences(this);
        boolean checkBoxValue1=sharedPrefs.getBoolean("graphicsCoProc",false);
        boolean checkBoxValue2=sharedPrefs.getBoolean("extendedMemory",false);
        boolean checkBoxValue3=sharedPrefs.getBoolean("touchScreen",false);
        boolean checkBoxValue4=sharedPrefs.getBoolean("highspeednetworkadapter",false);

        String memSize=sharedPrefs.getString("RamCapacity","2");

        if(checkBoxValue1){

            chkbx1.setChecked(true);
        }
        else
        {
            chkbx1.setChecked(false);
        }

        if (checkBoxValue2) {
            chkbx2.setChecked(true);
        }
        else
        {
            chkbx2.setChecked(false);
        }

        if (checkBoxValue3){

            chkbx3.setChecked(true);
        }
        else{
            chkbx3.setChecked(false);
        }

        if(checkBoxValue4){

            chkbx4.setChecked(true);
        }
        else
        {
            chkbx4.setChecked(false);
        }

        et1.setText(memSize);
        et1.setHint("Hey there");

    }

    private void savePreferences(String key,boolean value){

        SharedPreferences sharedPrefs=PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=sharedPrefs.edit();
        editor.putBoolean(key,value);
        editor.apply();
    }


    private void savePreferences(String key,String value){

        SharedPreferences sharedPrefs=PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=sharedPrefs.edit();
        editor.putString(key,value);
        editor.apply();

    }

    public void saveValues(View v){


        savePreferences("graphicsCoProc",chkbx1.isChecked());
        savePreferences("extendedMemory",chkbx2.isChecked());
        savePreferences("touchScreen",chkbx3.isChecked());
        savePreferences("highspeednetworkadapter",chkbx4.isChecked());

        savePreferences("RAM Capacity",et1.getText().toString());

        Toast.makeText(this,"Saved the Values!!",Toast.LENGTH_LONG).show();
    }

    public void exitApp(View v){

        finish();
    }
}
