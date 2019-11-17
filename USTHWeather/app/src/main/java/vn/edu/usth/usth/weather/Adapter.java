package vn.edu.usth.usth.weather;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Adapter extends FragmentPagerAdapter {

    public Adapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int pos) {
        WeatherAndForecastFragment weatherAndForecastFragment = new WeatherAndForecastFragment();
        Bundle bundle = new Bundle();
        pos = pos + 1;
        bundle.putString("position", Integer.toString(pos));
        weatherAndForecastFragment.setArguments(bundle);
        return  weatherAndForecastFragment;
    }

    @Override
    public int getCount() { return 3; }

    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "Paris";
            case 1:
                return "Hanoi";
            case 2:
                return "Tokyo";
                default:
                    return "Somewhere";
        }
    }
}
