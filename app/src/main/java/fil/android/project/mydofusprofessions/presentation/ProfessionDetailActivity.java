package fil.android.project.mydofusprofessions.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import fil.android.project.mydofusprofessions.R;
import fil.android.project.mydofusprofessions.data.api.model.Profession;
import fil.android.project.mydofusprofessions.data.di.FakeDependencyInjection;
import fil.android.project.mydofusprofessions.presentation.detail.ProfessionDetailContract;
import fil.android.project.mydofusprofessions.presentation.detail.ProfessionDetailPresenter;
import fil.android.project.mydofusprofessions.presentation.detail.adapter.HarvestAdapter;

public class ProfessionDetailActivity extends AppCompatActivity implements ProfessionDetailContract.View {

    private ProfessionDetailPresenter professionDetailPresenter;
    private Profession currentProfession;
    private TextView nameTextView;
    private TextView descriptionTextView;
    private ImageView logoImageView;
    private Button isLearnedButton;

    private TextView harvestRecyclerTitleTextView;
    private RecyclerView harvestRecyclerView;
    private HarvestAdapter harvestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profession_detail_activity);
        setupPresenter();
        setupViews();
        setupListeners();
        setupRecyclerView();
        String professionId =  getIntent().getStringExtra("profession_id");
        this.professionDetailPresenter.getDetailsById(professionId);
    }

    private void setupRecyclerView() {
        harvestRecyclerView = this.findViewById(R.id.detail_recycler_view);
        harvestAdapter = new HarvestAdapter();
        harvestRecyclerView.setAdapter(harvestAdapter);
        harvestRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        harvestRecyclerView.setHasFixedSize(true);
    }

    private void setupListeners() {
        this.isLearnedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentProfession.isLearned()) {
                    professionDetailPresenter.removeProfessionFromLearned(currentProfession.getAnkamaId());
                } else {
                    professionDetailPresenter.addProfessionAsLearned(currentProfession.getAnkamaId());
                }
            }
        });
    }

    private void setupPresenter() {
        this.professionDetailPresenter = new ProfessionDetailPresenter(FakeDependencyInjection.getProfessionDetailDataRepository());
        this.professionDetailPresenter.attachView(this);
    }

    private void setupViews() {
        this.nameTextView = findViewById(R.id.profession_detail_name_textview);
        this.descriptionTextView = findViewById(R.id.profession_detail_description_textview);
        this.logoImageView = findViewById(R.id.profession_detail_logo_imageview);
        this.isLearnedButton = findViewById(R.id.profession_detail_profession_learned_button);
        this.harvestRecyclerTitleTextView = findViewById(R.id.profession_detail_recycler_title_textview);
        harvestRecyclerTitleTextView.setText("Ressources récoltables");
    }

    @Override
    public void displayProfessionWithDetails(Profession profession) {
        currentProfession = profession;
        nameTextView.setText(profession.getName());
        descriptionTextView.setText(profession.getDescription());
        if(profession.isLearned()) {
            isLearnedButton.setText("Retirer des métiers appris");
        } else {
            isLearnedButton.setText("Ajouter aux métiers appris");
        }
        Glide.with(findViewById(R.id.detail_card_view))
                .load(profession.getImgUrl())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(logoImageView);
        if(!profession.getHarvests().isEmpty()) {
            harvestAdapter.bindViewModels(profession.getHarvests());
        } else {
            harvestRecyclerTitleTextView.setText("Métier de craft : aucune ressource n'est récoltable.");
        }
    }

    @Override
    public void onProfessionAddedAsLearned() {
        isLearnedButton.setText("Retirer des métiers appris");
        currentProfession.setLearned(true);
    }

    @Override
    public void onProfessionRemovedFromLearned() {
        isLearnedButton.setText("Ajouter aux métiers appris");
        currentProfession.setLearned(false);
    }
}
