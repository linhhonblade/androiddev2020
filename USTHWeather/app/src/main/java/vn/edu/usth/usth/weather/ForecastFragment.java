package vn.edu.usth.usth.weather;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;


public class ForecastFragment extends Fragment {
//    ScrollView scrollView;



//    ImageView logo;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        FrameLayout frameLayout = (FrameLayout) inflater.inflate(R.layout.fragment_forecast, container, false);
        ScrollView scrollView = frameLayout.findViewById(R.id.scroll);
//        ScrollView scrollView = inflater.inflate(R.layout.fragment_forecast, container, false).findViewById(R.id.scroll);
//        ScrollView scrollView = (ScrollView) inflater.inflate(R.layout.fragment_forecast, container, false);
        LinearLayout linearLayout = scrollView.findViewById(R.id.weather);
        LinearLayout row;
        TextView txt;
        ImageView icon;
        TextView weather_txt;
//        logo = frameLayout.findViewById(R.id.logo);

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


        return frameLayout;
    }




}
