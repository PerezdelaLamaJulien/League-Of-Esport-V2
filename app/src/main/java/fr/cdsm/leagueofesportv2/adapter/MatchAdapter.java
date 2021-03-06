package fr.cdsm.leagueofesportv2.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.MaterialDialog;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import fr.cdsm.leagueofesportv2.interfaces.MatchAdapterListener;
import fr.cdsm.leagueofesportv2.model.Best_Of;
import fr.cdsm.leagueofesportv2.viewholder.MatchViewHolder;
import fr.cdsm.leagueofesportv2.R;

public class MatchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public MaterialDialog material;
    ArrayList<Best_Of> arrayListMatch = new ArrayList<Best_Of>();
    MatchAdapterListener listener;
    int position;

    public MatchAdapter(MaterialDialog material, ArrayList<Best_Of> arrayListMatch, MatchAdapterListener listener) {
        this.material = material;
        this.arrayListMatch = arrayListMatch;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match, parent, false);
        return new MatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((MatchViewHolder) holder).textescoreTeam1.setText(arrayListMatch.get(position).score_final_team1);
        ((MatchViewHolder) holder).textescoreTeam2.setText(arrayListMatch.get(position).score_final_team2);

        Picasso.with(((MatchViewHolder) holder).imageTeam1.getContext()).load(arrayListMatch.get(position).image_team1).fit().centerInside().into(((MatchViewHolder) holder).imageTeam1);
        Picasso.with(((MatchViewHolder) holder).imageTeam2.getContext()).load(arrayListMatch.get(position).image_team2).fit().centerInside().into(((MatchViewHolder) holder).imageTeam2);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onMatchClick(position);
            }
        });
        material.cancel();
    }

    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return arrayListMatch.size();
    }
}