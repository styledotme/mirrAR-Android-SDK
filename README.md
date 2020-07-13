# Mirrar SDK

# How to import mirrAR android SDK

* Step 1 
``` File -> New -> New Module -> Import .jar/.aar and import your .aar.```
* Step 2
``` File -> Project structure -> Dependencies -> <All Modules> -> (Add jar dependencies by clicking on the '+' icon then select app-release)```
* Setp 3
``` Go to build.gradle (Module: app-release) -> remove the 'dependencies'```
* Step 4
``` AndroidManifest.xml -> Set android:allowBackup="false"```

* Add the following dependencies to the app level gradle file
    ` implementation 'com.google.android.material:material:1.2.0-alpha01'`
    
    `implementation 'com.google.firebase:firebase-ml-vision:24.0.1'`
    
    `implementation 'com.google.firebase:firebase-ml-vision-face-model:19.0.0'`

    `def camerax_version = "1.0.0-alpha05"`
    
    `implementation "androidx.camera:camera-core:${camerax_version}"`
    
    `implementation "androidx.camera:camera-camera2:${camerax_version}"`

    `implementation 'com.github.bumptech.glide:glide:4.11.0'`
    
    `api 'com.squareup.retrofit2:converter-gson:2.7.1'`
    
    `implementation 'com.squareup.okhttp3:logging-interceptor:4.4.0'`
    
    `implementation 'com.squareup.okhttp3:okhttp:4.4.0'`
    
    `api 'com.squareup.okhttp3:logging-interceptor:4.4.0'`
    
    `api 'com.squareup.retrofit2:converter-scalars:2.4.0'`
    
    `implementation 'com.amplitude:android-sdk:2.23.2'`


* Enable view binding and java 8 by adding the following block in the app level gradle file
```
    android{
        ...
            viewBinding {
            enabled = true
            }
        }
	
	compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
        }
       ...
```

* To show the viewer, add the following:
    1. In the layout file of your activity:
         ```
            <FrameLayout
             android:id="@+id/container"
             android:layout_width="match_parent"
             android:layout_height="match_parent"
             />
         ```

    2. In your activity/fragment class, add the following 
        
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

	```

	`R.id.container` is the container layout in which the viewer will be displayed.
	
	Type value: 
	  `ear - Earrings`
	  `neck - Necklaces`
	  `set - Necklace earrings pair`      
	  
		   
		
