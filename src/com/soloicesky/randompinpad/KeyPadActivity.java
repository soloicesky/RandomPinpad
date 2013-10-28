package com.soloicesky.randompinpad;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class KeyPadActivity extends Activity {

	private static HashMap<String, String> keyCodeMap;
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_key_pad);
		keyCodeMap = new HashMap<String, String>();
		genRandomPinpad();
		tv = (TextView) findViewById(R.id.disp_pwd);
		tv.setText("");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_key_pad, menu);
		return true;
	}

	private void genRandomPinpad() {
		Button key;
		int i = 0;
		ArrayList<Integer> randomNumTable = RandomNumGenerator
				.generateRandomNumTable(0, 9);

		for (Integer integer : randomNumTable) {
			System.out.println(integer.toString());
			System.out.println(String.format("%d", i));

			if (keyCodeMap != null) {
				System.out.println("not null");
				keyCodeMap.put(String.format("%d", i), integer.toString());
			} else {
				System.out.println("key code is null!!!");
				return;
				// keyCodeMap = new HashMap<String, String>(null);
				// keyCodeMap.put(String.format("%d", i), integer.toString());
			}

			switch (i++) {
			case 0:
				key = (Button) findViewById(R.id.one_to_one);
				key.setText(integer.toString());
				break;
			case 1:
				key = (Button) findViewById(R.id.one_to_two);
				key.setText(integer.toString());
				break;
			case 2:
				key = (Button) findViewById(R.id.one_to_three);
				key.setText(integer.toString());
				break;
			case 3:
				key = (Button) findViewById(R.id.tow_to_one);
				key.setText(integer.toString());
				break;
			case 4:
				key = (Button) findViewById(R.id.tow_to_two);
				key.setText(integer.toString());
				break;
			case 5:
				key = (Button) findViewById(R.id.tow_to_three);
				key.setText(integer.toString());
				break;
			case 6:
				key = (Button) findViewById(R.id.three_to_one);
				key.setText(integer.toString());
				break;
			case 7:
				key = (Button) findViewById(R.id.three_to_two);
				key.setText(integer.toString());
				break;
			case 8:
				key = (Button) findViewById(R.id.three_to_three);
				key.setText(integer.toString());
				break;
			case 9:
				key = (Button) findViewById(R.id.four_to_one);
				key.setText(integer.toString());
				break;
			default:
				break;
			}

		}
	}

	public void reflesh(View v) {
		System.out.println("reflesh");
		genRandomPinpad();
	}

	public void putKeyOneToOne(View v) {
		tv.append(keyCodeMap.get("0").toString());
	}

	public void putKeyOneToTwo(View v) {
		tv.append(keyCodeMap.get("1").toString());
	}

	public void putKeyOneToThree(View v) {
		tv.append(keyCodeMap.get("2").toString());
	}

	public void putKeyTwoToOne(View v) {
		tv.append(keyCodeMap.get("3").toString());
	}

	public void putKeyTwoToTwo(View v) {
		tv.append(keyCodeMap.get("4").toString());
	}

	public void putKeyTwoToThree(View v) {
		tv.append(keyCodeMap.get("5").toString());
	}

	public void putKeyThreeToOne(View v) {
		tv.append(keyCodeMap.get("6").toString());
	}

	public void putKeyThreeToTwo(View v) {
		tv.append(keyCodeMap.get("7").toString());
	}

	public void putKeyThreeToThree(View v) {
		tv.append(keyCodeMap.get("8").toString());
	}

	public void putKeyFourToOne(View v) {
		tv.append(keyCodeMap.get("9").toString());
	}

	public void backSpace(View v) {
		if (tv.getText().length() != 0) {
			tv.setText(tv.getText().subSequence(0, tv.getText().length() - 1));
		}
	}

	public void clear(View v) {
		tv.setText("");
	}

	public void cancel(View v) {
		tv.setText("");
		Toast.makeText(this, "cancel input!!", Toast.LENGTH_LONG).show();
	}

	public void confirm(View v) {
		Toast.makeText(this, "you input :" + tv.getText(), Toast.LENGTH_LONG)
				.show();
	}
}
