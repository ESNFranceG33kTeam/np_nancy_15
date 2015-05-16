package org.esn.geekteam.npnancy15.models;

import java.io.Serializable;

/**
 * Created by Spider on 06/05/15.
 */
public class Tips implements Serializable {
    private String title;
    private String description;

    public Tips(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Tips{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
