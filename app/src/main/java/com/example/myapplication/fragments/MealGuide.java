package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;


public class MealGuide extends Fragment {

    ArrayList<FoodGroup> foodGroup;
    AdapterClass adapterClass;
    Integer count;

    int[] imgfoodPictures = {R.drawable.almonds,R.drawable.cereal,R.drawable.cheeesburger,R.drawable.chicksandwich,R.drawable.chickennoodlesoup,R.drawable.eggtoast,R.drawable.fruitbowl,R.drawable.kfc,R.drawable.meatcheese,R.drawable.oatmeal,R.drawable.proteinbar,R.drawable.shrimpfriedrice,R.drawable.steak,R.drawable.sub,R.drawable.veggieranch,R.drawable.chickensalad};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        foodGroup = new ArrayList<FoodGroup>();
        FoodGroup food0 = new FoodGroup(0, "Almonds", imgfoodPictures[0], 60);
        foodGroup.add(food0);
        FoodGroup food1 = new FoodGroup(1,"Cereal", imgfoodPictures[1], 180);
        foodGroup.add(food1);
        FoodGroup food2 = new FoodGroup(2,"Cheeseburger", imgfoodPictures[2], 570);
        foodGroup.add(food2);
        FoodGroup food3 = new FoodGroup(3,"Chicken Sandwich", imgfoodPictures[3], 650);
        foodGroup.add(food3);
        FoodGroup food4 = new FoodGroup(4,"Chicken Noodle Soup", imgfoodPictures[4], 223);
        foodGroup.add(food4);
        FoodGroup food5 = new FoodGroup(5,"Egg Toast", imgfoodPictures[5], 124);
        foodGroup.add(food5);
        FoodGroup food6 = new FoodGroup(6,"Fruit Bowl", imgfoodPictures[6], 89);
        foodGroup.add(food6);
        FoodGroup food7 = new FoodGroup(7,"KFC", imgfoodPictures[7], 487);
        foodGroup.add(food7);
        FoodGroup food8 = new FoodGroup(8,"Meat and Cheese", imgfoodPictures[8], 230);
        foodGroup.add(food8);
        FoodGroup food9 = new FoodGroup(9,"Oatmeal", imgfoodPictures[9], 140);
        foodGroup.add(food9);
        FoodGroup food10 = new FoodGroup(10,"Protein Bar", imgfoodPictures[10], 442);
        foodGroup.add(food10);

        adapterClass = new AdapterClass(foodGroup);
        View view = inflater.inflate(R.layout.fragment_meal_guide, parent, false);
        ListView listView = (ListView) view.findViewById(R.id.listFood);
        listView.setAdapter(adapterClass);
        // Inflate the layout for this fragment
        return view;
}

    class AdapterClass extends BaseAdapter {
        ArrayList<FoodGroup> l =new ArrayList<FoodGroup>();

        public AdapterClass(ArrayList<FoodGroup> i){

            this.l=i;
        }

        @Override
        public Object getItem(int position) {
            return l.get(position).foodName;
        }
        @Override
        public int getCount(){
            return l.size();
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater layoutInflater = getLayoutInflater();
            View v= layoutInflater.inflate(R.layout.foodlayout, null);
            TextView foodName = (TextView) v.findViewById(R.id.txtFoodName);
            TextView calories = (TextView) v.findViewById(R.id.txtCalories);
            ImageView foodPicture = (ImageView) v.findViewById(R.id.imgFoodPicture);
            foodName.setText(l.get(position).foodName);
            calories.setText(String.valueOf(l.get(position).calories));
            foodPicture.setImageResource(l.get(position).image);
            return v;
        }

    }

}