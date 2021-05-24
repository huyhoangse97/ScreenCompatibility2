package com.example.screencompatibility2;

public interface Contract {
    interface View{

        void updateWeatherBG(String weatherName);

        void updateWeatherName(String weatherName);
    }

    interface Model{

        String forecastWeather(long celsius, long humidity);
    }

    interface Presenter{

        void forecast(long celsius, long humidity);
    }
}
