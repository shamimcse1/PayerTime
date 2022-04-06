package com.codercamp.payertime.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Settings {

@SerializedName("timeformat")
@Expose
private String timeformat;
@SerializedName("school")
@Expose
private String school;
@SerializedName("juristic")
@Expose
private String juristic;
@SerializedName("highlat")
@Expose
private String highlat;
@SerializedName("fajr_angle")
@Expose
private Float fajrAngle;
@SerializedName("isha_angle")
@Expose
private Float ishaAngle;

public String getTimeformat() {
return timeformat;
}

public void setTimeformat(String timeformat) {
this.timeformat = timeformat;
}

public String getSchool() {
return school;
}

public void setSchool(String school) {
this.school = school;
}

public String getJuristic() {
return juristic;
}

public void setJuristic(String juristic) {
this.juristic = juristic;
}

public String getHighlat() {
return highlat;
}

public void setHighlat(String highlat) {
this.highlat = highlat;
}

public Float getFajrAngle() {
return fajrAngle;
}

public void setFajrAngle(Float fajrAngle) {
this.fajrAngle = fajrAngle;
}

public Float getIshaAngle() {
return ishaAngle;
}

public void setIshaAngle(Float ishaAngle) {
this.ishaAngle = ishaAngle;
}

}