package com.lappungdev.dilatasiwaktu.activity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.lappungdev.dilatasiwaktu.R;
import com.lappungdev.dilatasiwaktu.adapter.NumberTextWatcherForThousand;

public class MainActivity extends AppCompatActivity {

    EditText etVelocity, etTime;
    private Dialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etVelocity = findViewById(R.id.etVelocity);
        etVelocity.addTextChangedListener(new NumberTextWatcherForThousand(etVelocity));
        etTime = findViewById(R.id.etTime);
        etTime.addTextChangedListener(new NumberTextWatcherForThousand(etTime));
    }


    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    public void contoh(View view) {
        alertDialog = new Dialog(this);
        alertDialog.setContentView(R.layout.example);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
    }
}
