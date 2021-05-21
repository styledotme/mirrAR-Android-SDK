package com.sdm.sdktestsub2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.sdm.mirrar.library.MirrarFragment;
import com.sdm.mirrar.sampleproject.R;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONObject data = null;
        try {
            data = new JSONObject("{\"options\":{\"productData\":{\"Earrings\":{\"items\":[\"500005DMAABA04\",\"20KE10\",\"20KE11\",\"500005SFAABA02\",\"500005SFAABA09\"],\"type\":\"ear\"},\"Mangalsutras\":{\"items\":[\"502118YEEAAA32\",\"502118YENAAA32\",\"502118YEOAAA32\"],\"type\":\"neck\"},\"NecklaceSets\":{\"items\":[\"5027182ADABA02\",\"5027182AJABA02\",\"5027182AKABA02\"],\"type\":\"set\"},\"Necklaces\":{\"items\":[\"502516NFEAAB32_N\",\"CH11\",\"CH12\",\"5027182ADABA02_N\",\"5027182AJABA02_N\"],\"type\":\"neck\"},\"PendantSets\":{\"items\":[\"5031181DXAAA09\",\"5132181BUABA00\",\"5132181BWABA00\"],\"type\":\"set\"},\"Pendants\":{\"items\":[\"500005PFAAAA09\",\"500005PFAAAB22\",\"500006PEAAAA09\"],\"type\":\"neck\"}}}}");
        } catch (JSONException e) {
            e.printStackTrace();
        }

//        MirrarFragment fragment = new MirrarFragment(""/*login ID*/, ""/*password*/, data /*json object*/);
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.container, fragment)
//                .commit();
    }
}
