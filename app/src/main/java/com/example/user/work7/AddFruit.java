package com.example.user.work7;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by user on 2017-04-27.
 */

public class AddFruit extends LinearLayout implements View.OnClickListener {
    final static int[] fruitNum = {R.drawable.abocado,R.drawable.banana,R.drawable.cherry,R.drawable.cranberry,R.drawable.grape,R.drawable.kiwi,R.drawable.orange,R.drawable.watermelon};
    int imageno = 0;
    EditText et,et2;
    ImageView img;
    Button b_next,b_add;


    boolean isModifyMode = false;
    MyGridSet target;

    public OKNQwknlcqknlk oKNQwknlcqknlk;

    public AddFruit(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fruit_add,this);
        et = (EditText)findViewById(R.id.f_name);
        et2= (EditText)findViewById(R.id.f_price);
        img = (ImageView)findViewById(R.id.image1);
        b_next = (Button)findViewById(R.id.b_next);
        b_add = (Button)findViewById(R.id.b_add);
        b_add.setOnClickListener(this);
        b_next.setOnClickListener(this);

    }

    public void setOnOKNQwknlcqknlkListener(OKNQwknlcqknlk oKNQwknlcqknlk){
        this.oKNQwknlcqknlk = oKNQwknlcqknlk;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.b_add){
            if(isModifyMode){
                Toast.makeText(getContext(), "수정되었습니다.", Toast.LENGTH_SHORT).show();
                target.name = et.getText().toString();
                target.price = et2.getText().toString().isEmpty()?0:Long.parseLong(et2.getText().toString());
                target.img = fruitNum[imageno];
                b_add.setText("Add");
                MainActivity.gridAdapter.notifyDataSetChanged();
                isModifyMode = false;
            }else {
                oKNQwknlcqknlk.onAdd(et.getText().toString(), fruitNum[imageno],et2.getText().toString().isEmpty()?0L:Long.parseLong(et2.getText().toString()));
            }
        }else{
            img.setImageResource(AddFruit.fruitNum[(imageno==fruitNum.length-1)?imageno=0:++imageno]);
        }
    }

    public void enableModifier(MyGridSet target){
        if(!isModifyMode){
            this.target = target;
            b_add.setText("M");
            et.setText(target.name);
            et2.setText(String.valueOf(target.price));
            isModifyMode = true;
        }
    }



}
