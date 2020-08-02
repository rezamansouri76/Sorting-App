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

import java.util.ArrayList;
import java.util.Arrays;


public class SortFragment extends Fragment {

    EditText Number_et;
    Button Insert_btn, HeapSort_btn, QuickSort_btn, InsertiontSort_btn, MergSort_btn;
    TextView Result_tv;
    ArrayList<Integer> arrayList;
    Integer[] array;
    HeapSort heapSort;
    InsertionSort insertionSort;
    QuickSort quickSort;
    MergSort mergSort;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sort, container, false);
        init(view);
        Insert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(Integer.parseInt(Number_et.getText().toString()));
                Number_et.setText("");
            }
        });

        HeapSort_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result_tv.setText("");
                array = arrayList.toArray(new Integer[arrayList.size()]);
                for (Integer s : array) {
                    Result_tv.append(s.toString() + "\n");
                }
                Result_tv.append("\n Heap Sorted:\n \n");
                heapSort.sort(array);
                for (Integer s : array) {
                    Result_tv.append(s.toString() + "\n");
                }
                arrayList.clear();
                Arrays.fill(array, null);
            }
        });

        InsertiontSort_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result_tv.setText("");
                array = arrayList.toArray(new Integer[arrayList.size()]);
                for (Integer s : array) {
                    Result_tv.append(s.toString() + "\n");
                }
                Result_tv.append("\n Insertion Sorted:\n \n");
                insertionSort.sort(array);
                for (Integer s : array) {
                    Result_tv.append(s.toString() + "\n");
                }
                arrayList.clear();
                Arrays.fill(array, null);
            }
        });

        QuickSort_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result_tv.setText("");
                array = arrayList.toArray(new Integer[arrayList.size()]);
                for (Integer s : array) {
                    Result_tv.append(s.toString() + "\n");
                }
                Result_tv.append("\n Quick Sorted:\n \n");
                quickSort.sort(array, 0, array.length - 1);
                for (Integer s : array) {
                    Result_tv.append(s.toString() + "\n");
                }
                arrayList.clear();
                Arrays.fill(array, null);
            }
        });

        MergSort_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result_tv.setText("");
                array = arrayList.toArray(new Integer[arrayList.size()]);
                for (Integer s : array) {
                    Result_tv.append(s.toString() + "\n");
                }
                Result_tv.append("\n Merge Sorted:\n \n");
                mergSort.sort(array, 0, array.length - 1);
                for (Integer s : array) {
                    Result_tv.append(s.toString() + "\n");
                }
                arrayList.clear();
                Arrays.fill(array, null);
            }
        });

        return view;
    }

    public void init(View view) {
        Number_et = view.findViewById(R.id.NumberEditText);
        Insert_btn = view.findViewById(R.id.InsertButton);
        HeapSort_btn = view.findViewById(R.id.HeapSortButton);
        QuickSort_btn = view.findViewById(R.id.QuickSortButton);
        InsertiontSort_btn = view.findViewById(R.id.InsertionSortButton);
        MergSort_btn = view.findViewById(R.id.MergSortButton);
        Result_tv = view.findViewById(R.id.ResultTextView);
        arrayList = new ArrayList<>();
        heapSort = new HeapSort();
        insertionSort = new InsertionSort();
        quickSort = new QuickSort();
        mergSort = new MergSort();
    }

}
