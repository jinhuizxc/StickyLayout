package com.jinhui.stickylayout;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class CommentAdapter<T> extends RecyclerView.Adapter<CommentViewHolder> {

    private List<T> mTList;
    private int layoutId;

    public OnRecyclerViewListener onRecyclerViewListener;

    public CommentAdapter(ArrayList<T> strings, int layoutId) {
        mTList = strings;
        this.layoutId = layoutId;
    }

    public void setOnRecyclerViewListener(OnRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(layoutId, null);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, final int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (onRecyclerViewListener != null)
                        onRecyclerViewListener.onItemClick(position, mTList.get(position));
                    if (position < mTList.size())
                        onItemClick(position, mTList.get(position));

                } catch (Exception e) {

                }
            }
        });
        convert(holder, mTList.get(position));
    }

    public abstract void convert(CommentViewHolder holder, T t);

    public abstract void onItemClick(int position, Object o);

    @Override
    public int getItemCount() {
        try {
            return mTList.size();
        } catch (Exception e) {
            return 0;
        }
    }

    public void setData(ArrayList<T> mTList) {
        this.mTList = mTList;
        notifyDataSetChanged();
    }

    public interface OnRecyclerViewListener {
        void onItemClick(int position, Object o);

        boolean onItemLongClick(int position, Object o);
    }
}
