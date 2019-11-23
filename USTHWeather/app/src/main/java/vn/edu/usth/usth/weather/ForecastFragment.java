package vn.edu.usth.usth.weather;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Random;


public class ForecastFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ScrollView scrollView = (ScrollView) inflater.inflate(R.layout.fragment_forecast, container, false);
        LinearLayout linearLayout = scrollView.findViewById(R.id.weather);
        LinearLayout row;
        TextView txt;
        ImageView icon;
        TextView weather_txt;


        String days[] = getResources().getStringArray(R.array.day_array);
        String weather[] = getResources().getStringArray(R.array.weather_array);

        Random r = new Random();
        int a;

        for(int i = 0; i < 20; i ++){
            row = (LinearLayout) inflater.inflate(R.layout.row, container, false);

            txt = row.findViewById(R.id.txt_day);
            icon = row.findViewById(R.id.icon);
            weather_txt = row.findViewById(R.id.weather_txt);

            a = r.nextInt(50);
            txt.setText(days[i % 7]);
            weather_txt.setText(weather[a % 4]);
            switch (a % 4){
                case 0:
                    icon.setImageResource(R.drawable.rain);
                    break;
                case 1:
                    icon.setImageResource(R.drawable.sunny);
                    break;
                case 2:
                    icon.setImageResource(R.drawable.heavy_rain);
                    break;
                case 3:
                    icon.setImageResource(R.drawable.cloudy);
                    break;
            }

            linearLayout.addView(row);


        }


        return scrollView;
    }

}
