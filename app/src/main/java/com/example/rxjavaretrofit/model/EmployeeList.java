package com.example.rxjavaretrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeList {

    @SerializedName("employees")
    @Expose

    private List<Employee> employees = null;

    public List<Employee> getEmployees(){ return employees; }

    public void setEmployees( List<Employee> employees ){ this.employees = employees; }

}
