package com.practice.gadsaaleaderboard.ui.common.adapters;

import com.practice.gadsaaleaderboard.ui.common.listeners.OnItemClickListener;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseRecyclerAdapter<M, VH extends RecyclerView.ViewHolder> extends ListAdapter<M, VH> {

    private OnItemClickListener<M> listener;

    public BaseRecyclerAdapter(@NonNull DiffUtil.ItemCallback<M> diffCallback) {
        super(diffCallback);
    }

    public void setOnItemClickListener(OnItemClickListener<M> listener) {
        this.listener = listener;
    }

    public OnItemClickListener<M> getListener() {
        return listener;
    }

    public M getItemAt(int position) {
        return getItem(position);
    }
}
