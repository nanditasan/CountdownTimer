package com.example.countdowntimer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {
    TextView showCountSecondsView;
    TextView showCountMinView;
    TextView showCountHourView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);
        // Get the count text view
        showCountHourView = (TextView)fragmentFirstLayout.findViewById(R.id.editTextNumber_hour);
        showCountMinView = (TextView)fragmentFirstLayout.findViewById(R.id.editTextNumber_min);
        showCountSecondsView = (TextView)fragmentFirstLayout.findViewById(R.id.editTextNumber_seconds);
        return fragmentFirstLayout;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int secondsCount = Integer.parseInt(showCountSecondsView.getText().toString());
                int minCount = Integer.parseInt(showCountMinView.getText().toString());
                int hourCount = Integer.parseInt(showCountHourView.getText().toString());
                int currentCount = (hourCount*3600)+(minCount*60)+(secondsCount);
                FirstFragmentDirections.ActionFirstFragmentToSecondFragment action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount);
                NavHostFragment.findNavController(FirstFragment.this).navigate(action);

            }
        });
    }
}