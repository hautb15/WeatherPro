package hautb.org.weatherpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import hautb.org.weatherpro.databinding.ActivityMainBinding;

import hautb.org.weatherpro.model.MyWeather;

public class MainActivity extends AppCompatActivity implements MyWeatherTaskListener {

    private ActivityMainBinding binding;

    //Web URL of the JSON file
    private String mApiKey = "95a1e2b87ab5aa8a98204f5c4754d7f2";
    private String mCity = "Da Nang";
    private String mCountry = "VN";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //http://api.openweathermap.org/data/2.5/weather?q=city,country&APPID={your api key};
        String weatherURL = "http://api.openweathermap.org/data/2.5/weather?q=" + mCity + "," + mCountry + "&APPID=" + mApiKey;
        new MyWeatherTask(this).execute(weatherURL);
    }

    @Override
    public void onMyWeatherTaskPreExecute()
    {
        binding.myLoadingLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onMyWeatherTaskPostExecute(MyWeather myWeather)
    {
        if (myWeather != null)
        {
            binding.cityTextView.setText(mCity);
            binding.countryTextView.setText(mCountry);

            binding.weatherConditionTextView.setText(myWeather.getWeatherCondition());
            binding.weatherDescriptionTextView.setText(myWeather.getWeatherDescription());

            int temp = Math.round(myWeather.getTemperature() - 273.15f);
            String tempStr = String.valueOf(temp);
            binding.temperatureTextView.setText(tempStr);

            int wind = Math.round(myWeather.getWindspeed());
            String windStr = String.valueOf(wind);
            binding.windTextView.setText(windStr);

            String imgUrl = "http://openweathermap.org/img/wn/" + myWeather.getWeatherIconStr() + "@2x.png";

            Glide.with(MainActivity.this)
                    .asBitmap()
                    .load(imgUrl)
                    .placeholder(R.mipmap.ic_launcher)
                    .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE))
                    .into(binding.weatherIconImageView);
        }
        binding.myLoadingLayout.setVisibility(View.GONE);
    }

}