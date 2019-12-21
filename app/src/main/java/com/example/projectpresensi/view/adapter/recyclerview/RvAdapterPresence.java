package com.example.projectpresensi.view.adapter.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.projectpresensi.R;
import com.example.projectpresensi.data.model.Presence;

import java.util.ArrayList;
import java.util.List;

import static androidx.recyclerview.widget.RecyclerView.Adapter;
import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class RvAdapterPresence extends Adapter<RvAdapterPresence.MyViewHolder> {

    private Context context;
    private List<Presence> list = new ArrayList<>();

    public RvAdapterPresence(Context context) {
        this.context = context;
    }

    public void setData(List<Presence> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_presence, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Presence presence = list.get(position);
        holder.bind(presence, position + 1);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends ViewHolder {

        private Presence presence;
        private TextView tvNo;
        private TextView tvMakul;
        private TextView tvPresensi;
        private int position;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            findView();
        }

        void bind(Presence presence, int position) {
            this.presence = presence;
            this.position = position;
            initView();
        }

        private void findView() {
            tvNo = itemView.findViewById(R.id.tv_no_item_presnce);
            tvMakul = itemView.findViewById(R.id.tv_makul_item_presnce);
            tvPresensi = itemView.findViewById(R.id.tv_presensi_item_presnce);
        }

        private void initView() {
            tvNo.setText(String.valueOf(position));
            tvMakul.setText(presence.getMakul());
            tvPresensi.setText(String.valueOf(presence.getPresensi()));
        }

    }

}
