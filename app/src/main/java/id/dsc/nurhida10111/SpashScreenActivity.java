package id.dsc.nurhida10111;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SpashScreenActivity extends AppCompatActivity {
    private static int interval=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen);

        final SharePrefence prefence=new SharePrefence(SpashScreenActivity.this);

        final String ket = prefence.getLogin();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (ket.equalsIgnoreCase("tidak")) {
                    Intent intent = new Intent(SpashScreenActivity.this, MainActivity.class);
                    startActivity(intent);

                } else {
                    Intent intent = new Intent(SpashScreenActivity.this, Duactivity.class);
                    startActivity(intent);
                }
            }
        },interval);
    }
}