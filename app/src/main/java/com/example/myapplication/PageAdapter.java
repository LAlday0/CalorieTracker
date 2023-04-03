package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.fragments.FitnessGoals;
import com.example.myapplication.fragments.MealGuide;
import com.example.myapplication.fragments.ProgressLogs;

public class PageAdapter extends FragmentStateAdapter {
    public PageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FitnessGoals();
            case 1:
                return new MealGuide();
            case 2:
                return new ProgressLogs();
            default:
                return new FitnessGoals();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
