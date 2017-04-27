package com.example.user.work7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by user on 2017-04-27.
 */

public class GridItem extends LinearLayout implements View.OnClickListener{
    Context context;
    ImageView imageView;
    TextView textView;
    int index;


    public MyFruitParcel myFruitParcel;

    public GridItem(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init(){
        View view = LayoutInflater.from(context).inflate(R.layout.gridview_item,this);
        imageView = (ImageView) view.findViewById(R.id.imageView2);
        textView = (TextView) view.findViewById(R.id.textView2);
        imageView.setOnClickListener(this);
        textView.setOnClickListener(this);

    }

    public void setData(int position){
        MyGridSet item = (MyGridSet)MainActivity.gridAdapter.getItem(position);
        imageView.setImageResource(item.img);
        if(MainActivity.gridAdapter.isPriceShowMode)
            textView.setText(item.name + "/" + item.price);
        else
            textView.setText(item.name);
        index = position;
    }

    public void setMyFruitParcel(MyFruitParcel myFruitParcel){
        this.myFruitParcel = myFruitParcel;
    }


    @Override
    public void onClick(View v) {
        MyGridSet item = (MyGridSet)MainActivity.gridAdapter.getItem(index);
        if(v.getId() == R.id.imageView2){
            item.putInCart(getContext());
        }else{
            myFruitParcel.pack(item);
        }

    }
}
