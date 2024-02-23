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

public class archives_adapter extends RecyclerView.Adapter<archives_adapter.MyViewHolder>{
    private final ArchiveInterface archiveInterface;
    Context context;
    ArrayList<archives_data> slamprevdata;
    public archives_adapter(Context context, ArrayList<archives_data> slamprevdata, ArchiveInterface archiveInterface){
        this.context = context;
        this.slamprevdata = slamprevdata;
        this.archiveInterface = archiveInterface;
    }

    @NonNull
    @Override
    public archives_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this is the inflater
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_layout_archive, parent, false);

        return new archives_adapter.MyViewHolder(view, archiveInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull archives_adapter.MyViewHolder holder, int position) {

        holder.textView_1.setText(slamprevdata.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return slamprevdata.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageButton imageButton;
        TextView textView_1, textView_2;
        public MyViewHolder(@NonNull View itemView, ArchiveInterface archiveInterface) {
            super(itemView);

            textView_1= itemView.findViewById(R.id.nameplate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(archiveInterface!=null){
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION){
                            archiveInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
