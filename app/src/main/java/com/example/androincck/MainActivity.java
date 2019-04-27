package com.example.androincck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androincck.IHolder.ILoginView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText edtName;
    EditText edtPass;
    Button btnSubmit;
    String mUser = "";
    String mPass="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onInit();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(OnValueForm()){
                    Map<String,String> mMap = new HashMap<>();
                    mMap.put("user_name",mUser);
                    mMap.put("password",mPass);
                    new LoginAsyncTask(MainActivity.this, new ILoginView() {
                        @Override
                        public void onLoginSuccess(String m) {
                            Toast.makeText(MainActivity.this,m,Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity.this,ContactActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onLoginFail(String m) {
                            Toast.makeText(MainActivity.this,m,Toast.LENGTH_SHORT).show();
                        }
                    },mMap).execute("http://www.vidophp.tk/api/account/signin");

                }
            }
        });

    }

    private void onInit() {
        edtName = (EditText)findViewById(R.id.edtName);
        edtPass = (EditText)findViewById(R.id.edtPass);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
    }
    private boolean OnValueForm(){
        mUser = edtName.getText().toString();
        mPass = edtPass.getText().toString();
        if (mUser.length()<0){
            edtName.setError("User cannot be null ! ");
            return false;
        }
        if (mPass.length()<0){
            edtPass.setError("Password cannot be null ! ");
            return false;
        }
        return true;
    }
}
