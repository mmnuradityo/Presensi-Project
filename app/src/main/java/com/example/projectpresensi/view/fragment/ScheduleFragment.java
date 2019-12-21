package com.example.projectpresensi.view.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projectpresensi.R;
import com.example.projectpresensi.data.model.Schedule;
import com.example.projectpresensi.view.adapter.recyclerview.RvAdapterSchedule;
import com.example.projectpresensi.view.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import static com.example.projectpresensi.AppApplication.db;
import static com.example.projectpresensi.data.repository.DefaultDataEntities.getDefaultSchedule;
import static com.example.projectpresensi.view.adapter.recyclerview.RvAdapterSchedule.SheduleOnClick;

public class ScheduleFragment extends BaseFragment implements SheduleOnClick {

    private RecyclerView rvPresence;
    private RvAdapterSchedule adapter;
    private List<Schedule> schedules = new ArrayList<>();

    public ScheduleFragment() {
    }


    @Override
    public int setLayout() {
        return R.layout.fragment_schedule;
    }

    @Override
    public void initComponent(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        adapter = new RvAdapterSchedule(this, getActivity());
    }

    @Override
    public void findView(View v) {
        rvPresence = v.findViewById(R.id.rv_schedule);
    }

    @Override
    public void initView() {
        rvPresence.setHasFixedSize(true);
        rvPresence.setAdapter(adapter);
    }

    @Override
    public void loadView() {
        schedules = db.scheduleDao().getAll();
        if (schedules == null
                || schedules.size() == 0) {
            for (Schedule schedule : getDefaultSchedule()) {
                db.scheduleDao().insert(schedule);
            }
        }
    }

    @Override
    public void listener() {

    }

    @Override
    public void onResume() {
        super.onResume();
        schedules = db.scheduleDao().getAll();
        adapter.setData(schedules);
    }

    @Override
    public void onItemClick(String makul) {
        Toast.makeText(getActivity(), makul, Toast.LENGTH_SHORT).show();
    }

}
