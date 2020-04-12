package com.example.student.splitbillapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class SplitBillActivity extends AppCompatActivity {


    int numberofpeople;
    double billamount;
    double subtotal;
    double totalcost;
    double tip1=0.20;
    double tip2=0.15;
    double tip3=0.10;
    double tip4;
    double amountoftip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split_bill);

        final EditText numberofpersons= (EditText)findViewById(R.id.prompt2);
        final Spinner tipchoice=(Spinner)findViewById(R.id.tipSelection);
        final EditText customtip= (EditText)findViewById(R.id.prompt3);
        final EditText costofmeal= (EditText)findViewById(R.id.prompt1);
        Button cost=(Button)findViewById(R.id.btn2);
        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = (TextView) findViewById(R.id.result);

            @Override
            public void onClick(View view) {

                String amountofpeople;
                amountofpeople= numberofpersons.getText().toString();
                if(amountofpeople.equals("")) amountofpeople = "1";

                String billamt;
                billamt=costofmeal.getText().toString();
                if(billamt.equals("")) billamt="0";

                String numpercent;
                numpercent=customtip.getText().toString();
                if(numpercent.equals("")) numpercent="0";

                numberofpeople = Integer.parseInt(amountofpeople);
                billamount=Double.parseDouble(billamt);
                amountoftip=Double.parseDouble(numpercent);



                long tip = tipchoice.getSelectedItemPosition();

                    if (tip == 0) {

                        customtip.setText(null);
                        amountoftip = tip1;
                        billamount=billamount;
                        numberofpeople=numberofpeople;


                    } else if (tip == 1) {

                        customtip.setText(null);
                            amountoftip = tip2;
                            billamount=billamount;
                            numberofpeople=numberofpeople;


                    } else if (tip == 2) {
                        customtip.setText(null);


                            amountoftip = tip3;
                            billamount=billamount;
                            numberofpeople=numberofpeople;

                    } else if (tip == 3) {

                            tip4=Double.parseDouble(numpercent);
                            tip4 = tip4 / 100;

                            amountoftip = tip4;
                            billamount = billamount;
                            numberofpeople = numberofpeople;

                    }
                    subtotal = (amountoftip * billamount) + billamount;
                    totalcost = (subtotal / numberofpeople);

                    DecimalFormat currency = new DecimalFormat("###,##0.00");
                    result.setText("Each person should pay $" + currency.format(totalcost) + ".");

            }
        });
    }
}

