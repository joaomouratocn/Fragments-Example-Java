package br.com.joaomourato.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DynamicFragmentInfo extends Fragment {

    private DataModel dataModel;
    ImageView img_car;
    TextView txt_model, txt_model_details;

    public static DynamicFragmentInfo newInstance(DataModel dataModel) {
        DynamicFragmentInfo dynamicFragmentInfo = new DynamicFragmentInfo();
        Bundle args = new Bundle();
        args.putParcelable("DATA_OBJECT", dataModel);
        DynamicFragmentInfo fragment = new DynamicFragmentInfo();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            dataModel = getArguments().getParcelable("DATA_OBJECT");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        img_car = view.findViewById(R.id.detail_img_car);
        txt_model = view.findViewById(R.id.detail_txt_model);
        txt_model_details = view.findViewById(R.id.detail_txt_model_details);

        img_car.setImageResource(dataModel.getImg());
        txt_model.setText(dataModel.getModel());
        txt_model_details.setText(dataModel.getDetails());

        return view;
    }
}
