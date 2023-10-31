package com.example.myapplication.ui.SubirFoto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentInicioBinding;
import com.example.myapplication.databinding.FragmentSubirFotoBinding;
import com.example.myapplication.ui.Inicio.InicioViewModel;

public class SubirFotoFragment extends Fragment {

    private FragmentSubirFotoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        com.example.myapplication.ui.Inicio.InicioViewModel inicioViewModel =
                new ViewModelProvider(this).get(InicioViewModel.class);

        binding = FragmentSubirFotoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSubirFoto;
        inicioViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}