package com.suriyal.webservicehwfetchs;

public class DataModel {
    private int id;
    private String name;
    private int salary;
    private String phone;

    public DataModel(int id,String name,int salary,String phone)
    {
        this.id=id; //int
        this.name=name;
        this.salary=salary; //int
        this.phone=phone;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public String getPhone() {
        return phone;
    }
}
