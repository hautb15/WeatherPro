package hautb.org.weatherpro.model;

public class MyWeather {
    private String weatherCondition;
    private String weatherDescription;
    private String weatherIconStr;
    private float windSpeed;
    private float temperature;

    public String getWeatherCondition()
    {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition)
    {
        this.weatherCondition = weatherCondition;
    }

    public String getWeatherDescription()
    {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription)
    {
        this.weatherDescription = weatherDescription;
    }

    public String getWeatherIconStr()
    {
        return weatherIconStr;
    }

    public void setWeatherIconStr(String weatherIconStr)
    {
        this.weatherIconStr = weatherIconStr;
    }

    public float getTemperature()
    {
        return temperature;
    }

    public void setTemperature(float temperature)
    {
        this.temperature = temperature;
    }

    public float getWindspeed() { return windSpeed; }

    public void setWindspeed(float windSpeed)
    {
        this.windSpeed = windSpeed;
    }

}
