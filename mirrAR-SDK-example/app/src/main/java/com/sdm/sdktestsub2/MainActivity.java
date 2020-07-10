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

        JSONObject data = null;
        try {
            data = new JSONObject("{\"options\":{\"productData\":{\"category1\":{\"items\":[\"500005DMAABA04\",\"500005SFAABA02\",\"500005SFAABA09\"],\"type\":\"ear\"},\"category2\":{\"items\":[\"502118YEEAAA32\",\"502118YENAAA32\",\"502118YEOAAA32\"],\"type\":\"neck\"},\"category3\":{\"items\":[\"5027182ADABA02\",\"5027182AJABA02\",\"5027182AKABA02\"],\"type\":\"set\"},\"category4\":{\"items\":[\"502516NFEAAB32_N\",\"5027182ADABA02_N\",\"5027182AJABA02_N\"],\"type\":\"neck\"},\"category5\":{\"items\":[\"5031181DXAAA09\",\"5132181BUABA00\",\"5132181BWABA00\"],\"type\":\"set\"},\"category6\":{\"items\":[\"500005PFAAAA09\",\"500005PFAAAB22\",\"500006PEAAAA09\"],\"type\":\"neck\"}}}}");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        MirrarFragment fragment = new MirrarFragment("tanishqwebar"/*login ID*/, "w4y0EihepyIAA50U"/*password*/, data /*json object*/);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}
