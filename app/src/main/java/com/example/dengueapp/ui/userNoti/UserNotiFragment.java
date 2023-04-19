package com.example.dengueapp.ui.userNoti;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dengueapp.databinding.FragmentSlideshowBinding;
import com.example.dengueapp.databinding.FragmentUserNotiBinding;
import com.example.dengueapp.ui.slideshow.SlideshowViewModel;


public class UserNotiFragment extends Fragment {
    private FragmentUserNotiBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentUserNotiBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}




