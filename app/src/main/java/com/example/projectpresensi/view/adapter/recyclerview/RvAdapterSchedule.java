package com.example.projectpresensi.view.adapter.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.projectpresensi.R;
import com.example.projectpresensi.data.model.Schedule;

import java.util.ArrayList;
import java.util.List;

import static androidx.recyclerview.widget.RecyclerView.Adapter;
import static androidx.recyclerview.widget.RecyclerView.OnClickListener;
import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class RvAdapterSchedule extends Adapter<RvAdapterSchedule.MyViewHolder> {

    private final SheduleOnClick view;
    private Context context;
    private List<Schedule> list = new ArrayList<>();

    public RvAdapterSchedule(SheduleOnClick view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void setData(List<Schedule> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_schedule, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Schedule schedule = list.get(position);
        holder.bind(view, schedule);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends ViewHolder implements OnClickListener {

        private TextView tvHari;
        private TextView tvMakul;
        private TextView tvJam;
        private TextView tvRuang;
        private TextView tvDosen;
        private Schedule schedule;
        private SheduleOnClick view;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            findView();
        }

        void bind(SheduleOnClick view, Schedule schedule) {
            this.view = view;
            this.schedule = schedule;
            initView();
        }

        private void findView() {
            tvHari = itemView.findViewById(R.id.tv_hari_item_schedule);
            tvMakul = itemView.findViewById(R.id.tv_makul_item_schedule);
            tvJam = itemView.findViewById(R.id.tv_jam_item_schedule);
            tvRuang = itemView.findViewById(R.id.tv_ruang_item_schedule);
            tvDosen = itemView.findViewById(R.id.tv_dosen_item_presence);
        }

        @SuppressLint("SetTextI18n")
        private void initView() {
            tvHari.setText(schedule.getHari());
            tvMakul.setText(schedule.getMakul());
            tvJam.setText("Jam : " + schedule.getJam());
            tvRuang.setText("Ruang : " + schedule.getRuang());
            tvDosen.setText("Dosen : " + schedule.getDosen());
        }

        @Override
        public void onClick(View v) {
            view.onItemClick(schedule.getMakul());
        }

    }


    public interface SheduleOnClick {

        void onItemClick(String makul);

    }

}
