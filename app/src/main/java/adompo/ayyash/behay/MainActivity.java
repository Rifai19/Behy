package adompo.ayyash.behay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
            ulangIntro();


    }


    protected void ulangIntro(){
        PrefManager prefManager = new PrefManager(getApplicationContext());

        // make first time launch TRUE
        prefManager.setFirstTimeLaunch(true);

       // startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
       // finish();

    }
}
