package com.example.screencompatibility2;

public class Presenter implements com.example.screencompatibility2.Contract.Presenter{
    com.example.screencompatibility2.Contract.Model model;

    com.example.screencompatibility2.Contract.View view;

    public Presenter(com.example.screencompatibility2.Contract.Model model, com.example.screencompatibility2.Contract.View view){
        this.model = model;
        this.view = view;
    };

    @Override
    public void forecast(long celsius, long humidity) {
        String weatherName = model.forecastWeather(celsius, humidity);
        view.updateWeatherBG(weatherName);
        weatherName = Utils.convertString(weatherName);
        view.updateWeatherName(weatherName);
    }
}
