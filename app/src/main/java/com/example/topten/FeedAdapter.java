package com.example.topten;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FeedAdapter extends ArrayAdapter {

    private static final String TAG = "FeedAdapter";
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<FeedEntry> applications;


    public FeedAdapter(@NonNull Context context, int resource, List<FeedEntry> applications) {
        super(context, resource);
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.applications = applications;
    }




    @Override
    public int getCount() {

        return applications.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView == null){

            convertView = layoutInflater.inflate(layoutResource , parent , false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        else{

            viewHolder = (ViewHolder) convertView.getTag();
        }


//        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
//        TextView tvArtist = (TextView) convertView.findViewById(R.id.tvArtist);
//        TextView tvSummary = (TextView) convertView.findViewById(R.id.tvSummary);

        FeedEntry currentApp = applications.get(position);

        viewHolder.tvName.setText(applications.get(position).getName());
        viewHolder.tvArtist.setText(applications.get(position).getArtist());
        viewHolder.tvSummary.setText(applications.get(position).getSummary());

        return convertView;
    }



    static class ViewHolder{

       final TextView tvName;
       final TextView tvArtist;
       final TextView tvSummary;

        ViewHolder(View V){
            this.tvName = (TextView) V.findViewById(R.id.tvName);
            this.tvArtist = (TextView) V.findViewById(R.id.tvArtist);
            this.tvSummary = (TextView) V.findViewById(R.id.tvSummary);

        }


    }

}
