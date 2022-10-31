package com.cursoandroid.ph.calculatetip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText inputValue;
    private TextView textPercent, textTipValue, textTotalValue;
    private SeekBar seekBarPercent;

    private double percent = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputValue = findViewById(R.id.costTotal);
        textPercent = findViewById(R.id.textViewPercent);
        textTipValue = findViewById(R.id.textViewTipValue);
        textTotalValue = findViewById(R.id.textViewTotalCostValue);
        seekBarPercent = findViewById(R.id.seekBarPercent);

        seekBarPercent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percent = progress;
                textPercent.setText(Math.round(percent) + "%");
                calcTipCost();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcTipCost () {
        String costValue = inputValue.getText().toString();
        if (costValue == null || costValue.equals("")) {
            Toast.makeText(
                    getApplicationContext(),
                    "Digite o valor da conta!",
                    Toast.LENGTH_LONG
            ).show();
        } else {
            double inputValue = Double.parseDouble(costValue);
            double tip = inputValue * (percent / 100);
            textTipValue.setText("R$ " + tip);
            double total = inputValue + tip;
            textTotalValue.setText("R$ " + total);
        }
    }
}