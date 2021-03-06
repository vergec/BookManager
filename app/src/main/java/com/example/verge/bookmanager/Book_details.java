package com.example.verge.bookmanager;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.verge.DAO.BookDAO;
import com.example.verge.model.Book;

public class Book_details extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    Button readOnline;
    Toolbar toolbar;
    Button addToShelf;

    @SuppressLint({"SetTextI18n", "SetJavaScriptEnabled"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        Paint mp = new Paint();
        mp.setFakeBoldText(true); //true为粗体，false为非粗体
        mp.setTextSkewX(-0.5f); //float类型参数，负数表示右斜，整数左斜
        mp.setUnderlineText(true); //true为下划线，false为非下划线
        mp.setStrikeThruText(true); //true为删除线，false为非删除线
        textView1 = findViewById(R.id.textview1);
        textView2 = findViewById(R.id.textview2);
        textView3 = findViewById(R.id.textview3);
        textView4 = findViewById(R.id.textview4);
        textView5 = findViewById(R.id.textview5);
        addToShelf = findViewById(R.id.addToShelf);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        String details = intent.getStringExtra("details");
        final String title = intent.getStringExtra("title");
        final String writers = intent.getStringExtra("writers");
        final String book_url = intent.getStringExtra("book_url");
        String price = intent.getStringExtra("price");
        final String tags = intent.getStringExtra("tags");
        final String id = intent.getStringExtra("id");
        final String publishOrg = intent.getStringExtra("publishOrg");
        final String photo = intent.getStringExtra("photo");
        Log.i(title, "onCreate: ---------------------------------");
        textView1.setText("书名：" + title);
        textView2.setText("作者：" + writers);
        textView3.setText("标签：" + tags);
        textView4.setText("价格：" + price);
        textView5.setText("简介：" + details);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.readOnline1:
                        String url = book_url;
                        Intent intent = new Intent(Book_details.this, BookToWebActivity.class);
                        intent.putExtra("url", url);
                        startActivity(intent);
                        break;
                    case R.id.addToShelf:
                        BookDAO dao = new BookDAO(Book_details.this);
                        Book book = new Book();
                        book.setId(id);
                        book.setWriter(writers);
                        book.setUrl(photo);
                        book.setType("book");
                        book.setPublishOrg(publishOrg);
                        book.setTitle(title);
                        book.setUserId(((BaseApplication) getApplication()).getUserId());
                        book.setBookUrl(book_url);
                        book.setPingjia("");
                        book.setStatus("已添加");
                        book.setToid("");
                        book.setTag(tags.replace("'", ""));
                        dao.addBook(book);
                        Toast.makeText(Book_details.this, "添加完成", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }
}
