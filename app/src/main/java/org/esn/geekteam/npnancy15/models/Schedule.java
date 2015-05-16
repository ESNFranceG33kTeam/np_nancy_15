package org.esn.geekteam.npnancy15.models;

/**
 * Created by Spider on 29/04/15.
 */
public class Schedule {
    private String date;
    private String hour;
    private String description;
    private String type;
    private String speaker;
    private int backgroundColor;
    private Place place;

    public Schedule(String date, String hour, String description, String type, String speaker, Place place) {
        this.date = date;
        this.hour = hour;
        this.description = description;
        this.type = type;
        this.speaker = speaker;
        this.place = place;
    }

    public Schedule(String date, String hour, String description, String type, String speaker, int backgroundColor) {
        this.date = date;
        this.hour = hour;
        this.description = description;
        this.type = type;
        this.speaker = speaker;
        this.backgroundColor = backgroundColor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", speaker='" + speaker + '\'' +
                ", place=" + place +
                '}';
    }
}
