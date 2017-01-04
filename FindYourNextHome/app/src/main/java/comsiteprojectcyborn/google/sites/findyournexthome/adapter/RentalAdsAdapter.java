package comsiteprojectcyborn.google.sites.findyournexthome.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import comsiteprojectcyborn.google.sites.findyournexthome.R;
import comsiteprojectcyborn.google.sites.findyournexthome.activities.RentDetailView;
import comsiteprojectcyborn.google.sites.findyournexthome.model.RentalAds;

/**
 * Created by msrabon on 12/14/16.
 */

public class RentalAdsAdapter extends RecyclerView.Adapter<RentalAdsAdapter.RentalAdsViewHolder> {

    private List<RentalAds> rentalAdsList;
    private Context context;

    public RentalAdsAdapter(List<RentalAds> rentalAdsList, Context context) {
        this.rentalAdsList = rentalAdsList;
        this.context = context;
    }

    @Override
    public RentalAdsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rentalads_carditem,parent,false);
        RentalAdsViewHolder adsViewHolder = new RentalAdsViewHolder(view);
        return adsViewHolder;
    }

    @Override
    public void onBindViewHolder(RentalAdsViewHolder holder, final int position) {
        holder.bannerImg.setImageResource(R.drawable.ft_1);
//        holder.normImg_one.setImageResource(R.drawable.profile);
//        holder.normImg_two.setImageResource(R.drawable.profile3);

        holder.rentsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RentDetailView.class);
//                String rentID = rentalAdsList.get(position)
                context.startActivity(intent);
//                ((Activity) context).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return rentalAdsList.size();
    }

    public static class RentalAdsViewHolder extends RecyclerView.ViewHolder {
        CardView rentsView;
        ImageView bannerImg;
        ImageView normImg_one;
        ImageView normImg_two;

        public RentalAdsViewHolder(View itemView) {
            super(itemView);
            rentsView = (CardView) itemView.findViewById(R.id.rentals_cardview);
            bannerImg = (ImageView) itemView.findViewById(R.id.imgview_big);
//            normImg_one = (ImageView) itemView.findViewById(R.id.imgview_small_one);
//            normImg_two = (ImageView) itemView.findViewById(R.id.imgview_small_two);
        }
    }
}
