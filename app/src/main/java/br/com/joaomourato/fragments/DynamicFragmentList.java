package br.com.joaomourato.fragments;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicFragmentList extends Fragment {

    public static DynamicFragmentList newInstance() {
        Bundle args = new Bundle();
        DynamicFragmentList fragment = new DynamicFragmentList();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycle, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.main_recycleview);

        List<DataModel> dataModelList = cars();

        MainAdapter mainAdapter = new MainAdapter(dataModelList);

        mainAdapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void OnClickListener(int position) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.dynamic_fragment_container, DynamicFragmentInfo.newInstance(dataModelList.get(position)));
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
            }

            @Override
            public void OnLongClickListener(int position) {
                Toast.makeText(view.getContext(), "onLongClick", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(mainAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }

    public List<DataModel> cars(){
        return Arrays.asList(
                DataModel.DataModelBuilder.builder()
                .setBrand("Honda")
                .setModel("Civic")
                .setDetails("Dimensões: 4.522-4.641 mm C x 1.799 mm L x 1.421-1.433 mm A\n" +
                        "Preço sugerido: A partir de R$ 103.200\n" +
                        "Marca: Honda\n" +
                        "Volume de carga: 334 - 525 l\n" +
                        "Motor: 1,5 l 4 cilindros em linha, 2,0 l 4 cilindros em linha")
                .setImg(R.drawable.civic)
                .build(),

                DataModel.DataModelBuilder.builder()
                .setBrand("Toyota")
                .setModel("Corolla")
                .setDetails("Dimensões: 4.630 mm C x 1.780 mm L x 1.455 mm A\n" +
                        "Preço sugerido: A partir de R$ 110.190\n" +
                        "Marca: Toyota Motor\n" +
                        "Volume de carga: 470 l\n" +
                        "Transmissão: CVT")
                .setImg(R.drawable.corolla)
                .build(),

                DataModel.DataModelBuilder.builder()
                .setBrand("Hyundai")
                .setModel("HB20")
                .setDetails("Preço sugerido: A partir de R$ 49.590\n" +
                        "Marca: Hyundai Motor Company\n" +
                        "Dimensões: 3.940-4.260 mm C x 1.720-1.740 mm L x 1.470-1.540 mm A\n" +
                        "Tanque de combustível: 50 l\n" +
                        "Peso: 989 - 1.120 kg\n")
                .setImg(R.drawable.hb20)
                .build(),

                DataModel.DataModelBuilder.builder()
                .setBrand("Volkswagen")
                .setModel("Golf")
                .setDetails("Preço sugerido: A partir de R$ 199.990\n" +
                        "Potência: 204 HP\n" +
                        "Motor: 1,4 l 4 cilindros em linha\n" +
                        "Transmissão: Automático de 6 marchas\n" +
                        "Velocidade máxima: 222 km/h\n" +
                        "Aceleração de 0 a 100 km/h: 7,6 segundos")
                .setImg(R.drawable.golf)
                .build()
        );
    }
}
