package com.example.verge.bookmanager;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Search_resultActivity extends AppCompatActivity {
    String [] photo = null;
    String [] details = null;
    String [] writers = null;
    String [] book_url = null;
    String [] title = null;
    String [] price = null;
    String [] tags = null;
    String [] idd = null;
    String [] publishOrg = null;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_store);
        Bundle b=this.getIntent().getExtras();
        assert b != null;
        photo = b.getStringArray("photo");
        details=b.getStringArray("details");
        writers=b.getStringArray("writers");
        book_url=b.getStringArray("book_url");
        title=b.getStringArray("title");
        price=b.getStringArray("price");
        tags=b.getStringArray("tags");
        idd=b.getStringArray("id");
        publishOrg=b.getStringArray("publishOrg");
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.fresh);
        GridView gridView = findViewById(R.id.grid_view);
        gridView.setAdapter(new ImageListAdapter(Search_resultActivity.this,photo));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },1000);
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(String.valueOf(id), "onItemClick:----------------");
                Intent intent = new Intent(Search_resultActivity.this, Book_details.class);
                intent.putExtra("details",details[(int) id]);
                intent.putExtra("photo",photo[(int) id]);
                intent.putExtra("title",title[(int) id]);
                intent.putExtra("writers",writers[(int) id]);
                intent.putExtra("book_url",book_url[(int) id]);
                intent.putExtra("price",price[(int) id]);
                intent.putExtra("tags",tags[(int) id]);
                intent.putExtra("publishOrg",publishOrg[(int) id]);
                intent.putExtra("id",idd[(int) id]);
                startActivity(intent);//启动Activity
            }
        });
    }
}
