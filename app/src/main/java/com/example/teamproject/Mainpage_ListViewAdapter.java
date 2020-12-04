package com.example.teamproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Mainpage_ListViewAdapter extends RecyclerView.Adapter<Mainpage_ListViewAdapter.Holder> {
    private List<ProductList> Dataset = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.mainpage_ct, parent, false);
        return new Holder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull Mainpage_ListViewAdapter.Holder holder, int position) {
        ((Holder) holder).onBind(Dataset.get(position));
    }

    //커스텀리스너 인터페이스 정의
    public interface OnItemClickListener{
        void onItemClick(View v, int position);
    }
    //리스너 객체를 전달하는 메소드와 전달된 객체를 저장할 변수 추가
    public void setOnItemClicklistener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView textViewtitle;
        TextView textViewlocate;
        TextView textViewprice;
        TextView textViewdetail;

        public Holder(@NonNull View itemview) {
            super(itemview);
            textViewtitle = itemview.findViewById(R.id.itemtitle2);
            textViewlocate = itemview.findViewById(R.id.itemlocate);
            textViewprice = itemview.findViewById(R.id.itemprice);
            textViewdetail = itemview.findViewById(R.id.itemdetail);
            //리사이클러뷰 클릭이벤트
            itemview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        //아이템 클릭 이벤트 핸들러 메소드에서 리스너 객체 메소드 호출
                        if (listener != null) {
                            listener.onItemClick(v, position);
                        }
                        //데이터 접근하기!
                    }
                }
            }); //
        }
        
        public void onBind(ProductList data) {
            textViewtitle.setText(data.getTitle());
            textViewlocate.setText(data.getLocate());
            textViewprice.setText(data.getPrice());
            textViewdetail.setText(data.getDetail());
        }
    }

    @Override
    public int getItemCount() {
        return Dataset.size();
    }

    void addItem(ProductList data) {
        // 외부에서 item을 추가시킬 함수
        Dataset.add(data);
    }
}