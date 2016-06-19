package com.high_mobility.digitalkey;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.high_mobility.HMLink.Broadcasting.ByteUtils;
import com.high_mobility.digitalkey.broadcast.BroadcastActivity;
import com.high_mobility.digitalkey.scan.ScanActivity;

public class MainActivity extends AppCompatActivity {
    public static final byte[] CaPrivateKey = ByteUtils.bytesFromHex("***REMOVED***");
    public static final byte[] CaPublicKey = ByteUtils.bytesFromHex("***REMOVED***");
    public static final byte[] CaAppId = ByteUtils.bytesFromHex("***REMOVED***");
    public static final byte[] CaIssuer = ByteUtils.bytesFromHex("48494D4F");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, BroadcastActivity.class);
        startActivity(intent);
    }

    void onBroadcastClicked(View v) {
        Intent intent = new Intent(this, BroadcastActivity.class);
        startActivity(intent);
    }

    void onScanClicked(View v) {
        Intent intent = new Intent(this, ScanActivity.class);
        startActivity(intent);
    }
}
