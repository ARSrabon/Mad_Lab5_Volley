package com.example.student.lab5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    TextView txt_hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_hello = (TextView) findViewById(R.id.txt_hello);

        String url = "http://www.mocky.io/v2/5822f4e71000009a0cccfe1f" ; //"http://www.mocky.io/v2/5822e943100000100bccfde8"; //"http://www.mocky.io/v2/5822e3c41000007a0accfdd5"

//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
////                Employee_Parser employeeParser = new Employee_Parser(response);
////                employeeParser.parse_emploee();
////                txt_hello.setText(employeeParser.parse_employee_toString());
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });

        url = "https://posttestserver.com/post.php";
        StringRequest request = new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("TEST",response);
                txt_hello.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("userid","Cyborn");
                map.put("userpass","Cyborn13x");
                return map;
            }
        };



        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);

        requestQueue.add(request);

    }
}
