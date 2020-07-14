package com.elkanah.foodordermakert.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elkanah.foodordermakert.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);
        setUpNavigation(v);
        return v;
    }
    private void setUpNavigation(View rootView){
        BottomNavigationView bottomNavigationView = rootView.findViewById(R.id.DNavigation);
        NavHostFragment navHostFragment = (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.admin_nav_host);
        if (navHostFragment != null)
            NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.getNavController());
    }
}
