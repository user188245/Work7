package com.example.user.work7;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Created by user on 2017-04-27.
 */

public class MyGridSet {

    public int img;
    public String name;
    public long price;
    private boolean isInCart = false;

    public MyGridSet(int img, String name, long price) {
        this.img = img;
        this.name = name;
        this.price = price;
    }

    public void putInCart(Context c){
        if(!isInCart){
            Toast.makeText(c,name + "을 담았습니다.",Toast.LENGTH_SHORT).show();
            isInCart = true;
        }else{
            Toast.makeText(c,name + "을 뺐습니다.",Toast.LENGTH_SHORT).show();
            isInCart = false;
        }
    }

    public boolean isInCart() {
        return isInCart;
    }
}
