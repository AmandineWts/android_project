package fil.android.project.mydofusprofessions.presentation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import fil.android.project.mydofusprofessions.R;
import fil.android.project.mydofusprofessions.presentation.list.fragment.LearnedListFragment;
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
        final LearnedListFragment learnedListFragment = LearnedListFragment.newInstance();

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return searchFragment;
                }
                return learnedListFragment;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                if (position == 0) {
                    return ListFragment.TAB_NAME;
                }
                return LearnedListFragment.TAB_NAME;
            }

            @Override
            public int getCount() {
                return 2;
            }
        });

    }
}
