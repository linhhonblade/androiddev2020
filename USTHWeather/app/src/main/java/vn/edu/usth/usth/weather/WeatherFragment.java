package vn.edu.usth.usth.weather;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment {


    public WeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RelativeLayout weather_fragment = (RelativeLayout) inflater.inflate(R.layout.fragment_weather, container, false);

        TextView location = weather_fragment.findViewById(R.id.top_right);
        int pos = Integer.parseInt(getArguments().getString("position"));
        switch (pos){
            case 1:
                location.setText("Paris");
                break;
            case 2:
                location.setText("Hanoi");
                break;
            case 3:
                location.setText("Tokyo");
                break;
        }

        return weather_fragment;
    }

}
