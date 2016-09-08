package jp.techacademy.yusuke2.suzuki.aisatsuapp;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            showTimePickerDialog();
//            mTextView.setText(mEditText.getText().toString());
        }
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
//                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));//ここは特に意味がないが残しておく。


                        TextView textView = (TextView) findViewById(R.id.textView);
                        //2:00 ~ 9:59 では「おはよう」
                        if (hourOfDay >= 2 && hourOfDay < 10) {
                            textView.setText("おはよう");
                        //10:00 ~ 17:59 では「こんにちは」
                        } else if (hourOfDay >= 10 && hourOfDay < 18) {
                            textView.setText("こんにちは");
                        //18:00 ~ 1:59 では「こんばんは」
                        } else {
                            textView.setText("こんばんは");
                        }

                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }
}