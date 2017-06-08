package com.example.tbessho.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tbessho on 6/7/2017.
 */

public class Camera_Activity extends Activity{

    Button button;
    ImageView imageView;
    static final int CAM_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_activity);
        button = (Button) findViewById(R.id.button_capture);
        imageView = (ImageView) findViewById(R.id.imageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));

                startActivityForResult(cameraIntent, CAM_REQUEST);
            }

        });
    }

    private File getFile(){
        File folder = new File ("sdcard/camera_app");
        if (!folder.exists()){
            folder.mkdir();
        }
        //creating a media file name with the date
        String timeStamp  = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File image_file = new File(folder, "IMG_" + timeStamp + ".jpg");
        return image_file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        String path = "sdcard/camera_app/cam_image.jpg";
        imageView.setImageDrawable(Drawable.createFromPath(path));
    }
}

