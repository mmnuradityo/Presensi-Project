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

    private RecyclerView rvPresence;  // list untuk menampilkan data
    private RvAdapterPresence adapter; // class adapter list
    private List<Presence> presences = new ArrayList<>(); // list array

    public PresenceFragment() {
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_presence;
    }

    @Override
    public void initComponent(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        adapter = new RvAdapterPresence(getActivity()); // inisiasi class adapter list
    }

    @Override
    public void findView(View v) {
        rvPresence = v.findViewById(R.id.rv_presence);
    }

    @Override
    public void initView() {
        // konfigurasi list
        rvPresence.setHasFixedSize(true);
        rvPresence.setAdapter(adapter);
    }

    @Override
    public void loadView() {
        // masukan isi database ke array list
        presences = db.presenceDao().getAll();
        // cek isi list
        if (presences == null
                || presences.size() == 0) {
            // memasukan data default ke databse bila kosong
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
        // menampilkan isi list
        adapter.setData(presences);

    }
}
