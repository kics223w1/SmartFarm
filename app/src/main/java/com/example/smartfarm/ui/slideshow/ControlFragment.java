package com.example.smartfarm.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.smartfarm.R;
import com.example.smartfarm.databinding.FragmentSlideshowBinding;

public class ControlFragment extends Fragment {

    private FragmentSlideshowBinding binding;
    private Switch switchTurnOn;
    private Switch switchTurnOff;
    private Switch switchAuto;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Initialize switches
        switchTurnOn = root.findViewById(R.id.switch_turn_on);
        switchTurnOff = root.findViewById(R.id.switch_turn_off);
        switchAuto = root.findViewById(R.id.switch_auto);

        // Enable "Turn On" by default
        switchTurnOn.setChecked(true);

        // Set listeners for switches
        setupSwitchListeners();

        return root;
    }

    private void setupSwitchListeners() {
        // Turn On Switch Listener
        switchTurnOn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Turn off "Turn Off" switch if "Turn On" is selected
                switchTurnOff.setChecked(false);
            }
        });

        // Turn Off Switch Listener
        switchTurnOff.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Turn off "Turn On" switch if "Turn Off" is selected
                switchTurnOn.setChecked(false);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
