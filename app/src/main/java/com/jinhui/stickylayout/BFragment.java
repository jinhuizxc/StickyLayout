package com.jinhui.stickylayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class BFragment extends Fragment {

    private String id;
    private String s;

    public static Fragment newInstance(String id, String s) {
        BFragment bFragment = new BFragment();
        Bundle args = new Bundle();
        args.putString("id", id);
        args.putString("s", s);
        bFragment.setArguments(args);
        return bFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_b, container, false);

        Button btn = (Button)view.findViewById( R.id.fragment1_btn);
        btn.setText(id + "," + s);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "点击了第一个fragment的BTN", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}
