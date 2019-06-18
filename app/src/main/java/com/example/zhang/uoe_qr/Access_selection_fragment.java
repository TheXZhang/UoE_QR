package com.example.zhang.uoe_qr;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Access_selection_fragment extends Fragment {

    List<Location> locationList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.access_selection_frag,container,false);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        locationList = new ArrayList<>();
        locationList.add(new Location("location1",R.drawable.test1));
        locationList.add(new Location("location2",R.drawable.test2));

        RecyclerView location_recycler = (RecyclerView) view.findViewById(R.id.location_recycler);
        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(getContext(),locationList);
        location_recycler.setLayoutManager(new GridLayoutManager(getContext(),3));
        location_recycler.setAdapter(mAdapter);
    }
}