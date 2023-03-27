package ru.semenova.spring.models;

//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotEmpty;

import jakarta.validation.constraints.*;

public class Book {

    private int id;

    @NotEmpty(message = "Данное поле не должно быть путсым.")
    private String title;

    @NotEmpty(message = "Данное поле не должно быть путсым.")
    private String author;

    @Min(value = 1800, message = "Введите корректный год.")
    private int yearOfProduction;

    private int personId;

    public Book(){

    }

    public Book(int id, String title, String author, int yearOfProduction, int personId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearOfProduction = yearOfProduction;
        this.personId = personId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
