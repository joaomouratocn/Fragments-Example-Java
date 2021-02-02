package br.com.joaomourato.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<DataModel> dataModelList;
    private OnItemClickListener onItemClickListener;


    public MainAdapter(List<DataModel> dataModelList) {
        this.dataModelList = dataModelList;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_layout, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        DataModel dataModel = dataModelList.get(position);

        holder.bind(dataModel);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.OnClickListener(position);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemClickListener.OnLongClickListener(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder{
        ImageView img_car;
        TextView txt_brand, txt_model;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

            img_car = itemView.findViewById(R.id.recycle_img_car);
            txt_brand  = itemView.findViewById(R.id.recycle_txt_brand);
            txt_model = itemView.findViewById(R.id.recycle_txt_model);
        }

        public void bind(DataModel dataModel) {
            img_car.setImageResource(dataModel.getImg());
            txt_brand.setText(dataModel.getBrand());
            txt_model.setText(dataModel.getModel());
        }
    }

    interface OnItemClickListener{
        void OnClickListener(int position);
        void OnLongClickListener(int position);
    }
}
