package com.amazingabhishek.sdktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sdm.mirrar.mirrar.MirrarFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String data = "{\n" +
                "                \"data\": {\n" +
                "                  \"Earrings\": {\n" +
                "                    \"Gold_Set_KJ-51\": {\n" +
                "                      \"data\": {\n" +
                "                        \"collection\": \"Gold Set\",\n" +
                "                        \"image_url\": \"https://s3.ap-south-1.amazonaws.com/mirrar/kashi/inventory/Earrings/KJ-51.png\",\n" +
                "                        \"location\": \"Kashi Jewellers\",\n" +
                "                        \"material_type\": \"Gold\",\n" +
                "                        \"picker_value\": \"View Details\",\n" +
                "                        \"total_price\": \" \"\n" +
                "                      },\n" +
                "                      \"height\": 72.5,\n" +
                "                      \"inventory\": [\n" +
                "                        {\n" +
                "                          \"Color_Stone_Weight\": \"1.81gm\",\n" +
                "                          \"Gold KT\": \"22KT\",\n" +
                "                          \"Gross Weight\": \"22.05gm\",\n" +
                "                          \"Net Weight\": \"20.24gm\"\n" +
                "                        }\n" +
                "                      ],\n" +
                "                      \"size_multiplier\": 1,\n" +
                "                      \"x_offset\": -3,\n" +
                "                      \"y_offset\": -14,\n" +
                "                      \"InventoryCount\": -1,\n" +
                "                      \"total_price\": \" \"\n" +
                "                    }\n" +
                "                  },\n" +
                "                  \"Necklaces\": {\n" +
                "                    \"Kundan_KJ-123\": {\n" +
                "                      \"data\": {\n" +
                "                        \"collection\": \"Kundan\",\n" +
                "                        \"image_url\": \"https://s3.ap-south-1.amazonaws.com/mirrar/kashi/inventory/Necklaces/KJ-123.png\",\n" +
                "                        \"location\": \"Kashi Jewellers\",\n" +
                "                        \"material_type\": \"Gold\",\n" +
                "                        \"picker_value\": \"View Details\",\n" +
                "                        \"total_price\": \" \"\n" +
                "                      },\n" +
                "                      \"height\": 193.18182373046875,\n" +
                "                      \"inventory\": [\n" +
                "                        {\n" +
                "                          \"Color_Stone_Weight\": \"4.30gm\",\n" +
                "                          \"Gold KT\": \"22KT\",\n" +
                "                          \"Gross Weight\": \"73.15gm\",\n" +
                "                          \"Net Weight\": \"68.85gm\"\n" +
                "                        }\n" +
                "                      ],\n" +
                "                      \"size_multiplier\": 1,\n" +
                "                      \"x_offset\": 0,\n" +
                "                      \"y_offset\": 0,\n" +
                "                      \"InventoryCount\": -1,\n" +
                "                      \"total_price\": \" \"\n" +
                "                    }\n" +
                "                  }\n" +
                "                }\n" +
                "              }";

        MirrarFragment fragment = new MirrarFragment(data);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}
