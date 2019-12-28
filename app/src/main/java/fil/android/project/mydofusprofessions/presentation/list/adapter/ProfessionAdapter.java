package fil.android.project.mydofusprofessions.presentation.list.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.ArrayList;
import java.util.List;

import fil.android.project.mydofusprofessions.R;
import fil.android.project.mydofusprofessions.presentation.ProfessionDetailActivity;

public class ProfessionAdapter extends RecyclerView.Adapter<ProfessionAdapter.ProfessionViewHolder> {

    public static class ProfessionViewHolder extends RecyclerView.ViewHolder {

        private View v;

        private TextView nameTextView;

        private ImageView iconImageView;

        private CardView itemCardView;

        private ProfessionItemViewModel professionItemViewModel;

        private ProfessionActionInterface professionActionInterface;

        // ajouter le isLearned

        ProfessionViewHolder(View v, final ProfessionActionInterface professionActionInterface) {
            super(v);
            this.v = v;
            this.nameTextView = v.findViewById(R.id.profession_name_textview);
            this.iconImageView = v.findViewById(R.id.profession_icon_imageview);
            this.itemCardView = v.findViewById(R.id.item_card_view);
            this.professionActionInterface = professionActionInterface;
            setupListeners();
            // TODO
        }

        private void setupListeners() {
            this.itemCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), ProfessionDetailActivity.class);
                    intent.putExtra("profession_id", professionItemViewModel.getId());
                    v.getContext().startActivity(intent);
                }
            });
        }

        void bind(ProfessionItemViewModel professionItemViewModel) {
            this.professionItemViewModel = professionItemViewModel;
            nameTextView.setText(professionItemViewModel.getName());
            Glide.with(v)
                    .load(professionItemViewModel.getImgUrl())
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .circleCrop()
                    .into(iconImageView);
        }

    }

    private List<ProfessionItemViewModel> professionItemViewModelList;
    private ProfessionActionInterface professionActionInterface;

    public ProfessionAdapter(ProfessionActionInterface professionActionInterface) {
        this.professionActionInterface = professionActionInterface;
        professionItemViewModelList = new ArrayList<>();
    }

    @Override
    public ProfessionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.profession_item, parent, false);
        return new ProfessionViewHolder(v, professionActionInterface);
    }

    public void bindViewModels(List<ProfessionItemViewModel> professionItemViewModelList) {
        this.professionItemViewModelList.addAll(professionItemViewModelList);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ProfessionViewHolder holder, int position) {
        holder.bind(professionItemViewModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return professionItemViewModelList.size();
    }

}
