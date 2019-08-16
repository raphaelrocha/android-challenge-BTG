package com.androidchallengebtg.activities.movies.adapters.movies;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidchallengebtg.R;
import com.androidchallengebtg.helpers.interfaces.ItemViewHolderClickListener;
import com.androidchallengebtg.helpers.interfaces.ItemViewHolderFavIconClickListner;

class MovieHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    TextView title;
    TextView releaseDate;
    ImageView poster;
    ImageView favIcon;

    private ItemViewHolderClickListener clickListener;
    private ItemViewHolderFavIconClickListner itemViewHolderFavIconClickListner;
    private int position;

    MovieHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.title);
        releaseDate = itemView.findViewById(R.id.releaseDate);
        poster = itemView.findViewById(R.id.poster);
        favIcon = itemView.findViewById(R.id.imageViewFav);

        favIcon.setOnClickListener(this);

        itemView.setOnClickListener(this);
    }

    void setPosition(int position) {
        this.position = position;
    }

    void setClickListener(ItemViewHolderClickListener clickListener) {
        this.clickListener = clickListener;
    }

    void setItemViewHolderFavIconClickListner(ItemViewHolderFavIconClickListner itemViewHolderFavIconClickListner) {
        this.itemViewHolderFavIconClickListner = itemViewHolderFavIconClickListner;
    }

    @Override
    public void onClick(View v) {
        Log.e("clicou ", "clicoou");
        if(v.getId() == R.id.imageViewFav){
            if(this.itemViewHolderFavIconClickListner != null){
                itemViewHolderFavIconClickListner.onClick(this.position);
            }
        }else{
            if(clickListener != null){
                clickListener.onClick(this.position);
            }
        }

    }

    @Override
    public boolean onLongClick(View v) {
        if(clickListener!=null){
            clickListener.onLongClick(this.position);
        }
        return false;
    }
}
