package com.dyjtest.recyclerviewdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dyjtest.recyclerviewdemo.R;

import java.util.List;

/**
 * Created by DingYuanJie on 2017/9/14.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private List<String> mDatas = null;

    public MyAdapter(List<String> mDatas) {
        this.mDatas = mDatas;
    }


    //自定义触摸监听器
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    //创建新的view
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    //绑定数据
    @Override
    public void onBindViewHolder(final MyAdapter.MyViewHolder holder, final int position) {
        holder.wordTv.setText(mDatas.get(position));
//        holder.wordTv.setHeight((int) (Math.random()*100 + 150));//自定义高度

        //如果设置了回调，则设置点击事件
        if(mOnItemClickListener != null){
            holder.wordTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, pos);
                }
            });

            holder.wordTv.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.itemView, pos);
                    return true;
                }
            });
        }
    }

    public void addData(int position){
        mDatas.add(position, "Insert one");
        //更新数据集
        notifyItemInserted(position);
    }

    public void removeData(int position){
        mDatas.remove(position);
        //更新数据集
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class MyViewHolder extends ViewHolder {
        private TextView wordTv;
        public MyViewHolder(View itemView) {
            super(itemView);
            wordTv = (TextView) itemView.findViewById(R.id.word_tv);
        }
    }
}
