package com.mubasher.amt.bo.amt_bo_rest_api.beans;

/**
 * Created by KalingaY on 2/3/2022.
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
