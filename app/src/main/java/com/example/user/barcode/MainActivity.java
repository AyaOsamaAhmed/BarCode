package com.example.user.barcode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

//https://code.tutsplus.com/tutorials/reading-qr-codes-using-the-mobile-vision-api--cms-24680
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Bitmap myQRCode = BitmapFactory.decodeStream(
                    getAssets().open("mybarcode.png")
            );


        BarcodeDetector barcodeDetector = new BarcodeDetector.Builder(this)
                        .setBarcodeFormats(Barcode.QR_CODE)
                        .build();

        Frame myFrame = new Frame.Builder().setBitmap(myQRCode).build();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
