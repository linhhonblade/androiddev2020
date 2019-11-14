package vn.edu.usth.usth.weather;

import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ForecastFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//         Inflate the layout for this fragment
//         View v = new View(getContext());
//         v.setBackgroundColor(0xFFFF0000);


        TextView day_text = new TextView(getActivity());
        day_text.setText("Thursday");
        day_text.setGravity(Gravity.CENTER);

        ImageView weatherIcon = new ImageView(getActivity());
        weatherIcon.setImageResource(R.drawable.rainy);

        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setBackgroundColor(0xFF11DDCC);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(day_text);
        linearLayout.addView(weatherIcon);

        return linearLayout;
    }

}
