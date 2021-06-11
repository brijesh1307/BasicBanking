package com.bombay.basicbanking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView bankLogo;
    TextView tvBankTitle;
    Button btnAllUsers, btnAllTransactions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bankLogo = findViewById(R.id.bank_logo);
        tvBankTitle = findViewById(R.id.bank_title);
        btnAllUsers = findViewById(R.id.all_users);
        btnAllTransactions = findViewById(R.id.all_transactions);



    }


        public void showAllUsers(View view){
            Intent intent = new Intent(this, activity_users_list.class);
            startActivity(intent);
        }

    public void showAllTransactions(View view) {
        Intent intent = new Intent(this, activity_transaction_history.class);
        startActivity(intent);
    }



}