package com.mani.fuellog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.mani.fuellog.viewmodel.FuelLogViewModel;
import com.mani.fuellog.viewmodel.FuelStat;

import java.util.Objects;

public class HomeFragment extends Fragment {

    private ViewModelProvider.Factory fuelLogViewModelFactory;
    private FuelLogViewModel fuelLogViewModel;

    private TextView averageConsumptionValue, drivingCost, totalDistance, totalAmouunt, totalFuelConsumption;

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(ViewModelProvider.Factory fuelLogViewModelFactory) {
        HomeFragment homeFragment =  new HomeFragment();
        homeFragment.fuelLogViewModelFactory = fuelLogViewModelFactory;
        return homeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initializeViews(view);

        return view;
    }

    private void initializeViews(View view) {
        averageConsumptionValue = view.findViewById(R.id.average_consumption_value);
        drivingCost = view.findViewById(R.id.driving_cost_value);
        totalDistance = view.findViewById(R.id.total_distance_value);
        totalAmouunt = view.findViewById(R.id.total_amount_value);
        totalFuelConsumption = view.findViewById(R.id.total_consumption_value);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fuelLogViewModel = ViewModelProviders.of(getActivity(),fuelLogViewModelFactory)
                .get(FuelLogViewModel.class);

        observeForAverageConsumption();
    }

    private void observeForAverageConsumption() {
        fuelLogViewModel.getAverageFuelConsumption().observe(this, new Observer<FuelStat>() {
            @Override
            public void onChanged(FuelStat fuelStat) {
                if(Objects.isNull(fuelStat)) {
                    averageConsumptionValue.setText(getText(R.string.empty_value));
                    drivingCost.setText(getText(R.string.empty_value));
                    totalDistance.setText(getText(R.string.empty_value));
                    totalAmouunt.setText(getText(R.string.empty_value));
                    totalFuelConsumption.setText(getText(R.string.empty_value));
                } else {
                    averageConsumptionValue.setText(String.valueOf(fuelStat.getAverageConsumption()));
                    drivingCost.setText(String.valueOf(fuelStat.getDrivingCost()));
                    totalDistance.setText(String.valueOf(fuelStat.getTotalDistance()));
                    totalAmouunt.setText(String.valueOf(fuelStat.getTotalAmount()));
                    totalFuelConsumption.setText(String.valueOf(fuelStat.getTotalFuelConsumption()));
                }
            }
        });
    }
}