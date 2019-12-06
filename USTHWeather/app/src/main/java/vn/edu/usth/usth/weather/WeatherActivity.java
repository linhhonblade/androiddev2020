package vn.edu.usth.usth.weather;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.zip.Inflater;

public class WeatherActivity extends AppCompatActivity {
    private static final String TAG = "Weather Activity";
    private ViewPager viewPager;
    private Adapter adapter;
    private TabLayout tabLayout;
    private File myFile;
    private String filename = "background.mp3";
    private String filepath;
    private final Handler networkHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            String content = msg.getData().getString("server_response");
            Toast.makeText(getApplicationContext(), content, Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public void onCreate(Bundle saveInstanceState){
        filepath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/vn.edu.usth.usth.weather/";
        Log.i("MP3 Image path File: ", filepath);
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_weather);
        Log.i(TAG, "This is onCreate function");

        viewPager = findViewById(R.id.pager);
        adapter = new Adapter(getSupportFragmentManager(), this.getApplicationContext());
        viewPager.setAdapter(adapter);
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

//        Create a new Fragment to be placed in the activity
//        ForecastFragment forecastFragment = new ForecastFragment();

//        Add the fragment to the 'container' FrameLayout
//        getSupportFragmentManager().beginTransaction().add(R.id.container, forecastFragment).commit();


//
//        writeExternal();
//        readFromExternal();

    }

    private void writeExternal() {
        try {
            InputStream is = getApplicationContext().getResources().openRawResource(R.raw.shiki);
            myFile = new File(filepath + filename);
            myFile.createNewFile();
            OutputStream fout = new FileOutputStream(myFile);
            byte[] buffer = new byte[1024];
            while (true) {
                int bytesRead = is.read(buffer);
                if (bytesRead == -1)
                    break;
                fout.write(buffer, 0, bytesRead);
            }
            fout.close();
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.app_bar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.refresh_button:
//                Thread t = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        // wait for 3s to simulate a network access
//                        try {
//                            Thread.sleep(3000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//
//                        // Assume we got our data from server
//                        Bundle bundle = new Bundle();
//                        bundle.putString("server_response", "some json here");
//
//                        // notify main thread
//                        Message msg = new Message();
//                        msg.setData(bundle);
//                        networkHandler.sendMessage(msg);
//                    }
//                });
//
//                t.start();

//                AsyncTask<String, Integer, String> task = new AsyncTask<String, Integer, String>() {
//                    @Override
//                    protected String doInBackground(String... strings) {
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e){
//                            e.printStackTrace();
//                        }
//                        return "some json here";
//                    }
//
//                    @Override
//                    protected void onPreExecute() {
//                        Toast.makeText(getApplicationContext(), "preparing for refresh", Toast.LENGTH_LONG);
//                    }
//
//                    @Override
//                    protected void onPostExecute(String content) {
//                        Toast.makeText(getApplicationContext(), content, Toast.LENGTH_LONG).show();
//                    }
//                };
//
//                task.execute("some useless url");

                AsyncTask<String, Integer, Bitmap> getLogoTask = new AsyncTask<String, Integer, Bitmap>() {
                    Bitmap bitmap;
                    HttpURLConnection connection;
                    @Override
                    protected Bitmap doInBackground(String... strings) {
                        URL url = null;
                        try {
                            url = new URL(strings[0]);
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        connection = null;
                        try {
                            connection = (HttpURLConnection) url.openConnection();
                            connection.setRequestMethod("GET");
                            connection.setDoInput(true);
                            connection.connect();
                            int response = connection.getResponseCode();
                            Log.i("From ForecastFragment", "The response code is " + response);
                        } catch (IOException ioException ) {
                            ioException.printStackTrace();
                        }
                        try {
                            InputStream is = connection.getInputStream();
                            bitmap = BitmapFactory.decodeStream(is);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        connection.disconnect();
                        return bitmap;
                    }

                    protected void onPostExecute(Bitmap bitmap) {
//                        ImageView imageView = findViewById(R.id.logo);
//                        imageView.setImageBitmap(bitmap);
                        WeatherAndForecastFragment weatherAndForecastFragment = (WeatherAndForecastFragment) adapter.instantiateItem(viewPager, viewPager.getCurrentItem());
                        ForecastFragment forecastFragment = (ForecastFragment) weatherAndForecastFragment.getChildFragmentManager().findFragmentById(R.id.fragment_forecast);
                        ImageView logo = forecastFragment.getView().findViewById(R.id.logo);
                        logo.setImageBitmap(bitmap);

                    }
                };
                getLogoTask.execute("https://usth.edu.vn/uploads/logo.png");
                break;
            case R.id.triple_dots_button:
                View triple_dot_view = findViewById(R.id.triple_dots_button);
                PopupMenu popupMenu = new PopupMenu(this, triple_dot_view);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.settings:
                                Intent intent = new Intent(getApplicationContext(), PrefActivity.class);
                                startActivity(intent);
                                return true;
                            case R.id.something:
                                Toast.makeText(getApplicationContext(), "something is something is doing something here", Toast.LENGTH_LONG).show();
                                return true;
                                default:
                                    return false;
                        }
                    }

                });
                popupMenu.inflate(R.menu.popup_menu);
                popupMenu.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }




    private void readFromExternal() {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(filepath + filename);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
