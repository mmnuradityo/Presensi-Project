package com.example.projectpresensi.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projectpresensi.R;
import com.example.projectpresensi.data.model.Presence;
import com.example.projectpresensi.view.adapter.recyclerview.RvAdapterPresence;
import com.example.projectpresensi.view.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import static com.example.projectpresensi.AppApplication.db;
import static com.example.projectpresensi.data.repository.DefaultDataEntities.getDefaultPresence;

public class PresenceFragment extends BaseFragment {

    private RecyclerView rvPresence;
    private RvAdapterPresence adapter;
    private List<Presence> presences = new ArrayList<>();

    public PresenceFragment() {
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_presence;
    }

    @Override
    public void initComponent(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        adapter = new RvAdapterPresence(getActivity());
    }

    @Override
    public void findView(View v) {
        rvPresence = v.findViewById(R.id.rv_presence);
    }

    @Override
    public void initView() {
        rvPresence.setHasFixedSize(true);
        rvPresence.setAdapter(adapter);
    }

    @Override
    public void loadView() {
        presences = db.presenceDao().getAll();
        if (presences == null
                || presences.size() == 0) {
            for (Presence presence : getDefaultPresence()) {
                db.presenceDao().insert(presence);
            }
        }
    }

    @Override
    public void listener() {

    }

    @Override
    public void onResume() {
        super.onResume();
        presences = db.presenceDao().getAll();
        adapter.setData(presences);

    }
}
