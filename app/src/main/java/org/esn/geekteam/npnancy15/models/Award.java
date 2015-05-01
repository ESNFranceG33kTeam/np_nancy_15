package org.esn.geekteam.npnancy15.models;

/**
 * Created by Spider on 30/04/15.
 */
public class Award {
    private String name;

    public Award(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Award{" +
                "name='" + name + '\'' +
                '}';
    }
}
