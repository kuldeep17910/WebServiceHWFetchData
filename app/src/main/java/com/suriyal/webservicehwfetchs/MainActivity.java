package com.suriyal.webservicehwfetchs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String displayUrl = "https://******.000webhostapp.com/****.php";

    private List<DataModel> productList;
    RecyclerView recyclerView;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn2=findViewById(R.id.btnShowd);


        //getting the rv from xml
        recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //initializing the product list
        productList = new ArrayList<>();


        btn2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        showAllData();
    }
});

    }

    private void showAllData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, displayUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //converting the string to json array object
                    JSONArray array = new JSONArray(response);

                    //traversing through all the object
                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject product = array.getJSONObject(i);

                        //adding the product to product list
                        productList.add(new DataModel(

                                product.getInt("id"),
                                product.getString("name"),
                                product.getInt("salary"),
                                product.getString("phone")


                        ));
                    }

                    //creating adapter object and setting it to recyclerview
                    RvAdapter adapter = new RvAdapter(MainActivity.this, productList);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //adding our stringrequest to queue
        Volley.newRequestQueue(MainActivity.this).add(stringRequest);
    }


}