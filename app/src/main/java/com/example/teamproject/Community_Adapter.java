package com.example.teamproject;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Community_Adapter extends RecyclerView.Adapter<Community_Adapter.Holder>{
    private List<Community_List> Dataset = new ArrayList<>();


    @NonNull
    @Override
    public Community_Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.community_ct, parent, false);
        return new Holder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull Community_Adapter.Holder holder, int position) {
        ((Holder) holder).onBind(Dataset.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CommunityDetail.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Dataset.size();
    }


    public class Holder extends RecyclerView.ViewHolder{
        TextView Commu_detail;

        public Holder(@NonNull View itemView) {
            super(itemView);
            Commu_detail = itemView.findViewById(R.id.commu_detail);

        }

        public void onBind(Community_List data) {
            Commu_detail.setText(data.getComm());
        }
    }
    void addItem(Community_List data) {
        // 외부에서 item을 추가시킬 함수
        Dataset.add(data);
    }
}
