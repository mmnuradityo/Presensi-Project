package com.example.projectpresensi.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.projectpresensi.R;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScannerActivity extends Activity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZXingScannerView(this);
        mScannerView.setBorderColor(getResources().getColor(R.color.colorPrimary));
        mScannerView.setSquareViewFinder(true);
        mScannerView.setAutoFocus(true);
        setContentView(mScannerView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
        Toast.makeText(this, "Scanner dalam tahap pengembangan", Toast.LENGTH_SHORT).show();
        mScannerView.resumeCameraPreview(this);
    }
}
