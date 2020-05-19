package com.asrul.training.activity.ui.training;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.asrul.training.model.TrainingModel;
import com.asrul.training.rest.ApiConfig;
import com.asrul.training.rest.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrainingViewModel extends ViewModel {

    private String TAG = "retrofit";
    private MutableLiveData<List<TrainingModel>> trainingModelMutableLiveData;
    public LiveData<List<TrainingModel>> getTraining(){
        if (trainingModelMutableLiveData == null){
            trainingModelMutableLiveData = new MutableLiveData<List<TrainingModel>>();

            laodDataTraining();
        }
        return trainingModelMutableLiveData;
    }
    private void laodDataTraining() {
        ApiService apiService = ApiConfig.getApiService();
        apiService.getTraining("aktif")
                .enqueue(new Callback<List<TrainingModel>>() {
                    @Override
                    public void onResponse(Call<List<TrainingModel>> call,
                                           Response<List<TrainingModel>> response) {
                        if (response.isSuccessful()) {
                            trainingModelMutableLiveData.setValue(response.body());
                            Log.d(TAG, "onResponse: " + response.body());
                        }
                    }
                    @Override
                    public void onFailure(Call<List<TrainingModel>> call, Throwable t){
                        Log.d(TAG, "onFailure: " + t.getLocalizedMessage() + "|" + t.getMessage());
                    }
                });
    }
}