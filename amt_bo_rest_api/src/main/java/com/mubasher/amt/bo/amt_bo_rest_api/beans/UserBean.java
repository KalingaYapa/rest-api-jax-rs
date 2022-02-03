package com.mubasher.amt.bo.amt_bo_rest_api.beans;

import javax.persistence.*;
import java.util.function.UnaryOperator;

/**
 * Created by KalingaY on 2/3/2022.
 */
@Entity
@Table(name = "USER_TEST")
public class UserBean implements User {
    @Id
    @GeneratedValue(generator = "idSeq")
    @SequenceGenerator(name = "idSeq", sequenceName = "USER_TEST_ID_SEQ", allocationSize = 1)
    @Column(name = "ID", columnDefinition = "NUMBER(10)")
    private int id;
    @Column(name = "FIRST_NAME", columnDefinition = "NUMBER(10)")
    private String firstName;
    @Column(name = "LAST_NAME", columnDefinition = "NUMBER(10)")
    private String lastName;
    @Column(name = "AGE", columnDefinition = "NUMBER(10)")
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}