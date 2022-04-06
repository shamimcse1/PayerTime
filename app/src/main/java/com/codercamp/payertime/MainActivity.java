package com.codercamp.payertime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.codercamp.payertime.helper.DataResource;
import com.codercamp.payertime.model.DataModel;
import com.codercamp.payertime.model.Results;
import com.codercamp.payertime.viewModel.DataViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    DataViewModel dataViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataViewModel = new ViewModelProvider(this).get(DataViewModel.class);
        dataViewModel.Data();

        dataViewModel.liveData.observe(this, new Observer<DataResource<DataModel>>() {
            @Override
            public void onChanged(DataResource<DataModel> mDataModel) {
                switch (mDataModel.getStatus()){
                    case SUCCESS:

                        break;
                    case ERROR:
                        break;
                    case LOADING:
                        break;
                }
            }
        });
    }
}