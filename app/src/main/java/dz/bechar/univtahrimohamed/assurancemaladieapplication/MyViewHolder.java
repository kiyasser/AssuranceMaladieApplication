package dz.bechar.univtahrimohamed.assurancemaladieapplication;

import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView, emailView, analyseDate;
    Button file1, file2, file3;
    WebView webView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageview);
        nameView = itemView.findViewById(R.id.nameview);
        emailView = itemView.findViewById(R.id.emailview);
        analyseDate = itemView.findViewById(R.id.analyse_date);
        file1 = itemView.findViewById(R.id.file1);
        file2 = itemView.findViewById(R.id.file2);
        file3 = itemView.findViewById(R.id.file3);
        webView = itemView.findViewById(R.id.webview);


    }
}
