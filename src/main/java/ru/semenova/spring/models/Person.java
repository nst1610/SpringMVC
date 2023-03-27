package ru.semenova.spring.models;

//старое
import jakarta.validation.constraints.*;

public class Person {
    private int id;

    @NotEmpty(message = "Данное поле не должно быть пустым.")
    @Pattern(regexp = "[А-Я]\\S+ [А-Я]\\S+ [А-Я]\\S+", message = "Введите имя в формате: Фамилия Имя Отчество")
    private String fullName;

    @Min(value = 1900, message = "Введите корректный год рождения.")
    private int yearOfBirth;

    public Person(){

    }

    public Person(int id, String fullName, int yearOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
