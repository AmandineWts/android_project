package fil.android.project.mydofusprofessions.presentation.list.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fil.android.project.mydofusprofessions.R;
import fil.android.project.mydofusprofessions.data.di.FakeDependencyInjection;
import fil.android.project.mydofusprofessions.presentation.list.ProfessionListContract;
import fil.android.project.mydofusprofessions.presentation.list.ProfessionListPresenter;
import fil.android.project.mydofusprofessions.presentation.list.adapter.ProfessionActionInterface;
import fil.android.project.mydofusprofessions.presentation.list.adapter.ProfessionAdapter;
import fil.android.project.mydofusprofessions.presentation.list.adapter.ProfessionItemViewModel;
import fil.android.project.mydofusprofessions.presentation.list.mapper.ProfessionToItemViewModelMapper;

public class LearnedListFragment extends Fragment implements ProfessionActionInterface, ProfessionListContract.View {

    public static final String TAB_NAME = "Mes métiers appris";
    private View rootView;
    private RecyclerView recyclerView;
    private ProfessionAdapter professionAdapter;
    private ProfessionListPresenter professionListPresenter;

    private LearnedListFragment() {
    }

    public static LearnedListFragment newInstance() {
        return new LearnedListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        rootView = inflater.inflate(R.layout.fragment_learned_list, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*setupRecyclerView();
        professionListPresenter = new ProfessionListPresenter(FakeDependencyInjection.getProfessionListDataRepository(), new ProfessionToItemViewModelMapper());
        professionListPresenter.attachView(this);
        professionListPresenter.listProfessions();*/
    }

    private void setupRecyclerView() {
   /*     recyclerView = rootView.findViewById(R.id.recycler_view);
        professionAdapter = new ProfessionAdapter(this);
        recyclerView.setAdapter(professionAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));*/
    }


    @Override
    public void onLearnedToggle(String professionId, boolean isLearned) {
        // TODO
    }

    @Override
    public void displayProfessions(List<ProfessionItemViewModel> professionItemViewModelList) {
        //professionAdapter.bindViewModels(professionItemViewModelList);
    }

    @Override
    public void onProfessionAddedAsLearned() {

    }
}
