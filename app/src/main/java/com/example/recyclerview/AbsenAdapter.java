package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AbsenAdapter extends RecyclerView.Adapter<AbsenAdapter.ViewHolder> {

    private List<AbsenItem> absenItems;
    private Context context;
    private OnItemClickListener listener;

    public AbsenAdapter(Context context, List<AbsenItem> absenItems, OnItemClickListener listener) {
        this.context = context;
        this.absenItems = absenItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_absen, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AbsenItem item = absenItems.get(position);
        holder.textNama.setText(item.getNama());
        holder.textGenre.setText(String.format("Genre: %s", item.getGenre()));
        holder.textDuration.setText(String.format("Durasi: %s", item.getDuration()));

        holder.imageView.setImageResource(item.getImageResId());

        holder.itemView.setOnClickListener(v -> {
            listener.onItemClick(item);
        });
    }

    @Override
    public int getItemCount() {
        return absenItems != null ? absenItems.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textNama;
        public TextView textGenre;
        public TextView textDuration;
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textNama = itemView.findViewById(R.id.textNama);
            textDuration = itemView.findViewById(R.id.textDuration);
            textGenre = itemView.findViewById(R.id.textGenre);
            imageView = itemView.findViewById(R.id.profile);  // Menghubungkan ImageView
        }
    }

    public interface OnItemClickListener {
        void onItemClick(AbsenItem item);
    }
}
