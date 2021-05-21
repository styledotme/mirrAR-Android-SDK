package com.sdm.mirrar.sampleproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sdm.mirrar.library.MirrarFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    MirrarFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.launchMirrar).setOnClickListener(view -> {
            try {
                JSONObject data = new JSONObject("{\"options\":{\"productData\":{\"Earrings\":{\"items\":[\"0079-500x500\",\"0097-500x500\",\"00118-500x500sdfghjk\"],\"type\":\"ear\"},\"Sets\":{\"items\":[\"DSC_0206S\",\"DSC_0204S\"],\"type\":\"set\"}}}\n" +
                        "}");

                fragment = new MirrarFragment(data, "brandID" /*,new Bitmap() (bitmap is optional)*/);

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.container_layout, fragment).commit();
                findViewById(R.id.launchMirrar).setVisibility(View.GONE);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (fragment != null && fragment.isBack()) {
            fragment.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStop() {
        if (fragment != null) {
            fragment.closePreview();
        }
        super.onStop();
    }
}