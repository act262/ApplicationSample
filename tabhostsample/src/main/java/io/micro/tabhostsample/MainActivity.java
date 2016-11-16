package io.micro.tabhostsample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        // 初始化
        tabHost.setup();
        // 指定tab和对应的内容视图
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("tab1").setIndicator("tab1").setContent(R.id.content1);

        // icon or text
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("tab2").setIndicator("", getResources().getDrawable(R.mipmap.ic_launcher)).setContent(R.id.content2);

        // 自定义ContentView + Tab View
        TextView tab3View = new TextView(this);
        tab3View.setText("tab3");
        tab3View.setBackgroundColor(Color.DKGRAY);
        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("tab3").setIndicator(tab3View).setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String tag) {
                TextView textView = new TextView(MainActivity.this);
                textView.setBackgroundColor(Color.BLUE);
                textView.setText("tab3 content");
                return textView;
            }
        });

        // 添加到TabHost中
        tabHost.addTab(tabSpec1);
        tabHost.addTab(tabSpec2);
//        tabHost.addTab(tabSpec3);
    }
}
