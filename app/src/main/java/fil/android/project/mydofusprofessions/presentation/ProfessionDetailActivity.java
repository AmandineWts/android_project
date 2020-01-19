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

/**
* activity to display details of a profession
*/
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

    /**
     * setup the recycler view and its adapter
     */
    private void setupRecyclerView() {
        harvestRecyclerView = this.findViewById(R.id.detail_recycler_view);
        harvestAdapter = new HarvestAdapter();
        harvestRecyclerView.setAdapter(harvestAdapter);
        harvestRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        harvestRecyclerView.setHasFixedSize(true);
    }

    /**
     * setup listener on button to add mark the profession as learned/unlearned
     */
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

    /**
     * setup the presenter
     */
    private void setupPresenter() {
        this.professionDetailPresenter = new ProfessionDetailPresenter(FakeDependencyInjection.getProfessionDetailDataRepository());
        this.professionDetailPresenter.attachView(this);
    }

    /**
     * setup views
     */
    private void setupViews() {
        this.nameTextView = findViewById(R.id.profession_detail_name_textview);
        this.descriptionTextView = findViewById(R.id.profession_detail_description_textview);
        this.logoImageView = findViewById(R.id.profession_detail_logo_imageview);
        this.isLearnedButton = findViewById(R.id.profession_detail_profession_learned_button);
        this.harvestRecyclerTitleTextView = findViewById(R.id.profession_detail_recycler_title_textview);
        harvestRecyclerTitleTextView.setText(R.string.harvest_title);
    }

    /**
     * map the profession datas to the views and displays it
     * @param profession the profession to display
     */
    @Override
    public void displayProfessionWithDetails(Profession profession) {
        currentProfession = profession;
        nameTextView.setText(profession.getName());
        descriptionTextView.setText(profession.getDescription());
        if(profession.isLearned()) {
            isLearnedButton.setText(R.string.remove_profession);
        } else {
            isLearnedButton.setText(R.string.add_profession);
        }
        Glide.with(findViewById(R.id.detail_card_view))
                .load(profession.getImgUrl())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(logoImageView);
        if(!profession.getHarvests().isEmpty()) {
            harvestAdapter.bindViewModels(profession.getHarvests());
        } else {
            harvestRecyclerTitleTextView.setText(R.string.no_harvest_message);
        }
    }

    /**
     * set the current profession as learned and change the button text
     */
    @Override
    public void onProfessionAddedAsLearned() {
        isLearnedButton.setText(R.string.remove_profession);
        currentProfession.setLearned(true);
    }

    /**
     * set the current professiona as unlearned and change the button text
     */
    @Override
    public void onProfessionRemovedFromLearned() {
        isLearnedButton.setText(R.string.add_profession);
        currentProfession.setLearned(false);
    }
}
