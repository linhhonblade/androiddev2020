package vn.edu.usth.usth.weather;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends AppCompatActivity {
    private static final String TAG = "Weather Activity";
    private ViewPager viewPager;
    private Adapter adapter;
    private TabLayout tabLayout;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_weather);
        Log.i(TAG, "This is onCreate function");

        viewPager = findViewById(R.id.pager);
        adapter = new Adapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

//        Create a new Fragment to be placed in the activity
//        ForecastFragment forecastFragment = new ForecastFragment();

//        Add the fragment to the 'container' FrameLayout
//        getSupportFragmentManager().beginTransaction().add(R.id.container, forecastFragment).commit();

    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG, "This is onStart function");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG, "This is onResume function");
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
