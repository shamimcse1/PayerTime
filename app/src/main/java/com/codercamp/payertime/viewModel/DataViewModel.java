package com.codercamp.payertime.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.codercamp.payertime.helper.DataResource;
import com.codercamp.payertime.model.DataModel;
import com.codercamp.payertime.repository.DataRepository;

public class DataViewModel extends ViewModel {

    DataRepository repository = new DataRepository();

    public LiveData<DataResource<DataModel>> liveData = repository.dataResourceLiveData;

    public  void  Data(){
        repository.GetData();
    }
}
