package com.example.countdowntimer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment { ;
    TextView randomView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View fragmentSecondLayout = inflater.inflate(R.layout.fragment_second, container, false);
        // Get the count text view
        randomView = fragmentSecondLayout.findViewById(R.id.textView_timeDisplay);

        return fragmentSecondLayout;


    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Integer count = SecondFragmentArgs.fromBundle(getArguments()).getMyArg();
        count = (count + 1) * 1000;
        new CountDownTimer(count, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                long hoursUntilFinished = (millisUntilFinished / 3600) / 1000;
                long minUntilFinished = (millisUntilFinished % 3600000) / 60 / 1000;
                long secondsUntilFinished = (millisUntilFinished % 60000) / 1000;
                String displayUntilFinished = String.format("%02d : %02d : %02d ",hoursUntilFinished,minUntilFinished,secondsUntilFinished);
                randomView.setText(displayUntilFinished);
            }

            @Override
            public void onFinish() {
                Toast myToast = Toast.makeText(getActivity(), "Done!", Toast.LENGTH_SHORT);
                myToast.show();
            }
        }.start();
        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

}