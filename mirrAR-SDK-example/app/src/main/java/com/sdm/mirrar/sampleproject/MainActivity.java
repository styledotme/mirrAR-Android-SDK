package com.sdm.mirrar.sampleproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.sdm.mirrar.library.MirrarFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            JSONObject data = new JSONObject("{\"options\":{\"productData\":{\"Earrings\":{\"items\":[\"500005DMAABA04\",\"500005SFAABA02\",\"500005SFAABA09\"],\"type\":\"ear\"},\"Mangalsutras\":{\"items\":[\"502118YEEAAA32\",\"502118YENAAA32\",\"502118YEOAAA32\"],\"type\":\"neck\"},\"NecklaceSets\":{\"items\":[\"5027182ADABA02\",\"5027182AJABA02\",\"5027182AKABA02\"],\"type\":\"set\"},\"Necklaces\":{\"items\":[\"502516NFEAAB32_N\",\"5027182ADABA02_N\",\"5027182AJABA02_N\"],\"type\":\"neck\"},\"PendantSets\":{\"items\":[\"5031181DXAAA09\",\"5132181BUABA00\",\"5132181BWABA00\"],\"type\":\"set\"},\"Pendants\":{\"items\":[\"500005PFAAAA09\",\"500005PFAAAB22\",\"500006PEAAAA09\"],\"type\":\"neck\"}}}}");

            MirrarFragment fragment = new MirrarFragment(data, "loginID", "password");

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container_layout, fragment).commit();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}