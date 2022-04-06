package com.codercamp.payertime.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Times {

@SerializedName("Imsak")
@Expose
private String imsak;
@SerializedName("Sunrise")
@Expose
private String sunrise;
@SerializedName("Fajr")
@Expose
private String fajr;
@SerializedName("Dhuhr")
@Expose
private String dhuhr;
@SerializedName("Asr")
@Expose
private String asr;
@SerializedName("Sunset")
@Expose
private String sunset;
@SerializedName("Maghrib")
@Expose
private String maghrib;
@SerializedName("Isha")
@Expose
private String isha;
@SerializedName("Midnight")
@Expose
private String midnight;

public String getImsak() {
return imsak;
}

public void setImsak(String imsak) {
this.imsak = imsak;
}

public String getSunrise() {
return sunrise;
}

public void setSunrise(String sunrise) {
this.sunrise = sunrise;
}

public String getFajr() {
return fajr;
}

public void setFajr(String fajr) {
this.fajr = fajr;
}

public String getDhuhr() {
return dhuhr;
}

public void setDhuhr(String dhuhr) {
this.dhuhr = dhuhr;
}

public String getAsr() {
return asr;
}

public void setAsr(String asr) {
this.asr = asr;
}

public String getSunset() {
return sunset;
}

public void setSunset(String sunset) {
this.sunset = sunset;
}

public String getMaghrib() {
return maghrib;
}

public void setMaghrib(String maghrib) {
this.maghrib = maghrib;
}

public String getIsha() {
return isha;
}

public void setIsha(String isha) {
this.isha = isha;
}

public String getMidnight() {
return midnight;
}

public void setMidnight(String midnight) {
this.midnight = midnight;
}

}