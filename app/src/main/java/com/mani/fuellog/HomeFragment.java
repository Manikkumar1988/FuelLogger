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

public class HomeFragment extends Fragment {

    private ViewModelProvider.Factory fuelLogViewModelFactory;
    private FuelLogViewModel fuelLogViewModel;

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

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fuelLogViewModel = ViewModelProviders.of(getActivity(),fuelLogViewModelFactory)
                .get(FuelLogViewModel.class);

        observeForAverageConsumption();
    }

    private void observeForAverageConsumption() {
        fuelLogViewModel.getAverageFuelConsumption().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                ((TextView)getView().findViewById(R.id.average_consumption_value)).setText(String.valueOf(aDouble));
            }
        });
    }
}