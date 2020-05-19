package com.asrul.training.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.asrul.training.R;
import com.asrul.training.activity.HomeActivity;
import com.asrul.training.activity.ui.training.DetailTrainingActivity;
import com.asrul.training.helper.Config;
import com.asrul.training.model.ResponseErrorModel;
import com.asrul.training.model.TrainingModel;
import com.asrul.training.rest.ApiConfig;
import com.asrul.training.rest.ApiService;
import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder> {

    private Context context;
    private List<TrainingModel> listTraining;

    public TrainingAdapter(Context context, List<TrainingModel> trainingModels) {
        this.context = context;
        this.listTraining = trainingModels;
    }

    @NonNull
    @Override
    public TrainingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_training, parent, false);
        return new TrainingViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull TrainingViewHolder holder, int position) {
        if (listTraining.get(position).getStatusTraining().contains("pending")){
            holder.tvNamaTrainingItem.setBackgroundColor(R.color.colorAccent);
            holder.containerAkftifkan.setVisibility(View.VISIBLE);
        }
        holder.tvNamaTrainingItem.setText(listTraining.get(position).getNamaTraining());
        holder.tvTipeTrainingItem.setText(listTraining.get(position).getTypeTraining());
        holder.tvKuotaTrainingItem.setText(listTraining.get(position).getJumlahTraining());
        holder.tvHargaTrainingItem.setText(listTraining.get(position).getHargaTraining());
        holder.tvTanggalTrainingItem.setText(listTraining.get(position).getTanggalTraining());
        holder.tvStatusTrainingItem.setText(listTraining.get(position).getStatusTraining());
        Glide.with(context).load(listTraining.get(position).getGambarTraining()).error(R.drawable.ic_menu_gallery).into(holder.ivImageTrainingItem);

        holder.btnAktifkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiService apiService = ApiConfig.getApiService();
                apiService.postUpdateTraining(listTraining.get(position).getIdTraining())
                        .enqueue(new Callback<ResponseErrorModel>() {
                            @Override
                            public void onResponse(Call<ResponseErrorModel> call, Response<ResponseErrorModel> response) {
                                if (response.isSuccessful()){
                                    Toast.makeText(context, "Sukses", Toast.LENGTH_SHORT).show();
                                    ((HomeActivity)context).setup();
                                }
                            }
                            @Override
                            public void onFailure(Call<ResponseErrorModel> call, Throwable t) {
                                Toast.makeText(context, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        holder.cvItemTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailTrainingActivity.class);
                intent.putExtra(Config.BUNDLE_ID, listTraining.get(position).getIdTraining());
                intent.putExtra(Config.BUNDLE_NAMA, listTraining.get(position).getNamaTraining());
                intent.putExtra(Config.BUNDLE_TIPE, listTraining.get(position).getTypeTraining());
                intent.putExtra(Config.BUNDLE_KUOTA, listTraining.get(position).getJumlahTraining());
                intent.putExtra(Config.BUNDLE_HARGA, listTraining.get(position).getHargaTraining());
                intent.putExtra(Config.BUNDLE_TANGGAL, listTraining.get(position).getTanggalTraining());
                intent.putExtra(Config.BUNDLE_STATUS, listTraining.get(position).getStatusTraining());
                intent.putExtra(Config.BUNDLE_IMAGE, listTraining.get(position).getGambarTraining());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTraining.size();
    }

    public class TrainingViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNamaTrainingItem;
        private TextView tvTipeTrainingItem;
        private TextView tvKuotaTrainingItem;
        private TextView tvHargaTrainingItem;
        private TextView tvTanggalTrainingItem;
        private TextView tvStatusTrainingItem;
        private ImageView ivImageTrainingItem;
        private LinearLayout containerAkftifkan;
        private Button btnAktifkan;
        private CardView cvItemTraining;

        public TrainingViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaTrainingItem = itemView.findViewById(R.id.tv_nama_training_item);
            tvTipeTrainingItem = itemView.findViewById(R.id.tv_tipe_training_item);
            tvKuotaTrainingItem = itemView.findViewById(R.id.tv_kuota_training_item);
            tvHargaTrainingItem = itemView.findViewById(R.id.tv_harga_training_item);
            tvTanggalTrainingItem = itemView.findViewById(R.id.tv_tanggal_training_item);
            tvStatusTrainingItem = itemView.findViewById(R.id.tv_status_training_item);
            ivImageTrainingItem = itemView.findViewById(R.id.iv_image_training_item);

            containerAkftifkan = itemView.findViewById(R.id.container_aktifkan);
            btnAktifkan = itemView.findViewById(R.id.btn_aktifkan_training_item);
            cvItemTraining = itemView.findViewById(R.id.cv_training_item);
        }
    }
}