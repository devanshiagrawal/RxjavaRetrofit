package com.example.rxjavaretrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Employee {

    @SerializedName("firstName")
    @Expose
    private String firstName;

    @SerializedName("lastName")
    @Expose
    private String lastName;

    public String getFirstName() { return firstName; }

    public void setFirstName( String firstName ) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName( String lastName ) { this.lastName = lastName; }
}
