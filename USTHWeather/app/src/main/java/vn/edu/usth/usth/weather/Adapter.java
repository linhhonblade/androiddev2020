package vn.edu.usth.usth.weather;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Adapter extends FragmentPagerAdapter {

    Context context;

    public Adapter(FragmentManager fm, Context nContext) {
        super(fm);
        context = nContext;
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
                return context.getResources().getString(R.string.location_paris);
            case 1:
                return context.getResources().getString(R.string.location_hanoi);
            case 2:
                return context.getResources().getString(R.string.location_tokyo);
                default:
                    return "Somewhere";
        }
    }


}