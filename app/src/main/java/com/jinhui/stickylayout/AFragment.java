package com.jinhui.stickylayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AFragment extends Fragment {

    private CommentAdapter<String> commentAdapter;

    public static Fragment newInstance(String id, String s) {
        AFragment aFragment = new AFragment();
        Bundle args = new Bundle();
        args.putString("id", id);
        args.putString("s", s);
        aFragment.setArguments(args);
        return aFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_a, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        commentAdapter = new CommentAdapter<String>(new ArrayList<String>(), R.layout.fragment_home_head) {
            @Override
            public void convert(CommentViewHolder holder, String s) {

            }

            @Override
            public void onItemClick(int position, Object o) {

            }
        };
        recyclerView.setAdapter(commentAdapter);

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            strings.add("123");
        }
        commentAdapter.setData(strings);



        return view;
    }
}
