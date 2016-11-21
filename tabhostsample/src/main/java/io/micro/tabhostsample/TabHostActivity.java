package io.micro.tabhostsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

/**
 * TabHost Sample
 */
public class TabHostActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost);

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        // 初始化
        tabHost.setup();
        // 自定义TabWidget分割线
        TabWidget tabWidget = tabHost.getTabWidget();
        // 设置不显示分割线
        tabWidget.setDividerDrawable(null);

        // 指定tab和对应的内容视图
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("tab1").setIndicator("tab1").setContent(R.id.content1);

        // icon or text
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("tab2").setIndicator("", getResources().getDrawable(R.mipmap.ic_launcher)).setContent(R.id.content2);

        // 自定义ContentView + Tab View，这个Tab不显示底部条状
        TextView tab3View = new TextView(this);
        tab3View.setText("tab3");
        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("tab3").setIndicator(tab3View).setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String tag) {
                TextView textView = new TextView(TabHostActivity.this);
                textView.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                textView.setText("tab3 content");
                return textView;
            }
        });

        // 添加到TabHost中
        tabHost.addTab(tabSpec1);
        tabHost.addTab(tabSpec2);
        tabHost.addTab(tabSpec3);
    }
}
