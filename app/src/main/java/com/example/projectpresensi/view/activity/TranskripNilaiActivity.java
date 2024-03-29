package com.example.projectpresensi.view.activity;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectpresensi.R;
import com.example.projectpresensi.data.model.Nilai;
import com.example.projectpresensi.view.adapter.recyclerview.RvAdapterTranskripNilai;
import com.example.projectpresensi.view.base.BaseActivity;

import static com.example.projectpresensi.AppApplication.db;
import static com.example.projectpresensi.data.repository.DefaultDataEntities.getDefaultNilai;

public class TranskripNilaiActivity extends BaseActivity {

    private Toolbar toolbar;
    private RecyclerView rvTranskripNilai; // list untuk menampilkan data
    private ImageView ivBack;
    private RvAdapterTranskripNilai adater; // class adapter list

    @Override
    public int setLayout() {
        return R.layout.activity_transkrip_nilai;
    }

    @Override
    public void initComponent(Bundle savedInstanceState) {
        adater = new RvAdapterTranskripNilai(this, 1);// inisiasi class adapter list
    }

    @Override
    public void findView() {
        toolbar = findViewById(R.id.toolbar_transkrip_nilai);
        rvTranskripNilai = findViewById(R.id.rv_transkrip_nilai);
        ivBack = findViewById(R.id.iv_back_transkrip_nilai);
    }

    @Override
    public void initView() {
        // konfigurasi custom appbar
        toolbar.setTitle("Transkrip Nilai");
        setSupportActionBar(toolbar);
        // konfigurasi list
        rvTranskripNilai.setHasFixedSize(true);
        rvTranskripNilai.setAdapter(adater);
    }

    @Override
    public void loadView() {
        // memasukan data default ke databse
        if (db.nilaiDao().getAll() == null
                || db.nilaiDao().getAll().size() == 0) {
            for (Nilai nilai : getDefaultNilai()) {
                db.nilaiDao().insert(nilai);
            }
        }
    }

    @Override
    public void listener() {
        ivBack.setOnClickListener(v -> onBackPressed());
    }

    @Override
    protected void onResume() {
        super.onResume();
        // mengambil data dari database dan menampilkan data ke list
        adater.setData(db.nilaiDao().getAll());
    }

}
