package com.wjq.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int RCVSTATE_VERTICAL=0;
    private static final int RCVSTATE_HORIZONTAL=1;
    private static final int RCVSTATE_STAGGER=2 ;
    private static final int RCVSTATE_GRID=3 ;

    private int mCurrentState=2;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Person> mPersons=new ArrayList<Person>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPersons();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_test);
        if (mCurrentState == RCVSTATE_VERTICAL) {
            //执行垂直布局逻辑
            mLayoutManager = new LinearLayoutManager(this);
        } else if (mCurrentState == RCVSTATE_HORIZONTAL) {
            //执行水平布局逻辑
            mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        } else if (mCurrentState == RCVSTATE_STAGGER) {
            //执行瀑布流布局逻辑
            mLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        } else if (mCurrentState == RCVSTATE_GRID) {
            mLayoutManager = new GridLayoutManager(this, 2);
        }
        Adapters.MyRecyclerViewAdapter myRecyclerViewAdapter = new Adapters().new MyRecyclerViewAdapter(mPersons, MainActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(myRecyclerViewAdapter);
    }

    private void initPersons() {
        for (int i = 0; i <20 ; i++) {
            Person person = new Person();
            person.setName("周杰伦");
            person.setPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTIo2ZKoDHeDcjPaW2zNXhdcvkSDA6HOK_WCW7C1zrkxMmrP8BlxQ");
            mPersons.add(person);
            Person person1 = new Person();
            person1.setName("张学友");
            person1.setPhoto("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQmw7ZntC9fg-vHv7aiaeXvN5XHKsRUdOZJ1S3kyFcRC1lfsTVG");
            mPersons.add(person1);
        }

    }
}
