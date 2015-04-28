package org.esn.geekteam.npnancy15.models;

/**
 * Created by Spider on 28/04/15.
 */
public class OCMember {
    private String firstName;
    private String lastName;
    private String tel;
    private String post;

    public OCMember(String firstName, String lastName, String tel, String post) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
        this.post = post;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "OCMember{" +
                "post='" + post + '\'' +
                ", tel='" + tel + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
