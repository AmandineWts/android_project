package fil.android.project.mydofusprofessions.presentation;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import fil.android.project.mydofusprofessions.R;
import fil.android.project.mydofusprofessions.presentation.list.fragment.LearnedListFragment;
import fil.android.project.mydofusprofessions.presentation.list.fragment.ListFragment;

public class ProfessionsDisplayActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ListFragment listFragment;
    private LearnedListFragment learnedListFragment ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profession_display_activity);
        setupViewPagerAndTabs();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.icon_layout_handler) {
            changeIconDisplayed(item);
            listFragment.updateLayoutDisplay();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void changeIconDisplayed(MenuItem item) {
        Drawable currentIcon = item.getIcon();
        Drawable icon = getResources().getDrawable(R.drawable.grid_layout);
        if(icon.getConstantState().equals(currentIcon.getConstantState())) {
            item.setIcon(R.drawable.list_layout);
        } else {
            item.setIcon(R.drawable.grid_layout);
        }

    }

    private void setupViewPagerAndTabs() {

        viewPager = findViewById(R.id.tab_viewpager);

        listFragment = ListFragment.newInstance();
        learnedListFragment = LearnedListFragment.newInstance();

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return listFragment;
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
