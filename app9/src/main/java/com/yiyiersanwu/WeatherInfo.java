package com.yiyiersanwu;

public class WeatherInfo {
    //  数据格式实例{"temp":"20℃/30℃","weather":"晴转多云","name":"上海","pm":"80","wind":"1级"}
    private String temp;
    private String weather;
    private String name;
    private String pm;
    private String wind;



    //toString方法
    @Override
    public String toString() {
        return "WeatherInfo{" +
                "temp='" + temp + '\'' +
                ", weather='" + weather + '\'' +
                ", name='" + name + '\'' +
                ", pm='" + pm + '\'' +
                ", wind='" + wind + '\'' +
                '}';
    }

    //getter和setter方法
    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }
}
