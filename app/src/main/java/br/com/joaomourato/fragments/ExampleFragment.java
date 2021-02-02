package br.com.joaomourato.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExampleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExampleFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ExampleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExampleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExampleFragment newInstance(String param1, String param2) {
        ExampleFragment fragment = new ExampleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    //Ciclo de vida
    @Override
    public void onAttach(@NonNull Context context) {
        //chamdo para colocar o fragment na activity especificada
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //chamada para realizar algum tratamento passado no bundle, PRIMEIRO PASSO PARA CRIAÇÃO
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_example, container, false);
        //chamado criar de fato as views como o layout e sesus componentes internos
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        //chamado apos a criação da activity, para realizar alguma alteração na tela
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        //chamado antes de tornar visivel ao usuário
        super.onStart();
    }

    @Override
    public void onResume() {
        //chamado logo antes de iniciar a interação com o usuário
        super.onResume();
    }

    @Override
    public void onPause() {
        //chamado quando a atividade perde o foco
        super.onPause();
    }

    @Override
    public void onStop() {
        //chamado quando a atividade não esta mais visivel ao usuário
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        //chamado quando o fragment não esta mais acessivel
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        //chamado quando o fragment não é mais utilizada
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        //chamada para realizar o desligamento do fragment com a activity
        super.onDetach();
    }
}