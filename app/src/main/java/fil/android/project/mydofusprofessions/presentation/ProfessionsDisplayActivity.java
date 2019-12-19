package fil.android.project.mydofusprofessions.presentation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import fil.android.project.mydofusprofessions.R;
import fil.android.project.mydofusprofessions.presentation.list.fragment.ListFragment;

public class ProfessionsDisplayActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profession_display_activity);
        setupViewPagerAndTabs();
    }

    private void setupViewPagerAndTabs() {

        viewPager = findViewById(R.id.tab_viewpager);

        final ListFragment searchFragment = ListFragment.newInstance();
        final ListFragment searchFragment2 = ListFragment.newInstance();
        //TODO ajouter 2e fragment

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return searchFragment;
                }
                //TODO changer
                return searchFragment2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                if (position == 0) {
                    return ListFragment.TAB_NAME;
                }
                //TODO changer
                return ListFragment.TAB_NAME;
            }

            @Override
            public int getCount() {
                return 2;
            }
        });

    }
}
