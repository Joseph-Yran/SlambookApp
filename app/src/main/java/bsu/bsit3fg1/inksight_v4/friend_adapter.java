package bsu.bsit3fg1.inksight_v4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class friend_adapter extends RecyclerView.Adapter<friend_adapter.MyViewHolder>{

    Context context;
    ArrayList<friend_data> slamprevdata;
    public friend_adapter(Context context, ArrayList<friend_data> slamprevdata){
        this.context = context;
        this.slamprevdata = slamprevdata;
    }

    @NonNull
    @Override
    public friend_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this is the inflater
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_layout_friends, parent, false);

        return new friend_adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull friend_adapter.MyViewHolder holder, int position) {

        holder.textView_1.setText(slamprevdata.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return slamprevdata.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageButton imageButton;
        TextView textView_1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_1= itemView.findViewById(R.id.nameplate);
        }
    }
}
