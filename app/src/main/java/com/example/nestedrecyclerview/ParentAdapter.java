package com.example.nestedrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ViewHolder> {

    List<ParentModelClass> parentModelClassList;
    Context mContext;
    ChildAdapter childAdapter;

    public ParentAdapter(List<ParentModelClass> parentModelClassList, Context mContext) {
        this.parentModelClassList = parentModelClassList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.parent_rv_layout,null,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tv_parent_title.setText(parentModelClassList.get(position).title);

        childAdapter = new ChildAdapter(parentModelClassList.get(position).childModelClassList,mContext);
        holder.rv_child.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
        holder.rv_child.setAdapter(childAdapter);
        childAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return parentModelClassList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView tv_parent_title;
        RecyclerView rv_child;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_parent_title = itemView.findViewById(R.id.tv_parent_title);
            rv_child = itemView.findViewById(R.id.child_rv);

        }
    }
}
