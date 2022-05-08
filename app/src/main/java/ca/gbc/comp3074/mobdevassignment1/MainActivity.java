package ca.gbc.comp3074.mobdevassignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText hoursWorked;
    private EditText hourlyRate;
    private TextView calcPay;
    private TextView calcOvertime;
    private TextView calcTotal;
    private TextView calcTax;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hoursWorked = (EditText) findViewById(R.id.hoursWorked);
        hourlyRate = (EditText) findViewById(R.id.hourlyRate);

        Button calculatebtn = (Button) findViewById(R.id.calculatebtn);

        calcPay = (TextView) findViewById(R.id.calcPay);
        calcOvertime = (TextView) findViewById(R.id.calcOvertime);
        calcTotal = (TextView) findViewById(R.id.calcTotal);
        calcTax = (TextView) findViewById(R.id.calcTax);

        calculatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(hoursWorked.getText().toString()) ||
                        TextUtils.isEmpty(hourlyRate.getText().toString()))
                {
                    Toast.makeText(MainActivity.this,
                            "You must not have empty input", Toast.LENGTH_LONG).show();
                }else
                calculateResult();
            }
        });
    }

    private void calculateResult(){
        double tax;
        double pay;
        double overtime;
        double total;
        double hours = Double.valueOf(hoursWorked.getText().toString());
        double rate = Double.valueOf(hourlyRate.getText().toString());

        if(hours <= 40){
            pay = hours*rate;
            overtime = 0;
            total = pay + overtime;
            tax = total * 0.18;
        }else{
            pay = hours*rate;
            overtime = (hours-40)*rate*1.5 + 40*rate;
            total = pay + overtime;
            tax = total * 0.18;
        }
        calcPay.setText("Your pay is: " + pay);
        calcOvertime.setText("Your overtime is " + overtime);
        calcTotal.setText("Your total is: " + total );
        calcTax.setText("Your tax is: " + tax);

    }

    private void getInfo(){
        Intent start = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(start);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_abt_act:
                getInfo();
                return true;
            case R.id.menu_msg:
                Toast.makeText(getApplicationContext(),"Enter Your Info to Use the Calculator",
                        Toast.LENGTH_LONG).show();
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }
}