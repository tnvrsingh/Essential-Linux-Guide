package com.tanvirsingh.essentiallinuxguide;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static android.content.ContentValues.TAG;


public class SubListAdapter extends RecyclerView.Adapter<SubListAdapter.MySubListViewHolder>{

    private List<SubList> subLists;

    public class MySubListViewHolder extends RecyclerView.ViewHolder{

        public TextView subListTitle;

        public MySubListViewHolder(View view){
            super(view);
            subListTitle = (TextView)view.findViewById(R.id.subListTitleText);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");

                    Context subListContext = itemView.getContext();

                    Intent SubListintent;

                    String  subListTopicSelected = Integer.toString(getAdapterPosition());

                    switch (subListTopicSelected) {
                        default:
                            SubListintent = new Intent(subListContext, article.class);
                            //SubListintent.putExtras("Topic",bas);
                            SubListintent.putExtra("SubTopic", subListTopicSelected);
                            break;
                    }
                    subListContext.startActivity(SubListintent);
                }
            });
        }
    }

    public SubListAdapter(List<SubList> subLists) {
        this.subLists = subLists;
    }

    @Override
    public MySubListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_list_row, parent, false);

        return new MySubListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MySubListViewHolder holder, int position) {
        SubList subListObj = subLists.get(position);
        holder.subListTitle.setText(subListObj.getSubListTitle());
    }

    @Override
    public int getItemCount() {
        return subLists.size();
    }
}
