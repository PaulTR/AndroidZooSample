package com.ptrprograms.zoo;

import android.arch.lifecycle.LifecycleActivity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;

import com.ptrprograms.zoo.calendar.CalendarFragment;
import com.ptrprograms.zoo.databinding.ActivityMainBinding;
import com.ptrprograms.zoo.exhibits.ExhibitsFragment;
import com.ptrprograms.zoo.map.MapFragment;
import com.ptrprograms.zoo.news.NewsFragment;


public class MainActivity extends LifecycleActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    //private NavigationViewModel navigationViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //navigationViewModel = new NavigationViewModel(binding);
        //binding.setNavigationViewModel(navigationViewModel);

        binding.navigation.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch( item.getItemId() ) {
            case R.id.action_news: {
                getSupportFragmentManager().beginTransaction().replace(binding.content.getId(), new NewsFragment()).commit();
                break;
            }
            case R.id.action_calendar: {
                getSupportFragmentManager().beginTransaction().replace(binding.content.getId(), new CalendarFragment()).commit();
                break;
            }
            case R.id.action_exhibits: {
                getSupportFragmentManager().beginTransaction().replace(binding.content.getId(), new ExhibitsFragment()).commit();
                break;
            }
            case R.id.action_map: {
                getSupportFragmentManager().beginTransaction().replace(binding.content.getId(), new MapFragment()).commit();
                break;
            }
        }
        return true;
    }
}
