package com.example.projectpresensi.view.adapter.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.projectpresensi.R;
import com.example.projectpresensi.data.model.Nilai;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;

public class RvAdapterTranskripNilai extends Adapter<RvAdapterTranskripNilai.MyViewHolder> {

    private Context context;
    private int idLayout;
    private List<Nilai> list = new ArrayList<>();

    public RvAdapterTranskripNilai(Context context, int idLayout) {
        this.context = context;
        this.idLayout = idLayout;
    }

    public void setData(List<Nilai> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RvAdapterTranskripNilai.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_transkrip_nilai, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RvAdapterTranskripNilai.MyViewHolder holder, int position) {
        Nilai nilai = list.get(position);
        holder.bind(nilai, position);
        holder.setLayout(idLayout);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends ViewHolder {

        private ViewGroup layoutParent;
        private TextView tvNo;
        private TextView tvKode;
        private TextView tvMakul;
        private TextView tvSifat;
        private TextView tvSks;
        private TextView tvNilai;
        private Nilai nilai;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            findView();
        }

        void bind(Nilai nilai, int position) {
            this.nilai = nilai;
            setBackground(position);
            loadView(position);
        }

        private void findView() {
            layoutParent = itemView.findViewById(R.id.ll_item_transkrip_nilai);
            tvNo = itemView.findViewById(R.id.tv_no_item_transkrip_nilai);
            tvKode = itemView.findViewById(R.id.tv_kode_item_transkrip_nilai);
            tvMakul = itemView.findViewById(R.id.tv_makul_item_transkrip_nilai);
            tvSifat = itemView.findViewById(R.id.tv_sifat_item_transkrip_nilai);
            tvSks = itemView.findViewById(R.id.tv_sks_item_transkrip_nilai);
            tvNilai = itemView.findViewById(R.id.tv_nilai_item_transkrip_nilai);
        }

        private void setBackground(int position) {
            if (position % 2 == 0) {
                layoutParent.setBackgroundResource(R.color.colorLightGray);
            } else {
                layoutParent.setBackgroundResource(R.color.colorWhite);
            }
        }

        private void loadView(int position) {
            tvNo.setText(String.valueOf(position + 1));
            tvKode.setText(nilai.getKode());
            tvMakul.setText(nilai.getMakul());
            tvSifat.setText(nilai.getSifat());
            tvSks.setText(nilai.getSks());
            tvNilai.setText(nilai.getNilai());
        }

        public void setLayout(int idLayout) {
            if (idLayout == 2) {
                tvSifat.setVisibility(GONE);
            }
        }
    }

}
