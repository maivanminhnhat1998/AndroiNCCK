package com.example.androincck;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.androincck.IHolder.IView;
import com.example.androincck.Model.ContactModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactActivity extends AppCompatActivity {
    RecyclerView contact_recyclerView;
    List<ContactModel>  models;
    Map<String,String> mMap = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        models = new ArrayList<>();
        onInit();
        contact_recyclerView.setHasFixedSize(true);
        contact_recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        mMap.put("id","11");
        new ContactAsyncTask(ContactActivity.this,new IView(){
            @Override
            public void onRequestSuccess(Bitmap bitmap) {

            }

            @Override
            public void onGetDataSuccess(JSONArray jsonArray) {
                for(int i=0;i <jsonArray.length();i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        ContactModel contactModel = new ContactModel();
                        contactModel.setId(Integer.valueOf(jsonObject.getString("id")));
                        contactModel.setTenMH(jsonObject.getString("subject_name"));
                        contactModel.setMaMH(jsonObject.getString("subject_code"));
                        contactModel.setTinhChi(Integer.valueOf(jsonObject.getString("credits")));
                        contactModel.setDescription(jsonObject.getString("description"));

                        models.add(contactModel);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                MyAdapter adapter = new MyAdapter(ContactActivity.this,R.layout.row_contact_activity,models);
                contact_recyclerView.setAdapter(adapter);
            }
        },mMap).execute(" http://www.vidophp.tk/api/account/getdata");


    }

    private void onInit() {
        contact_recyclerView = findViewById(R.id.contact_recyclerView);
    }
}
