package org.esn.geekteam.npnancy15.models;

/**
 * Created by Spider on 29/04/15.
 */
public class Schedule {
    private String date;
    private String hour;
    private String title;
    private String address;

    public Schedule(String date, String hour, String title, String address) {
        this.date = date;
        this.hour = hour;
        this.title = title;
        this.address = address;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
