package com.practice.gadsaaleaderboard.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.practice.gadsaaleaderboard.BaseRecyclerAdapter;
import com.practice.gadsaaleaderboard.Leader;
import com.practice.gadsaaleaderboard.OnItemClickListener;
import com.practice.gadsaaleaderboard.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import timber.log.Timber;

public class LeaderRecyclerAdapter extends BaseRecyclerAdapter<Leader, LeaderRecyclerAdapter.ViewHolder> {
    private static final String TAG = LeaderRecyclerAdapter.class.getSimpleName();
    private final Context mContext;

    public LeaderRecyclerAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.mContext = context;
    }

    private static DiffUtil.ItemCallback<Leader> DIFF_CALLBACK = new DiffUtil.ItemCallback<Leader>() {
        @Override
        public boolean areItemsTheSame(@NonNull Leader oldItem, @NonNull Leader newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Leader oldItem, @NonNull Leader newItem) {
            return oldItem.name().equalsIgnoreCase(newItem.name()) &&
                    oldItem.getId() == newItem.getId() &&
                    oldItem.badgeUrl().equalsIgnoreCase(newItem.badgeUrl()) &&
                    oldItem.country().equalsIgnoreCase(newItem.country());
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.list_leader_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Leader leader = getItemAt(position);

        holder.mTextLeader.setText(leader.name());
        holder.mTextTitle.setText(getTitle(leader));

        // TODO: StrictMode policy violation, Add request user disk permissions
        if (!leader.badgeUrl().isEmpty())
            Picasso.get().load(leader.badgeUrl()).into(holder.mBadgeUrl);
    }

    private String getTitle(Leader leader) {
        return leader.score() == null
                ? String.format("%s learning hours, %s", leader.hours(), leader.country())
                : String.format("%s skill IQ score, %s", leader.score(), leader.country());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTextLeader;
        public final TextView mTextTitle;
        public final ImageView mBadgeUrl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextLeader = itemView.findViewById(R.id.text_leader);
            mTextTitle = itemView.findViewById(R.id.text_title);
            mBadgeUrl = itemView.findViewById(R.id.leader_certificate);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (getListener()!=null && position!=RecyclerView.NO_POSITION) {
                    getListener().onItemClick(getItem(position));
                }
            });
        }
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener<Leader> listener) {
        super.setOnItemClickListener(listener);
    }
}
