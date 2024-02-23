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

public class friend_adapter extends RecyclerView.Adapter<friend_adapter.MyViewHolder> {
    private final FriendInterface friendInterface;
    Context context;
    ArrayList<friend_data> slamprevdata;

    public friend_adapter(Context context, ArrayList<friend_data> slamprevdata, FriendInterface friendInterface) {
        this.context = context;
        this.slamprevdata = slamprevdata;
        this.friendInterface = friendInterface;
    }

    @NonNull
    @Override
    public friend_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this is the inflater
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_layout_friends, parent, false);

        return new friend_adapter.MyViewHolder(view, friendInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull friend_adapter.MyViewHolder holder, int position) {
        //shows the rows
        holder.textView_1.setText(slamprevdata.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return slamprevdata.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageButton edit, archive, delete;
        TextView textView_1;

        public MyViewHolder(@NonNull View itemView, FriendInterface friendInterface) {
            super(itemView);

            edit = itemView.findViewById(R.id.editbttn);
            archive = itemView.findViewById(R.id.archivebttn);
            delete = itemView.findViewById(R.id.deletebttn);
            textView_1 = itemView.findViewById(R.id.nameplate);

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (friendInterface != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            friendInterface.onEditClick(position);
                        }
                    }
                }
            });

            archive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (friendInterface != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            friendInterface.onArchiveClick(position);
                        }
                    }
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (friendInterface != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            friendInterface.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }
}
