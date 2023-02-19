package data.contries.cities;

import data.contries.ContryData;

public enum RussiaCitiesData implements ICities{

    VORONEZH("Воронеж", ContryData.RUSSIA);

    private String citiesName;
    private ContryData contryData;

    RussiaCitiesData(String citiesName,ContryData contryData) {
        this.citiesName = citiesName;
        this.contryData = contryData;
    }

    public String getCitiesName() {
        return citiesName;
    }

    public ContryData getContryData(){
        return contryData;
    }

    @Override
    public String getName() {
        return citiesName;
    }
}

