package fil.android.project.mydofusprofessions.presentation.list.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProfessionAdapter extends RecyclerView.Adapter<ProfessionAdapter.ProfessionViewHolder> {

    public static class ProfessionViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;

        private ImageView iconImageView;

        // ajouter le isLearned

        ProfessionViewHolder(View v, final ProfessionActionInterface professionActionInterface) {
            super(v);
            // TODO
        }

        void bind(ProfessionItemViewModel professionItemViewModel) {

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
        // TODO
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProfessionViewHolder holder, int position) {
        // TODO
    }

    @Override
    public int getItemCount() {
        // TODO
        return 0;
    }

}
