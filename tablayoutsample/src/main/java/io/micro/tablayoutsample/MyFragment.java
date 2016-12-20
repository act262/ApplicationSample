package io.micro.tablayoutsample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Pager Fragments
 *
 * @author act262@gmail.com
 */
public class MyFragment extends Fragment {

    public static MyFragment newInstance(int index) {
        Bundle args = new Bundle();
        args.putInt("fragment", index);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        Bundle arguments = getArguments();
        if (arguments != null) {
            textView.setText("Fragment-" + arguments.getInt("fragment"));
        }
        textView.setTextSize(40);
        textView.setTextColor(Color.DKGRAY);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return textView;
    }
}
