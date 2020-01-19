package fil.android.project.mydofusprofessions.presentation.detail.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.ArrayList;
import java.util.List;

import fil.android.project.mydofusprofessions.R;
import fil.android.project.mydofusprofessions.data.api.model.Harvest;

/**
 * Harvest adapter to handle recycler view display
 */
public class HarvestAdapter extends RecyclerView.Adapter<HarvestAdapter.HarvestViewHolder> {

    public static class HarvestViewHolder extends RecyclerView.ViewHolder {

        private View v;

        private TextView nameTextView;

        private TextView lvlTextView;

        private ImageView iconImageView;

        private TextView locationsTextView;

        private Harvest harvest;

        HarvestViewHolder(View v) {
            super(v);
            this.v = v;
            this.nameTextView = v.findViewById(R.id.harvest_name_textview);
            this.lvlTextView = v.findViewById(R.id.harvest_lvl_textview);
            this.iconImageView = v.findViewById(R.id.harvest_icon_imageview);
            this.locationsTextView = v.findViewById(R.id.harvest_locations_textview);
        }

        /**
         * bind the harvest data to the item views
         * @param harvest the harvest to display
         */
        void bind(Harvest harvest) {
            this.harvest = harvest;
            nameTextView.setText(harvest.getName());
            lvlTextView.setText("-  Level " + harvest.getLevel());
            setLocations(harvest.getLocation());
            Glide.with(v)
                    .load(harvest.getImgUrl())
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(iconImageView);
        }

        /**
         * iterate over the locations to produce a string to display and set it to the text view
         * @param locations a list of string of the harvest locations
         */
        private void setLocations(List<String> locations) {
            String res = "";
            for (String location : locations) {
                res += location + ", ";
            }
            res = res.substring(0, res.length()-2) + ".";
            locationsTextView.setText(res);
        }

    }


    private List<Harvest> harvestList;

    public HarvestAdapter() {
        harvestList = new ArrayList<>();
    }

    @Override
    public HarvestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.harvest_item, parent, false);
        return new HarvestViewHolder(v);
    }

    public void bindViewModels(List<Harvest> harvests) {
        this.harvestList.addAll(harvests);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull HarvestViewHolder holder, int position) {
        holder.bind(harvestList.get(position));
    }

    @Override
    public int getItemCount() {
        return harvestList.size();
    }

}