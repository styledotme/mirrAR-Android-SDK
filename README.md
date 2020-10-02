# Mirrar SDK

# How to import mirrAR android SDK

* Step 1 
``` File -> New -> New Module -> Import .jar/.aar and import your .aar.```
* Step 2
In your project’s build.gradle (the one under ‘app’) add the following:

`dependencies {
implementation project(':library-release')
}`

	Clean Build after all the above steps.

* Step 3  
Add Kotlin to your project classpath and applies the Kotlin and Kotlin Android Extensions plugins to each module that contains Kotlin files. Your build.gradle files should look similar to the examples below
  
Project build.gradle file.

`dependencies {
	...
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72"
    }`
  
App build.gradle file  
```
apply plugin: 'kotlin-android-extensions'
apply plugin: 'kotlin-android'

android {
    ...
    
    buildFeatures {
        viewBinding true
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {
	...
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.7.1'

    implementation "androidx.core:core-ktx:1.3.1"
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.72"
    implementation 'com.google.code.gson:gson:2.8.6'
    
    implementation project(':library-release')
}

```

* To show the viewer, add the following:

    1. In the Manifeast add the following
      ```
      <uses-permission android:name="android.permission.CAMERA"/>
      <uses-permission android:name="android.permission.INTERNET"/>

      <uses-feature
        android:name="android.hardware.camera"
        android:required="true" />
      ```
    
    2. In the layout file of your activity/fragment add the following
         ```
            <FrameLayout
             android:id="@+id/container"
             android:layout_width="match_parent"
             android:layout_height="match_parent"
             />
         ```

    3. In your activity/fragment class, add the following 
        
	 ``` 
	         JSONObject data = null;
        try {
            data = new JSONObject("{\"options\":{\"productData\":{\"category1\":{\"items\":[\"500005DMAABA04\",\"500005SFAABA02\",\"500005SFAABA09\"],\"type\":\"ear\"},\"category2\":{\"items\":[\"502118YEEAAA32\",\"502118YENAAA32\",\"502118YEOAAA32\"],\"type\":\"neck\"},\"category3\":{\"items\":[\"5027182ADABA02\",\"5027182AJABA02\",\"5027182AKABA02\"],\"type\":\"set\"},\"category4\":{\"items\":[\"502516NFEAAB32_N\",\"5027182ADABA02_N\",\"5027182AJABA02_N\"],\"type\":\"neck\"},\"category5\":{\"items\":[\"5031181DXAAA09\",\"5132181BUABA00\",\"5132181BWABA00\"],\"type\":\"set\"},\"category6\":{\"items\":[\"500005PFAAAA09\",\"500005PFAAAB22\",\"500006PEAAAA09\"],\"type\":\"neck\"}}}}");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        
# Note: enable camera permission before initializing the fragment

        MirrarFragment fragment = new MirrarFragment(""/*login ID*/, ""/*password*/, data /*json object*/);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
		
	* Override these two method 
	
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

	```

	`R.id.container` is the container layout in which the viewer will be displayed.
	
	Type value: 
	  `ear - Earrings`
	  `neck - Necklaces`
	  `set - Necklace earrings pair`      
	  
		   
# License validity along with active product codes & types supported can be determined from this API -
curl --location --request POST 'https://mirrar.styledotme.com/api/v2/login' \
--form 'username=/*login ID*/' \
--form 'password=/*password*/' \
--form 'type=android_sdk'

```
{
  "meta": {
    "code": 200,
    "message": "You have successfully logged in"
  },
  "data": {
    "access_token": ###,
    "uuid": ###,
    "name": ###,
    "webar_status": 0,
    "admin_status": 1,
    "warp_status": 0,
    "instore_status": 1,
    "android_sdk_bundle": "",
    "ios_sdk_bundle": "",
    "webar_sdk_domain": "",
    "max_design_count": 10000,
    "brand_type": "FINE",
    "design_count": 200,
    "logo_url": "https://mirrar.s3.ap-south-1.amazonaws.com/raghav/logo.png",
    "bucket_name": ###,
    "has_subsidiary": 0,
    "instore_expires_at": "2100-01-01 00:00:00",
    "webar_expires_at": "2100-01-01 00:00:00",
    "warp_expires_at": "2100-01-01 00:00:00",
    "active_product_codes": {
      "Earrings": {
        "items": [
          1,
          "112A",
        ],
        "type": "ear"
      },
      "Necklaces": {
        "items": [
          "2CD",
          "XYZA"
        ],
        "type": "neck"
      },
      "Sets": {
        "items": [
          "TEST123"
        ],
        "type": "set"
      }
    }
  }
}
```
