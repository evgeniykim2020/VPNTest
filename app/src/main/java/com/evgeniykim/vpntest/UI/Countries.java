package com.evgeniykim.vpntest.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.evgeniykim.vpntest.R;
import com.evgeniykim.vpntest.adapter.Adapter;
import com.evgeniykim.vpntest.model.Model;

import java.util.ArrayList;

public class Countries extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList<Model> modelArrayList;
    private String china, korea, japan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        getImages();
        initView();
    }

    private void getImages() {

        Uri chinaPath = Uri.parse("android.resource://com.evgeniykim.vpntest/" + R.drawable.china);
        china = chinaPath.toString();

        Uri koreaPath = Uri.parse("android.resource://com.evgeniykim.vpntest/" + R.drawable.korean);
        korea = koreaPath.toString();

        Uri japanPath = Uri.parse("android.resource://com.evgeniykim.vpntest/" + R.drawable.japan);
        japan = japanPath.toString();

    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        modelArrayList = new ArrayList<>();
        adapter = new Adapter(this, modelArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        createListData();
    }

    private void createListData() {

        Model model = new Model(china, "China");
        modelArrayList.add(model);
        model = new Model(korea, "Korea");
        modelArrayList.add(model);
        model = new Model(japan, "Japan");
        modelArrayList.add(model);

    }


}