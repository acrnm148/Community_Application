package com.example.teamproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    private List<productList> mDataset = new ArrayList<>();

    @NonNull
    @Override
    public MyAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mainpage_ct, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.Holder holder, int position) {
        ((Holder)holder).onBind(mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    void addItem(productList data) {
        // 외부에서 item을 추가시킬 함수입니다.
        mDataset.add(data);
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView textViewtitle;
        TextView textViewlocate;
        TextView textViewprice;
        TextView textViewdetail;

        public Holder(@NonNull View view) {
            super(view);
            textViewtitle = view.findViewById(R.id.itemtitle2);
            textViewlocate = view.findViewById(R.id.itemlocate);
            textViewprice = view.findViewById(R.id.itemprice);
            textViewdetail = view.findViewById(R.id.itemdetail);
        }

        public void onBind(productList data) {
            textViewtitle.setText(data.getTitle());
            textViewlocate.setText(data.getLocate());
            textViewprice.setText(data.getPrice());
            textViewdetail.setText(data.getDetail());
        }
    }

//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        // each data item is just a string in this case
//        public TextView textViewtitle;
//        public TextView textViewlocate;
//        public TextView textViewprice;
//        public TextView textViewdetail;
//        public View rootView;
//
//        public MyViewHolder(View v) {
//            super(v);
//            textViewtitle = v.findViewById(R.id.itemtitle2);
//            textViewlocate = v.findViewById(R.id.itemlocate);
//            textViewprice = v.findViewById(R.id.itemprice);
//            textViewdetail = v.findViewById(R.id.itemdetail);
//            rootView = v;
//        }
//    }

//    public MyAdapter(List<productList> myDataset) {
//        mDataset = myDataset;
//    }
//
//    @Override
//    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType)
//    {
//        Context context = parent.getContext() ;
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
//
//        View view = inflater.inflate(R.layout.mainpage_ct, parent, false) ;
//        MyHolder vh = new MyHolder(view) ;
//        return vh;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
//        productList item = mDataset.get(position);
//        holder.textViewtitle.setText(item.getTitle());
//        holder.textViewlocate.setText(item.getLocate());
//        holder.textViewprice.setText(item.getPrice());
//        holder.textViewdetail.setText(item.getDetail());
//    }
//
//    @Override
//    public int getItemCount() {
//        return mDataset != null ? 0 : mDataset.size();
//    }
//
//    public void addItem(String _a, String _b, String _c, String _d) {
//        productList pl = new productList();
//        pl.setTitle(_a);
//        pl.setDetail(_b);
//        pl.setLocate(_c);
//        pl.setPrice(_d);
//        mDataset.add(pl);
//        //notifyItemInserted(mDataset.size() - 1);
//    }
}
