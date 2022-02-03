package com.mubasher.amt.bo.user.beans;

/**
 * Created by KalingaY on 1/28/2022.
 */
public interface User {
    public int getId();

    public void setId(int id);

    public String getFirstName();

    public void setFirstName(String firstName);

    public String getLastName();

    public void setLastName(String lastName);

    public int getAge();

    public void setAge(int age);
}
