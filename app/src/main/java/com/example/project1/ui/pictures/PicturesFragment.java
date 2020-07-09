package com.example.project1.ui.pictures;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.project1.R;

public class PicturesFragment extends Fragment {

    private PicturesViewModel picturesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        picturesViewModel =
                ViewModelProviders.of(this).get(PicturesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pictures, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        picturesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}