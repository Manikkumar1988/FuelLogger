package com.mani.fuellog.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mani.fuellog.R;
import com.mani.fuellog.viewmodel.FuelLogViewModel;

import java.util.ArrayList;
import java.util.List;


public class DashboardFragment extends Fragment {

    private ViewModelProvider.Factory fuelLogViewModelFactory;
    private FuelLogViewModel fuelLogViewModel;

    public DashboardFragment() {
        // Required empty public constructor
    }

    public static DashboardFragment newInstance(ViewModelProvider.Factory fuelLogViewModelFactory) {
        DashboardFragment dashboardFragment =  new DashboardFragment();
        dashboardFragment.fuelLogViewModelFactory = fuelLogViewModelFactory;
        return dashboardFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        RecyclerView recyclerView =  view.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        List<String> dataSet = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            dataSet.add("Item" + i);
        }
        CustomAdapter adapter = new CustomAdapter(dataSet, getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fuelLogViewModel = ViewModelProviders.of(getActivity(),fuelLogViewModelFactory)
                .get(FuelLogViewModel.class);

        //observeForAverageConsumption();
    }
}
