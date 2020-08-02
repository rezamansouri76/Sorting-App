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

import java.lang.reflect.Array;
import java.util.ArrayList;

public class KnapsackFragment extends Fragment {

    ArrayList<Integer> wtArraylist, valArraylist;
    Integer[] wtArray, valArray;
    int KnapsackWeight;
    EditText wt_et, val_et, wtK_et;
    Button Insert_btn, Genereit_btn;
    Zero_One_Knapsack zero_one_knapsack;
    TextView Result_tv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_knapsack, container, false);
        init(view);

        Insert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wtArraylist.add(Integer.parseInt(wt_et.getText().toString()));
                valArraylist.add(Integer.parseInt(val_et.getText().toString()));
                wt_et.setText("");
                val_et.setText("");
            }
        });

        Genereit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KnapsackWeight = Integer.parseInt(wtK_et.getText().toString());
                wtArray = wtArraylist.toArray(new Integer[wtArraylist.size()]);
                valArray = valArraylist.toArray(new Integer[valArraylist.size()]);
                Result_tv.setText(zero_one_knapsack.solve(wtArray, valArray, KnapsackWeight, wtArray.length-1));
            }
        });

        return view;
    }

    private void init(View view) {
        wtArraylist = new ArrayList<>();
        valArraylist = new ArrayList<>();
        zero_one_knapsack = new Zero_One_Knapsack();
        wt_et = view.findViewById(R.id.WeightkEditText);
        wtK_et = view.findViewById(R.id.KnapsackweightEditText);
        val_et = view.findViewById(R.id.ValuekEditText);
        Insert_btn = view.findViewById(R.id.Insert_knapsackButton);
        Genereit_btn = view.findViewById(R.id.Generate_knapsackButton);
        Result_tv = view.findViewById(R.id.ResultKnapsackTextView);

    }

}
