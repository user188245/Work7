package com.example.user.work7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{
    ArrayList<MyGridSet> fruit;
    static GridAdapter gridAdapter;
    static AddFruit addFruit;
    GridView gridView;
    CheckBox checkPrice;
    Button buttonCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        setTitle("과일가게");
        buttonCart = (Button) findViewById(R.id.buttonCart);
        buttonCart.setOnClickListener(this);

        checkPrice = (CheckBox) findViewById(R.id.checkBoxPrice);
        checkPrice.setOnCheckedChangeListener(this);

        gridView = (GridView) findViewById(R.id.gridView);
        fruit = new ArrayList<>();
        gridAdapter = new GridAdapter(this,fruit);
        gridView.setAdapter(gridAdapter);

        addFruit = (AddFruit) findViewById(R.id.addFruit);
        addFruit.setOnOKNQwknlcqknlkListener(new OKNQwknlcqknlk() {
            @Override
            public void onAdd(String name, int imageno, long price) {
                gridAdapter.addItem(new MyGridSet(imageno,name,price));
                gridAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void onClick(View v) {
        String s = "";
        for(int i=0; i<gridAdapter.getCount();i++){
            MyGridSet g = ((MyGridSet)gridAdapter.getItem(i));
            if(g.isInCart()){
                s += "," + g.name;
            }
        }
        if(s.isEmpty())
            s = "_(N/A)";
        s += "이(가) 카트에 있습니다.";
        Toast.makeText(getApplicationContext(),s.substring(1),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked)
            gridAdapter.isPriceShowMode = true;
        else
            gridAdapter.isPriceShowMode = false;
        gridAdapter.notifyDataSetChanged();
    }
}