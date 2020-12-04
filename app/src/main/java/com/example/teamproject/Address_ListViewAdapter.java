package com.example.teamproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Address_ListViewAdapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<Address_ListViewItem> listViewItemAddressList = new ArrayList<Address_ListViewItem>();

    // ListViewAdapter의 생성자
    public Address_ListViewAdapter(){}

    @Override
    public int getCount() {
        return listViewItemAddressList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.address_listview_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView tv_zipNo = (TextView) convertView.findViewById(R.id.tv_zipNo);
        TextView tv_rnAdres = (TextView) convertView.findViewById(R.id.tv_rnAdres);
        TextView tv_lnAdres = (TextView) convertView.findViewById(R.id.tv_lnAdres);

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        Address_ListViewItem addressListViewItem = listViewItemAddressList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        tv_zipNo.setText(addressListViewItem.getzipNo());
        tv_rnAdres.setText(addressListViewItem.getrnAdres());
        tv_lnAdres.setText(addressListViewItem.getlnAdres());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemAddressList.get(position);
    }

    // arraylist에 데이터 추가
    public void addItem(String zipNo, String rnAdres, String lnAdres) {
        Address_ListViewItem item = new Address_ListViewItem();

        item.setzipNo(zipNo);
        item.setrnAdres(rnAdres);
        item.setlnAdres(lnAdres);

        listViewItemAddressList.add(item);
    }
}
