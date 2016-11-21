package io.micro.tabhostsample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.micro.tabhostsample.R;

/**
 * Tab1Fragment
 */
public class Tab2Fragment extends Fragment {

    public static Tab2Fragment newInstance(String data) {
        Tab2Fragment fragment = new Tab2Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        textView.setBackgroundResource(R.color.colorPrimary);
        textView.setText("Tab2 Fragment");
        return textView;
    }
}
