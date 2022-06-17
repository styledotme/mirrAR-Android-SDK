package com.sdm.mirrar.sampleproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sdm.mirrar.library.MirrarFragment;
import com.sdm.mirrar.library.MyMirrarListener;

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
                JSONObject data = new JSONObject("{\"options\":{\"productData\":{\"Pendants\":{\"items\":[\"PENDENT24\"],\"type\":\"neck\"}}}}");

                fragment = new MirrarFragment(data, "116f058c-5be4-4206-9c5f-e568568544b2");

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.container_layout, fragment).commit();
                findViewById(R.id.launchMirrar).setVisibility(View.GONE);

                fragment.setMirrarListener(new MyMirrarListener() {
                    @Override
                    public void onSubmitReview() {
                        Log.d("checkListener", "onSubmitReview: ");
                    }

                    @Override
                    public void onSdkLoaded() {
                        Log.d("checkListener", "onSdkLoaded: ");
                    }

                    @Override
                    public void onBackPressed() {
                        Log.d("checkListener", "onBackPressed: ");
                    }

                    @Override
                    public void onTakePhoto() {
                        Log.d("checkListener", "onTakePhoto: ");
                    }

                    @Override
                    public void onClickWhatsapp(String imageUrl) {
                        Log.d("checkListener", "onClickWhatsapp: " + imageUrl);

                    }

                    @Override
                    public void onClickShare(Bitmap image) {
                        Log.d("checkListener", "onClickShare: " + image);

                    }

                    @Override
                    public void onClickDownload(Bitmap image) {
                        Log.d("checkListener", "onClickDownload: " + image);
                    }

                    @Override
                    public void onClickDetails(String productCode) {
                        Log.d("checkListener", "onClickDetails: " + productCode);
                    }

                    @Override
                    public void onClickCart(String productCode) {
                        Log.d("checkListener", "onClickCart: " + productCode);

                    }

                    @Override
                    public void onClickWhishlist(String productCode) {
                        Log.d("checkListener", "onClickWhishlist: " + productCode);

                    }

                    @Override
                    public void onClickUnWhishlist(String productCode) {
                        Log.d("checkListener", "onClickDetails: " + productCode);

                    }

                    @Override
                    public void onClickUnCart(String productCode) {
                        Log.d("checkListener", "onClickUnCart: " + productCode);
                    }

                    @Override
                    public void onJewellerySelect(String productCode) {
                        Log.d("checkListener", "onJewellerySelect: " + productCode);
                    }

                    @Override
                    public void exceptionOccur() {
                        Log.d("checkListener", "exception: " );

                    }
                });

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
    protected void onDestroy() {
        if (fragment != null) {
            fragment.closePreview();
        }
        super.onDestroy();
    }
}