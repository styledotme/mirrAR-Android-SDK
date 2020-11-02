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
                JSONObject data = new JSONObject("{\"options\":{\"productData\":{\"Earrings\":{\"items\":[\"500005DMAABA04\",\"500005SFAABA02\",\"500005SFAABA09\"],\"type\":\"ear\"},\"Mangalsutras\":{\"items\":[\"502118YEEAAA32\",\"502118YENAAA32\",\"502118YEOAAA32\"],\"type\":\"neck\"},\"NecklaceSets\":{\"items\":[\"5027182ADABA02\",\"5027182AJABA02\",\"5027182AKABA02\"],\"type\":\"set\"},\"Necklaces\":{\"items\":[\"502516NFEAAB32_N\",\"5027182ADABA02_N\",\"5027182AJABA02_N\"],\"type\":\"neck\"},\"PendantSets\":{\"items\":[\"5031181DXAAA09\",\"5132181BUABA00\",\"5132181BWABA00\"],\"type\":\"set\"},\"Pendants\":{\"items\":[\"500005PFAAAA09\",\"500005PFAAAB22\",\"500006PEAAAA09\"],\"type\":\"neck\"}}}}");
                fragment = new MirrarFragment(data, "userID", "password");

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