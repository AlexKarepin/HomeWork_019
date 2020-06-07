package com.karepin.homework_019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String KEY1 = "key1";
    private static final String KEY2 = "key2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.listView);
        List<Map<String, String>> values = prepareContent();

        BaseAdapter ListContentAdapter = createAdapter(values);
        list.setAdapter(ListContentAdapter);
    }

    @NonNull
    private List<Map<String, String>> prepareContent() {
        String[] arrayContent = getString(R.string.large_text).split("\n\n");
        List<Map<String, String>> result = new ArrayList<>();
        for (String str : arrayContent) {
            Map<String, String> map = new HashMap<>();

            map.put(KEY1, String.valueOf(str.length()));
            map.put(KEY2, str);
            result.add(map);
        }
        return result;
    }

    private BaseAdapter createAdapter(List<Map<String, String>> values) {
        String[] from = {KEY1, KEY2};
        int[] to = {R.id.titleTv, R.id.countTv};
        return new SimpleAdapter(this, values, R.layout.item_data,
                from, to);
    }

}