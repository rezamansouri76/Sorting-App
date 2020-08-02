package com.example.algorithm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HanoiFragment extends Fragment {

    EditText NoOfDisc_et;
    Button Generate_btn;
    TextView Result_tv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hanoi, container, false);

        init(view);

        Generate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result_tv.setText("");
                solve(Integer.parseInt(NoOfDisc_et.getText().toString()), "A", "B", "C");
            }
        });

        return view;
    }

    public void solve(int n, String start, String auxiliary, String end) {
        if (n == 1) {
            Result_tv.append(start + "  --->  " + end + "\n");
        } else {
            solve(n - 1, start, end, auxiliary);
            Result_tv.append(start + "  --->  " + end + "\n");
            solve(n - 1, auxiliary, start, end);
        }
    }

    private void init(View view) {
        NoOfDisc_et = view.findViewById(R.id.NoOfDiscsEditText);
        Generate_btn = view.findViewById(R.id.GenerateButton);
        Result_tv = view.findViewById(R.id.ResultTextView);
    }

}
