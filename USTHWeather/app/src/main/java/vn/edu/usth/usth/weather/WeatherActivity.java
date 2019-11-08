package vn.edu.usth.usth.weather;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class WeatherActivity extends AppCompatActivity {
    private static final String TAG = "Weather Activity";

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        Log.i(TAG, "This is onCreate function");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG, "This is onStart function");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG, "This is oneResume function");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG, "This is onPause function");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG, "This is onStop function");
    }

    @Override
    protected  void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "This is onDestroy function");
    }
}
