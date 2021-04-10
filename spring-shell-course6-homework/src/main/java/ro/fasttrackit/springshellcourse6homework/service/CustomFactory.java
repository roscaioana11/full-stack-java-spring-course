package ro.fasttrackit.springshellcourse6homework.service;

public interface CustomFactory <T>{
    T getFromString(String s);
}
