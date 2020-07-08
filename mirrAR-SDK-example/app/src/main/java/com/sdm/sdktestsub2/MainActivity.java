package com.sdm.sdktestsub2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.sdm.mirrar.mirrar.MirrarFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String data = "{\n" +
                "  \"options\": {\n" +
                "    \"productData\": {\n" +
                "      \"category1\": {\n" +
                "        \"items\": [\n" +
                "          \"CT-2077\",\n" +
                "          \"CT-2032\",\n" +
                "          \"CT-2144\"\n" +
                "        ],\n" +
                "        \"type\": \"ear\"\n" +
                "      },\n" +
                "      \"category2\": {\n" +
                "        \"items\": [\n" +
                "          \"sku1\",\n" +
                "          \"CSh2057\",\n" +
                "          \"CS-2102\"\n" +
                "        ],\n" +
                "        \"type\": \"neck\"\n" +
                "      },\n" +
                "      \"category3\": {\n" +
                "        \"items\": [\n" +
                "          \"sku1\",\n" +
                "          \"DP-2369\",\n" +
                "          \"DS-2179\"\n" +
                "        ],\n" +
                "        \"type\": \"set\"\n" +
                "      },\n" +
                "      \"category4\": {\n" +
                "        \"items\": [\n" +
                "          \"BR-07\",\n" +
                "          \"BR-02\",\n" +
                "          \"BR-01\"\n" +
                "        ],\n" +
                "        \"type\": \"wrist\"\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";

        MirrarFragment fragment = null;
        try {
            fragment = new MirrarFragment(""/*login ID*/, ""/*password*/, new JSONObject(data) /*json object*/);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}