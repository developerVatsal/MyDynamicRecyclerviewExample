package com.desai.vatsal.mydynamicrecyclerviewexample;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.desai.vatsal.myrecylerviewlibrary.MyDynamicRecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyDynamicRecyclerView myRecyclerview;
    TestAdapter testAdapter;
    ArrayList<ProgramModel> modelArrayList;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerview = (MyDynamicRecyclerView) findViewById(R.id.myRecyclerview);

        modelArrayList = new ArrayList<>();
        testAdapter = new TestAdapter(this, modelArrayList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        linearLayoutManager = new LinearLayoutManager(this);

//        myRecyclerview.setScrollContainer(false);
//        myRecyclerview.setBackgroundColor("#854559");

        myRecyclerview.setLayoutManager(linearLayoutManager);
        myRecyclerview.setItemAnimator(new DefaultItemAnimator());
        myRecyclerview.setSimpleDivider(true);
        myRecyclerview.setAdapter(testAdapter);

        for (int i = 0; i < 20; i++) {
            modelArrayList.add(new ProgramModel("title " + i, "messages " + i, R.mipmap.ic_launcher));
        }

        testAdapter.setTestList(modelArrayList);

//        myRecyclerview.showInfoLayout();
        myRecyclerview.hideInfoLayout();

        myRecyclerview.setInfoIcon(R.drawable.ic_warning, Color.GRAY);
        myRecyclerview.setInfoTitle("No Internet Available", 22, Color.GRAY, null);
        myRecyclerview.setInfoMessage("Please Swipe From Top For Refresh", 18, Color.GRAY, null);


        myRecyclerview.setSwipeRefresh(true);
        myRecyclerview.setColorSchemeColors(Color.RED, Color.YELLOW, Color.BLACK, Color.GREEN, Color.BLUE);
        myRecyclerview.setOnRefreshListener(new MyDynamicRecyclerView.SwipeRefreshListener() {
            @Override
            public void OnRefresh() {

                Log.e("tag", "from OnRefresh()");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        myRecyclerview.stopSwipeRefresh();

                    }
                }, 3000);

            }
        });


        myRecyclerview.setFAB(true);
//        myRecyclerview.setFABMargins(20, 20, 20, 20);
        myRecyclerview.setFABImage(R.mipmap.ic_launcher);
//        myRecyclerview.setFABRippleColor(Color.RED);
//        myRecyclerview.setFABBackgroundTintMode(PorterDuff.Mode.DST_OVER);
        myRecyclerview.setFABImageColor("#845654");
        myRecyclerview.setFABBackgroundColor(Color.YELLOW);
        myRecyclerview.setFABOnClickListener(new MyDynamicRecyclerView.FABOnClickListener() {
            @Override
            public void OnClick() {

                Log.e("tag", "from FAB OnClick()");

            }
        });

        myRecyclerview.setLoadMore(true, linearLayoutManager);
        myRecyclerview.setLoadMoreListener(new MyDynamicRecyclerView.LoadMoreListener() {
            @Override
            public void OnLoadMore() {

                Toast.makeText(MainActivity.this, "Load More...", Toast.LENGTH_SHORT).show();

                Log.e("tag", "Load More...............................................");

            }
        });


    }


}
