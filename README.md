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
          ```String data =  
           {
                "data": {
                  "Earrings": {
                    "Gold_Set_KJ-51": {
                      "data": {
                        "collection": "Gold Set",
                        "image_url": "https://s3.ap-south-1.amazonaws.com/mirrar/kashi/inventory/Earrings/KJ-51.png",
                        "location": "Kashi Jewellers",
                        "material_type": "Gold",
                        "picker_value": "View Details",
                        "total_price": " "
                      },
                      "height": 72.5,
                      "inventory": [
                        {
                          "Color_Stone_Weight": "1.81gm",
                          "Gold KT": "22KT",
                          "Gross Weight": "22.05gm",
                          "Net Weight": "20.24gm"
                        }
                      ],
                      "size_multiplier": 1,
                      "x_offset": -3,
                      "y_offset": -14,
                      "InventoryCount": -1,
                      "total_price": " "
                    }
                  },
                  "Necklaces": {
                    "Kundan_KJ-123": {
                      "data": {
                        "collection": "Kundan",
                        "image_url": "https://s3.ap-south-1.amazonaws.com/mirrar/kashi/inventory/Necklaces/KJ-123.png",
                        "location": "Kashi Jewellers",
                        "material_type": "Gold",
                        "picker_value": "View Details",
                        "total_price": " "
                      },
                      "height": 193.18182373046875,
                      "inventory": [
                        {
                          "Color_Stone_Weight": "4.30gm",
                          "Gold KT": "22KT",
                          "Gross Weight": "73.15gm",
                          "Net Weight": "68.85gm"
                        }
                      ],
                      "size_multiplier": 1,
                      "x_offset": 0,
                      "y_offset": 0,
                      "InventoryCount": -1,
                      "total_price": " "
                    }
                  }
                }
              }
       //fill data as prescribled
       ```
       
		```
         MirrarFragment fragment = new MirrarFragment(data);
         getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container, fragment)
                            .commit();
        ```
		   
		  `R.id.container` is the container layout in which the viewer will be displayed.
		   
		
