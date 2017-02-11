package com.tanvirsingh.essentiallinuxguide;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.content.ContentValues.TAG;
import static java.security.AccessController.getContext;



/**
 * Created by Tanvir on 12/24/2016.
 */
public class BasicsAdapter extends RecyclerView.Adapter<BasicsAdapter.MyViewHolder> {

    private List<Basic> basicsList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title;

        public MyViewHolder(View view){
            super(view);
            title = (TextView)view.findViewById(R.id.title);

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");

                    Context context = itemView.getContext();

                    Intent intent;

                    switch(getAdapterPosition()){
                        case 0:
                            intent =  new Intent(context, sub_list_activty.class);
                            break;
                        case 1:
                            intent =  new Intent(context, MainActivity.class);
                            break;
                        default:
                            intent =  new Intent(context, MainActivity.class);
                            break;
                    }
                    context.startActivity(intent);
                }
            });
        }
    }

    public BasicsAdapter(List<Basic> basicsList){
        this.basicsList = basicsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.basic_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Basic basic = basicsList.get(position);
        holder.title.setText(basic.getTitle());
    }

    @Override
    public int getItemCount() {
        return basicsList.size();
    }
}
