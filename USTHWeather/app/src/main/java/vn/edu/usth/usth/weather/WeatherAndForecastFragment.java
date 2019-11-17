package vn.edu.usth.usth.weather;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherAndForecastFragment extends Fragment {


    public WeatherAndForecastFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();

        WeatherFragment weatherFragment = new WeatherFragment();
        weatherFragment.setArguments(this.getArguments());

        ForecastFragment forecastFragment = new ForecastFragment();


        fragmentTransaction.replace(R.id.fragment_weather, weatherFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        fragmentTransaction.replace(R.id.fragment_forecast, forecastFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);



        fragmentTransaction.commit();

        LinearLayout fragment_weather = (LinearLayout) inflater.inflate(R.layout.fragment_weather_and_forecast, container, false);


        return fragment_weather;
    }

}
