package fil.android.project.mydofusprofessions.presentation.list.mapper;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.List;
import java.util.stream.Collectors;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import fil.android.project.mydofusprofessions.presentation.list.adapter.ProfessionItemViewModel;

public class ProfessionToItemViewModelMapper {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<ProfessionItemViewModel> map(List<Profession> professionList) {
        return professionList.stream().map(profession -> map(profession)).collect(Collectors.toList());
    }

    private ProfessionItemViewModel map(Profession profession) {
        ProfessionItemViewModel professionItemViewModel = new ProfessionItemViewModel();
        professionItemViewModel.setName(profession.getName());
        professionItemViewModel.setImgUrl(profession.getImgUrl());
        professionItemViewModel.setId(profession.getAnkamaId());
        return professionItemViewModel;
    }

}
