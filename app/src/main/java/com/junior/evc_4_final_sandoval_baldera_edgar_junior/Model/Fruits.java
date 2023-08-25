package com.junior.evc_4_final_sandoval_baldera_edgar_junior.Model;

public class Fruits {


    private String name;
    private double calories;
    private double sugar;
    private double carbohydrates;
    private double protein;
    private String imgUrl;

    public Fruits(String name, double calories, double sugar, double carbohydrates, double protein, String imgUrl) {
        this.name = name;
        this.calories = calories;
        this.sugar = sugar;
        this.carbohydrates = carbohydrates;
        this.protein = protein;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
