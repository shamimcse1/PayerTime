package com.codercamp.payertime.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.codercamp.payertime.R;
import com.codercamp.payertime.helper.DataResource;
import com.codercamp.payertime.model.DataModel;
import com.codercamp.payertime.model.Datetime;
import com.codercamp.payertime.model.Results;
import com.codercamp.payertime.model.Times;
import com.codercamp.payertime.viewModel.DataViewModel;

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

                        timestamp = mDataModel.getActualData().getResults().getDatetime().get(1).getDate().getTimestamp();
                        gregorian = mDataModel.getActualData().getResults().getDatetime().get(1).getDate().getGregorian();
                        hijri = mDataModel.getActualData().getResults().getDatetime().get(1).getDate().getHijri();


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