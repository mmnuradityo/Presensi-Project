package com.example.projectpresensi.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectpresensi.R;
import com.example.projectpresensi.data.model.Mahasiswa;
import com.example.projectpresensi.data.sharedpref.PreferenceLogin;
import com.example.projectpresensi.view.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import static com.example.projectpresensi.AppApplication.db;
import static com.example.projectpresensi.data.repository.DefaultDataEntities.getDefaultMahasiswa;

public class ProfileFragment extends BaseFragment {

    private PreferenceLogin login;
    private List<String> listNim = new ArrayList<>();
    private Mahasiswa mahasiswa;
    private TextView tvNama;
    private TextView tvNim;
    private TextView tvKelas;
    private ImageView ivProfile;

    public ProfileFragment() {
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_profile;
    }

    @Override
    public void initComponent(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        login = PreferenceLogin.getInstance(getActivity());
    }

    @Override
    public void findView(View v) {
        tvNama = v.findViewById(R.id.tv_nama_profile);
        tvNim = v.findViewById(R.id.tv_nim_profile);
        tvKelas = v.findViewById(R.id.tv_kelas_profile);
        ivProfile = v.findViewById(R.id.iv_profile);
    }

    @Override
    public void initView() {

    }

    @Override
    public void loadView() {
        listNim = db.mahasiswaDao().getNim();

        if (listNim == null
                || listNim.size() == 0) {
            for (Mahasiswa mahasiswa : getDefaultMahasiswa()) {
                db.mahasiswaDao().insert(mahasiswa);
            }
        }
    }

    @Override
    public void listener() {
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        mahasiswa = db.mahasiswaDao().getSingleData(login.getNim());
        tvNama.setText(mahasiswa.getNama());
        tvNim.setText(mahasiswa.getNim());
        tvKelas.setText(mahasiswa.getKelas());

        if (mahasiswa.getFoto() == 1) {
            ivProfile.setImageResource(R.drawable.abdul);
        } else if (mahasiswa.getFoto() == 2) {
            ivProfile.setImageResource(R.drawable.nuraeni);
        } else {
            ivProfile.setImageResource(R.drawable.agus);
        }

    }


}
