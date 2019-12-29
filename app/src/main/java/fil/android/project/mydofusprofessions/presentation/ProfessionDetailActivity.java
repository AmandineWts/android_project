package fil.android.project.mydofusprofessions.presentation;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import fil.android.project.mydofusprofessions.R;
import fil.android.project.mydofusprofessions.data.api.model.Profession;
import fil.android.project.mydofusprofessions.data.di.FakeDependencyInjection;
import fil.android.project.mydofusprofessions.presentation.detail.ProfessionDetailContract;
import fil.android.project.mydofusprofessions.presentation.detail.ProfessionDetailPresenter;

public class ProfessionDetailActivity extends AppCompatActivity implements ProfessionDetailContract.View {

    private ProfessionDetailPresenter professionDetailPresenter;
    private TextView nameTextView;
    private TextView descriptionTextView;
    private ImageView logoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profession_detail_activity);
        setupPresenter();
        setupViews();
        String professionId =  getIntent().getStringExtra("profession_id");
        this.professionDetailPresenter.getDetailsById(professionId);
    }

    private void setupPresenter() {
        this.professionDetailPresenter = new ProfessionDetailPresenter(FakeDependencyInjection.getProfessionDetailDataRepository());
        this.professionDetailPresenter.attachView(this);
    }

    private void setupViews() {
        this.nameTextView = findViewById(R.id.profession_detail_name_textview);
        this.descriptionTextView = findViewById(R.id.profession_detail_description_textview);
        this.logoImageView = findViewById(R.id.profession_detail_logo_imageview);
    }

    @Override
    public void displayProfessionWithDetails(Profession profession) {
        nameTextView.setText(profession.getName());
        descriptionTextView.setText(profession.getDescription());
        Glide.with(findViewById(R.id.detail_card_view))
                .load(profession.getImgUrl())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(logoImageView);
    }
}
