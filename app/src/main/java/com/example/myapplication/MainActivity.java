package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<FoodGroup> myList;
    FoodGroup foodGroup;
    static FoodAdapter foodAdapter;
    static LinearLayout foodEditor;
    static ListView listFood;
    static CharSequence nme;
    static Integer cals;
    static CharSequence cals1;
    static Drawable img;
    static Button btnTotalCalories;
    ImageView imgAdd, imgEdit;
    static Integer total=0;
    static EditText txtEditFoodName, txtEditFoodCalories;
    static ImageView imgEditImage;
    static
    String[] breakfastFoodName = {"Breakfast Tacos", "Smoothie", "Granola", "Fruit Salad", "Eggs and Vegetables", "Eggs and Toast", "Acai Bowl", "Protein Shake", "Protein Bar", "Bagel"};
    int [] breakfastFoodCalories = {409, 320, 236, 93, 220, 379, 238, 188, 237, 245};
    int[] breakfastFoodPictures = {R.drawable.tacos,R.drawable.smoothie ,R.drawable.granola ,R.drawable.fruitbowl ,R.drawable.eggveg ,R.drawable.eggtoast ,R.drawable.acai ,R.drawable.protienshake ,R.drawable.proteinbar ,R.drawable.bagel};
    //String[] lunchFoodName = {"Sandwich", "Pizza", "Soup", "Sushi", "Wings", "Chicken w/ Rice", "Cheeseburger", "Salad", "Wrap", "Pasta"};
    //int [] lunchFoodCalories = {361, 285, 79, 152, 332, 448, 487, 92, 189, 399};
    //int[] lunchFoodPictures = {R.drawable.sandw,R.drawable.pizza , , , , , , , , , , , , , };
    //String[] dinnerFoodName = {"Steak w/ Potatoes", "Chuck Roast", "Chicken Pot Pie", "Meat Loaf", "Chicken w/ Gravy", "Shepherd's Pie", "Vegetable Soup", "Kabobs", "Chili", "Cabbage Rolls"};
    //int [] dinnerFoodCalories = {700, 362, 599, 414, 387, 553, 311, 251, 348, 117};
    //int[] dinnerFoodPictures = {, , , , , , , , , , , , , , };
    //String[] snackFoodName = {"", "", "", "", "", "", "", "", "", ""};
    //int [] snackFoodCalories = {, , , , , , , , , };
    //int[] snackFoodPictures = {, , , , , , , , , , , , , , };
    Integer i=0;
    static Button btnApply, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listFood = findViewById(R.id.listFood);
        btnTotalCalories = findViewById(R.id.btnTotalCalories);
        btnApply = findViewById(R.id.btnApply);
        btnCancel = findViewById(R.id.btnCancel);
        foodEditor = findViewById(R.id.foodEditor);
        imgEditImage = findViewById(R.id.imgEditImage);
        txtEditFoodName = findViewById(R.id.txtEditFoodName);
        txtEditFoodCalories = findViewById(R.id.txtEditFoodCalories);
        myList = new ArrayList<>();
        foodGroup = new FoodGroup();
        foodEditor.setVisibility(View.GONE);
        while (i<=9){
            foodGroup.setFoodName(breakfastFoodName[i]);
            foodGroup.setCalories(breakfastFoodCalories[i]);
            foodGroup.setImage(breakfastFoodPictures[i]);
            myList.add(foodGroup);
            foodGroup = new FoodGroup();
            i++;
        }
        foodAdapter = new FoodAdapter(MainActivity.this, myList);
        listFood.setAdapter(foodAdapter);
        }
    public static void addFood(Integer calories){
        total = total += calories;
        btnTotalCalories.setText("Total Calories: " +total);
    }
    public static void editFood(){
        foodEditor.setVisibility(View.VISIBLE);
        txtEditFoodName.setText(nme);
        txtEditFoodCalories.setText(cals1);
        imgEditImage.setImageDrawable(img);
        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               nme = txtEditFoodName.getText();
               cals1 = txtEditFoodCalories.getText();
               img = imgEditImage.getDrawable();
                FoodAdapter.setFoodName(String.valueOf(nme));
                listFood.setAdapter(foodAdapter);
                foodEditor.setVisibility(View.GONE);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodEditor.setVisibility(View.GONE);
            }
        });

    }
}