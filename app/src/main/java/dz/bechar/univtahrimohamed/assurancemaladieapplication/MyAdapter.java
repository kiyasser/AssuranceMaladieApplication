package dz.bechar.univtahrimohamed.assurancemaladieapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Item> items;

    public MyAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameView.setText(items.get(position).getNom());
        holder.emailView.setText(items.get(position).getEmail());
        holder.imageView.setImageResource(items.get(position).getImage());
        holder.analyseDate.setText(items.get(position).getAnalyseDate());

        holder.file1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
                holder.webView.getSettings().setJavaScriptEnabled(true);
                holder.webView.loadUrl(items.get(position).file1);


            }
        });

        holder.file2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
                holder.webView.getSettings().setJavaScriptEnabled(true);
                holder.webView.loadUrl(items.get(position).file2);
            }
        });

        holder.file3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
                holder.webView.getSettings().setJavaScriptEnabled(true);
                holder.webView.loadUrl(items.get(position).file3);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void openUrl(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(intent);
    }
}
