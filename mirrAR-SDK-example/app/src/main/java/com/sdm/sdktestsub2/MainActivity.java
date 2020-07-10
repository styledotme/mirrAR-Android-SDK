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

        JSONObject data = {
  			"productData": {
  				  "category1": {
  				    "items": [  "sku1", "sku2", "sku3"],
				    "type": "ear"
				    }, 
				  "category2": {
				    "items": [ "sku1", "sku2", "sku3"],
				    "type": "neck"
				    },
				  "category3": {
				    "items": [ "sku1", "sku2", "sku3"],
				    "type": "set"},
				  "category4": {
				    "items": ["sku1", "sku2", "sku3"],
				    "type": "ear"
				   }
				  }
				 }

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
