package com.codercamp.payertime.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.codercamp.payertime.R;
import com.codercamp.payertime.helper.DataResource;
import com.codercamp.payertime.model.DataModel;
import com.codercamp.payertime.model.Datetime;
import com.codercamp.payertime.model.Results;
import com.codercamp.payertime.model.Times;
import com.codercamp.payertime.viewModel.DataViewModel;
import com.google.android.material.navigation.NavigationView;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    public String Imsak, Sunrise, Fajr, Dhuhr, Asr, Sunset, Maghrib, Isha, Midnight;
    public int timestamp;
    public String gregorian, hijri;
    public float latitude, longitude;
    public String city, country, timezone, local_offset;
    public DataViewModel dataViewModel;
    private ProgressDialog progressDialog;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading.....");
        dataViewModel = new ViewModelProvider(this).get(DataViewModel.class);
        dataViewModel.Data();
        observeData();

        final DrawerLayout drawerLayout = findViewById(R.id.DrawerLayout);
        findViewById(R.id.menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        NavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setItemIconTintList(null);

        final NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHost);
        final NavController navController = navHostFragment.getNavController();

        //NavController navController = Navigation.findNavController(this,R.id.navHost);
        NavigationUI.setupWithNavController(navigationView,navController);

        final TextView toolbarTitle = findViewById(R.id.toolBarText);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
                toolbarTitle.setText(navDestination.getLabel());
            }
        });

    }

    private void observeData() {
        dataViewModel.liveData.observe(this, new Observer<DataResource<DataModel>>() {
            @Override
            public void onChanged(DataResource<DataModel> mDataModel) {
                switch (mDataModel.getStatus()) {
                    case SUCCESS:
                        Fajr = mDataModel.getActualData().getResults().getDatetime().get(0).getTimes().getFajr();
                        Dhuhr = mDataModel.getActualData().getResults().getDatetime().get(0).getTimes().getDhuhr();
                        Asr = mDataModel.getActualData().getResults().getDatetime().get(0).getTimes().getAsr();
                        Maghrib = mDataModel.getActualData().getResults().getDatetime().get(0).getTimes().getMaghrib();
                        Isha = mDataModel.getActualData().getResults().getDatetime().get(0).getTimes().getIsha();

                        timestamp = mDataModel.getActualData().getResults().getDatetime().get(0).getDate().getTimestamp();
                        gregorian = mDataModel.getActualData().getResults().getDatetime().get(0).getDate().getGregorian();
                        hijri = mDataModel.getActualData().getResults().getDatetime().get(0).getDate().getHijri();
                        Log.d("Data", String.valueOf(timestamp));

                        city = mDataModel.getActualData().getResults().getLocation().getCity();
                        country = mDataModel.getActualData().getResults().getLocation().getCountry();
                        timezone = mDataModel.getActualData().getResults().getLocation().getTimezone();

                        latitude = mDataModel.getActualData().getResults().getLocation().getLatitude();
                        longitude = mDataModel.getActualData().getResults().getLocation().getLongitude();

                        progressDialog.dismiss();
                        break;
                    case ERROR:
                        progressDialog.dismiss();
                        break;
                    case LOADING:
                        progressDialog.show();
                        break;
                }
            }
        });
    }
}