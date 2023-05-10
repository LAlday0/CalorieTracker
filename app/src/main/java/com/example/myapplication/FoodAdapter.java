package com.example.myapplication;

import static com.example.myapplication.MainActivity.cals;
import static com.example.myapplication.MainActivity.cals1;

import static com.example.myapplication.MainActivity.foodEditor;
import static com.example.myapplication.MainActivity.img;
import static com.example.myapplication.MainActivity.imgEditImage;
import static com.example.myapplication.MainActivity.nme;
import static com.example.myapplication.MainActivity.txtEditFoodCalories;
import static com.example.myapplication.MainActivity.txtEditFoodName;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

    public class FoodAdapter extends BaseAdapter {
        Context context;
        LayoutInflater layoutInflater;
        FoodGroup foodGroup = new FoodGroup();
        ArrayList<FoodGroup> l =new ArrayList<FoodGroup>();

        public FoodAdapter(Context context, ArrayList<FoodGroup> i){
            this.context = context;
            this.l=i;
            layoutInflater = LayoutInflater.from(this.context);
        }

        public static void setFoodName(String valueOf) {
        }

        @Override
        public FoodGroup getItem(int position) {
            return l.get(position);
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
            MyViewHolder myViewHolder;
            if (convertView == null){
                convertView = layoutInflater.inflate(R.layout.foodlayout, parent, false);
                myViewHolder = new MyViewHolder(convertView);
                convertView.setTag(myViewHolder);
                ImageView imgAdd = convertView.findViewById(R.id.imgAdd);
                ImageView imgEdit = convertView.findViewById(R.id.imgEdit);
                foodGroup = getItem(position);
                myViewHolder.txtFoodName.setText(foodGroup.getFoodName());
                myViewHolder.txtCalories.setText(String.valueOf(foodGroup.getCalories()));
                myViewHolder.foodPic.setImageResource(foodGroup.getImage());
                imgAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cals = Integer.valueOf(myViewHolder.txtCalories.getText().toString());
                        MainActivity.addFood(cals);
                    }
                });
                imgEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nme = myViewHolder.txtFoodName.getText();
                        cals1 = myViewHolder.txtCalories.getText();
                        img = myViewHolder.foodPic.getDrawable();
                        MainActivity.editFood();
                        myViewHolder.txtFoodName.setText(nme);
                        myViewHolder.txtCalories.setText(cals1);
                        myViewHolder.foodPic.setImageDrawable(img);
                    }
                });
            }
            else {
                myViewHolder = (MyViewHolder) convertView.getTag();
            }
            return convertView;
        }
        public class MyViewHolder{
            TextView txtFoodName, txtCalories;
            ImageView foodPic;

            public MyViewHolder (View view){
                txtFoodName = view.findViewById(R.id.txtFoodName);
                txtCalories = view.findViewById(R.id.txtCalories);
                foodPic = view.findViewById(R.id.imgFoodPicture);

            }
        }
    }

