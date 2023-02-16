package com.example.emi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edpr,edin,edti;
        Button btnCalculator,btnRsset;
        TextView txttotal,txtpermo,txtintest;

        edpr = findViewById(R.id.edpr);
        edin = findViewById(R.id.edin);
        edti = findViewById(R.id.edti);
        btnCalculator = findViewById(R.id.btnCalculator);
        btnRsset = findViewById(R.id.btnRsset);
        txttotal = findViewById(R.id.txttotal);
        txtpermo = findViewById(R.id.txtpermo);
        txtintest = findViewById(R.id.txtintest);

        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strpr = edpr.getText().toString();
                String strin = edin.getText().toString();
                String strti = edti.getText().toString();

                float pr = Float.parseFloat(strpr);//2000
                float in = Float.parseFloat(strin);//2
                float ti = Float.parseFloat(strti);//5

                double a=1;
                double b=in+1;

                for (int i = 1; i <= ti; i++) {
                    a = a*(b);
                }

                // pr x in x (in+1)^ti / (in+1)^ti-1

                double Emi= pr*in*(a)/(a-1);
                double permon = Emi/ti;
                double intest = Emi-pr;

                txttotal.setText("Emi= "+Emi);
                txtpermo.setText("Per month= "+permon);
                txtintest.setText("Intest= "+intest);
            }
        });

        btnRsset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    edin.setText("");
                    edpr.setText("");
                    edti.setText("");
                    txttotal.setText("");
                    txtpermo.setText("");
                    txtintest.setText("");
            }
        });


    }
}