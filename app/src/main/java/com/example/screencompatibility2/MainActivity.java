package com.example.screencompatibility2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements Contract.View{

    Contract.Presenter presenter;

    private ImageView iv_banner;
    private TextView tv_weather;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().getInsetsController().hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());

        presenter = new Presenter(new Model(), this);
        iv_banner = findViewById(R.id.iv_banner);
        tv_weather = findViewById(R.id.tv_weather_name);
        Button btn_forecast = findViewById(R.id.btn_forecast);
        EditText et_temperature = findViewById(R.id.et_temperature);
        EditText et_humidity = findViewById(R.id.et_humidity);

        iv_banner.setClipToOutline(true);

        btn_forecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celsiusStr = et_temperature.getText().toString();
                String humidityStr = et_humidity.getText().toString();
                if (celsiusStr.length() == 0){
                    et_temperature.setError("Please enter the Temperature!");
                }
                else if (humidityStr.length() == 0){
                    et_humidity.setError("Please enter the Humidity!");
                }
                else {
                    long celsius = (long) Integer.parseInt(celsiusStr);
                    long humidity = (long) Integer.parseInt(humidityStr);
                    presenter.forecast(celsius, humidity);
                }
            }
        });
    }

    @Override
    public void updateWeatherBG(String weatherName) {
        int drawId = getResources().getIdentifier(weatherName, "drawable", getPackageName());
        iv_banner.setImageResource(drawId);
    }

    @Override
    public void updateWeatherName(String weatherName) {
        tv_weather.setText(weatherName);
    }
}