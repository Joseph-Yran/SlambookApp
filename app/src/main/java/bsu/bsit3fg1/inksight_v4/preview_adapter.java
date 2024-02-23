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

public class preview_adapter extends RecyclerView.Adapter<preview_adapter.MyViewHolder>{
    private final SelectInterface selectInterface;

    Context context;
    ArrayList<preview_data> slamprevdata;
    public preview_adapter(Context context, ArrayList<preview_data> slamprevdata, SelectInterface selectInterface){
        this.context = context;
        this.slamprevdata = slamprevdata;
        this.selectInterface = selectInterface;
    }

    @NonNull
    @Override
    public preview_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this is the inflater
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_layout_previews, parent, false);

        return new preview_adapter.MyViewHolder(view, selectInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull preview_adapter.MyViewHolder holder, int position) {

        holder.textView_1.setText(slamprevdata.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return slamprevdata.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageButton imageButton;
        TextView textView_1, textView_2;
        public MyViewHolder(@NonNull View itemView, SelectInterface selectInterface) {
            super(itemView);

            textView_1= itemView.findViewById(R.id.nameplate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(selectInterface != null){
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION){
                            selectInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
