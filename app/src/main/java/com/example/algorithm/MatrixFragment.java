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
import android.widget.Toast;

public class MatrixFragment extends Fragment {

    int Order;
    int[][] FirstMatrix, SecondMatrix, ResultMatrix;
    TextView A_Index_matrix, B_Index_matrix, Result_Product_matrix;
    EditText A_matrix, B_matrix, Order_et;
    Button Insert_A_Matrix, Insert_B_Matrix, Product_matirx_btn, Order_btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_matrix, container, false);

        init(view);

        Order_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order = Integer.parseInt(Order_et.getText().toString());
                FirstMatrix = new int[Order][Order];
                SecondMatrix = new int[Order][Order];
                ResultMatrix = new int[Order][Order];
                Toast.makeText(getContext(), "Ok, You can insert matrix, now!", Toast.LENGTH_SHORT).show();
            }
        });

        Insert_A_Matrix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < Order; i++)
                    for (int j = 0; j < Order; j++)
                        FirstMatrix[i][j] = Integer.parseInt(A_matrix.getText().toString());
                A_matrix.setText("");
            }
        });

        Insert_B_Matrix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < Order; i++)
                    for (int j = 0; j < Order; j++)
                        SecondMatrix[i][j] = Integer.parseInt(B_matrix.getText().toString());
                B_matrix.setText("");
            }
        });

        Product_matirx_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Strassan s = new Strassan();
                ResultMatrix = s.multiply(FirstMatrix, SecondMatrix);
                Result_Product_matrix.append("Product of matrices A and  B : ");
                for (int i = 0; i < Order; i++) {
                    for (int j = 0; j < Order; j++)
                        Result_Product_matrix.append(ResultMatrix[i][j] + " ");
                    Result_Product_matrix.append(" ");
                }

            }
        });

        return view;
    }

    private void init(View view) {
        A_Index_matrix = view.findViewById(R.id.AIndexMatrix_TextView);
        B_Index_matrix = view.findViewById(R.id.BIndexMatrix_TextView);
        Result_Product_matrix = view.findViewById(R.id.Result_ProductMatrix_TextView);
        A_matrix = view.findViewById(R.id.AEditText);
        B_matrix = view.findViewById(R.id.BEditText);
        Insert_A_Matrix = view.findViewById(R.id.AInsert_button);
        Insert_B_Matrix = view.findViewById(R.id.BInsert_button);
        Product_matirx_btn = view.findViewById(R.id.Product_button);
        Order_btn = view.findViewById(R.id.Order_Button);
        Order_et = view.findViewById(R.id.Order_EditText);
    }

}
