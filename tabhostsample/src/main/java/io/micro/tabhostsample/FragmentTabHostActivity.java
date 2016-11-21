package io.micro.tabhostsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

import io.micro.tabhostsample.fragment.Tab1Fragment;
import io.micro.tabhostsample.fragment.Tab2Fragment;

/**
 * FragmentTabHost Sample
 */
public class FragmentTabHostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragmenttabhost);

        FragmentTabHost tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        // 指定content id
//        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        // content id = xml 中设置的inflatedId
        tabHost.setup(this, getSupportFragmentManager());

        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("TabA").setIndicator("TabA");
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("TabB").setIndicator("TabB");
        tabHost.addTab(tabSpec1, Tab1Fragment.class, null);
        tabHost.addTab(tabSpec2, Tab2Fragment.class, null);
    }
}
