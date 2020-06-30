# Mirrar SDK

* To enable sdk, add the following dependencies to the gradle file
    `implementation 'com.google.android.material:material:1.2.0-alpha01'`
    `implementation 'com.google.firebase:firebase-ml-vision:24.0.1'`
    `implementation 'com.google.firebase:firebase-ml-vision-face-model:19.0.0'`

    `def camerax_version = "1.0.0-alpha05"`
    `implementation "androidx.camera:camera-core:${camerax_version}"`
    `implementation "androidx.camera:camera-camera2:${camerax_version}"`

    `implementation 'com.github.bumptech.glide:glide:4.11.0'`


* Enable view binding by adding the following block in the gradle file
```
    android{
        ...
            viewBinding {
            enabled = true
            }
        ...
        }
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
          ```options = {
			productData: {
			         category1: {
					items: [sku1, sku2, sku3, ...],
					type: "ear"
        			},
        			category2: {
			             items: [sku1, sku2, sku3, ...],
			             type: "neck"
			         },
			        category3: {
			            items: [sku1, sku2, sku3, ...],
			            type: "set"
			        },
			        category4: {
			             items: [sku1, sku2, sku3, ...],
			             type: "ear"
				}
        		.
        		.
        		.
		}```
       
	```
         MirrarFragment fragment = new MirrarFragment(username, password, data);
         getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container, fragment)
                            .commit();
        ```
		   
		  `R.id.container` is the container layout in which the viewer will be displayed.
		   
		
