package fil.android.project.mydofusprofessions.presentation.list.mapper;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.List;
import java.util.stream.Collectors;

import fil.android.project.mydofusprofessions.data.api.model.Profession;
import fil.android.project.mydofusprofessions.presentation.list.adapter.ProfessionItemViewModel;

/**
 * class to map a list of profession to a list profession item view model
 */
public class ProfessionToItemViewModelMapper {

    /**
     * map a list of profession to a list of profession item view model
     * @param professionList the profession list to map
     * @return the list of profession item view model mapped
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<ProfessionItemViewModel> map(List<Profession> professionList) {
        return professionList.stream().map(profession -> map(profession)).collect(Collectors.toList());
    }

    /**
     * map a profession to a profession item view model
     * @param profession the profession to map
     * @return the profession item view model mapped
     */
    private ProfessionItemViewModel map(Profession profession) {
        ProfessionItemViewModel professionItemViewModel = new ProfessionItemViewModel();
        professionItemViewModel.setName(profession.getName());
        professionItemViewModel.setImgUrl(profession.getImgUrl());
        professionItemViewModel.setId(profession.getAnkamaId());
        return professionItemViewModel;
    }

}
