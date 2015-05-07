package app.easyroom.com.br;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import app.easyroom.com.br.MainActivity;
import app.easyroom.com.br.R;

/**
 * Created by PAULO on 08/03/2015.
 */
public class SplashActivity extends Activity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler splashScreen = new Handler();
        splashScreen.postDelayed(SplashActivity.this, 3000);
    }

    @Override
    public void run() {
        Intent telaMain = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(telaMain);
        finish();
    }
}
