package com.qrcode;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.zxing.activity.CaptureActivity;

/**
扫描二维码（QRcode）程序，并返回识别结果
**/
public class MainActivity extends Activity {
	
	private TextView startTextView = null;
	private TextView endTextView = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        startTextView = (TextView) this.findViewById(R.id.start_result);
        endTextView = (TextView) this.findViewById(R.id.end_result);
        
        Button startBarCodeButton = (Button) this.findViewById(R.id.start_qrcode);
        startBarCodeButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
					
				Intent openCameraIntent = new Intent(MainActivity.this,CaptureActivity.class);
				startActivityForResult(openCameraIntent, 0);
			}
		});
        
        Button endBarCodeButton = (Button) this.findViewById(R.id.end_qrcode);
        endBarCodeButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
					
				Intent openCameraIntent = new Intent(MainActivity.this,CaptureActivity.class);
				startActivityForResult(openCameraIntent, 1);
			}
		});
        
    }

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	
		if (resultCode == RESULT_OK) {
			
			if(requestCode == 0){
				
			Bundle bundle = data.getExtras();
			String scanResult = bundle.getString("result");
			startTextView.setText(scanResult);
			
			}else if(requestCode == 1){
				
				Bundle bundle = data.getExtras();
				String scanResult = bundle.getString("result");
				endTextView.setText(scanResult);
			}
			
			
		}
	}
}