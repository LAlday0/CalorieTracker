package com.example.myapplication.fragments;

import android.view.View;


public class FoodGroup{
    public String foodName;
    public int image;
    public int calories, id;

    public FoodGroup(int id, String foodName, int image, int calories){
    this.id = id;
    this.foodName = foodName;
    this.image = image;
    this.calories = calories;
    }
}
