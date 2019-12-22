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

public class KhsActivity extends BaseActivity {

    private Toolbar toolbar;
    private RecyclerView rvKhs; // list untuk menampilkan data
    private ImageView ivBack;
    private RvAdapterTranskripNilai adater; // class adapter list

    @Override
    public int setLayout() {
        return R.layout.activity_khs;
    }

    @Override
    public void initComponent(Bundle savedInstanceState) {
        adater = new RvAdapterTranskripNilai(this, 2); // inisiasi class adapter list
    }

    @Override
    public void findView() {
        toolbar = findViewById(R.id.toolbar_khs);
        rvKhs = findViewById(R.id.rv_khs);
        ivBack = findViewById(R.id.iv_back_khs);
    }

    @Override
    public void initView() {
        // konfigurasi custom appbar
        toolbar.setTitle("Khs");
        setSupportActionBar(toolbar);
        // konfigurasi list
        rvKhs.setHasFixedSize(true);
        rvKhs.setAdapter(adater);
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
