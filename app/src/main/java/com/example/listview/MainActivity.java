package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String data[] = {"aa","bb","cc","dd","1","2","3","4","5","6","7","8","9","0","cc"};
    private List<myBean> myBeanList = new ArrayList<>();//用来存放数据的数组

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        final ListView listview = findViewById(R.id.listview);
        List<String> la = new ArrayList<>();
        // List<Integer> list = new ArrayList<Integer>();

//        la.add("1111");
        //      la.add("2222");
        //     la.add("33333333");

        //     ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, la);
        //      listview.setAdapter(adapter);

        ListView listView = (ListView) findViewById(R.id.listview);//在视图中找到ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);//新建并配置ArrayAapeter
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "你点击了" + i +"按钮+ data[i]", Toast.LENGTH_SHORT).show();

            }

        });
*/

        ListView listView = (ListView) findViewById(R.id.listview);
        initdata();

        myAdapter adapter = new myAdapter(MainActivity.this,R.layout.listviewitem,myBeanList);

        listView.setAdapter(adapter);

    }



    private void initdata() {//初始化数据
        myBean bean1 = new myBean("aa", R.mipmap.ic_launcher);
        myBeanList.add(bean1);

        myBean bean2 = new myBean("ss", R.mipmap.ic_launcher);
        myBeanList.add(bean2);

        myBean bean3 = new myBean("jj", R.mipmap.ic_launcher);
        myBeanList.add(bean3);



    }

}

