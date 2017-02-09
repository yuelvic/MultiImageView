package com.stfalcon.multiimageview.sample;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.stfalcon.multiimageview.MultiImageView;

public class MainActivity extends AppCompatActivity {
    private int imageCount = 0;
    private static final String URL = "http://mystar1053.com/wp-content/uploads/2013/02/HarveyGreySuitPortrait-col-low-res.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MultiImageView multiImageView = (MultiImageView) findViewById(R.id.iv);

        //add images
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageCount += 1;
                if (imageCount == 1) {
                    multiImageView.addImage(MainActivity.this, URL);
                } else if (imageCount == 2) {
                    multiImageView.addImage(BitmapFactory.decodeResource(getResources(), R.drawable.avatar2));
                } else if (imageCount == 3) {
                    multiImageView.addImage(BitmapFactory.decodeResource(getResources(), R.drawable.avatar3));
                } else if (imageCount == 4) {
                    multiImageView.addImage(BitmapFactory.decodeResource(getResources(), R.drawable.avatar4));
                } else {
                    multiImageView.clear();
                    imageCount = 0;
                }
            }
        });

        //set corner radius for rectangle shape
        multiImageView.setRectCorners(50);

        //Change shape of image
        Button buttonShape = (Button) findViewById(R.id.buttonShape);
        buttonShape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (multiImageView.getShape() == MultiImageView.Shape.NONE) {
                    multiImageView.setShape(MultiImageView.Shape.RECTANGLE);
                } else if (multiImageView.getShape() == MultiImageView.Shape.RECTANGLE) {
                    multiImageView.setShape(MultiImageView.Shape.CIRCLE);
                } else {
                    multiImageView.setShape(MultiImageView.Shape.NONE);
                }
            }
        });
    }
}
