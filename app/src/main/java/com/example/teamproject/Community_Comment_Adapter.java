package com.example.teamproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Community_Comment_Adapter extends RecyclerView.Adapter<Community_Comment_Adapter.Holder> {

    private List<Community_Comment_List> Dataset = new ArrayList<>();

    @NonNull
    @Override
    public Community_Comment_Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.community_comment_ct, parent, false);
        return new Holder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull Community_Comment_Adapter.Holder holder, int position) {
        ((Holder) holder).onBind(Dataset.get(position));
    }

    @Override
    public int getItemCount() {
        return Dataset.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView Commu_comment;
        public Holder(@NonNull View itemView) {
            super(itemView);
            Commu_comment = itemView.findViewById(R.id.commu_comment);
        }

        public void onBind(Community_Comment_List data) {
            Commu_comment.setText(data.getComment());
        }
    }
    void addItem(Community_Comment_List data) {
        // 외부에서 item을 추가시킬 함수
        Dataset.add(data);
    }
}
