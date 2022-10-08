package com.example.ieeehackathon;

import java.io.Serializable;

public class Patient implements Serializable {
    String name;
    String Specialist;
    String Description;
    int age;
    int priority;

    public Patient (String N, int Age, String doc, int P, String desc) {
        name = N;
        age = Age;
        priority = P;
        Specialist = doc;
        Description = desc;
    }

    public String getName() {
        return name;
    }
    public String getSpec() {
        return Specialist;
    }
    public String getDesc() {
        return Description;
    }
    public int age() {
        return age;
    }

    public int getPrior(){
        return priority;
    }
}
