package com.example.user.work7;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 2017-04-27.
 */

public class GridAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MyGridSet> myGridSetArrayList;
    static boolean isPriceShowMode = false;

    public GridAdapter(Context context, ArrayList<MyGridSet> myGridSetArrayList) {
        this.context = context;
        this.myGridSetArrayList = myGridSetArrayList;
    }

    @Override
    public int getCount() {
        return myGridSetArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return myGridSetArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addItem(MyGridSet g){
        myGridSetArrayList.add(g);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = new GridItem(context);
        ((GridItem)convertView).setData(position);
        ((GridItem)convertView).setMyFruitParcel(new MyFruitParcel() {
            @Override
            public void pack(MyGridSet i) {
                MainActivity.addFruit.enableModifier(i);
            }
        });
        return convertView;
    }
}
