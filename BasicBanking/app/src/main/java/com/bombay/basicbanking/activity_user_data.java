package com.bombay.basicbanking;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class activity_user_data extends AppCompatActivity {

    TextView name, accountNo, email, phoneNo, balance, ifscCode;
    Button transferMoney;
    AlertDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);


        name = findViewById(R.id.name);
        accountNo = findViewById(R.id.account_no);
        email = findViewById(R.id.email_id);
        phoneNo = findViewById(R.id.phone_no);
        balance = findViewById(R.id.avail_balance);
        ifscCode = findViewById(R.id.ifsc_id);
        transferMoney = findViewById(R.id.transfer_money);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null) {

            name.setText(extras.getString("NAME"));
            accountNo.setText(String.valueOf(extras.getInt("ACCOUNT_NO")));
            email.setText(extras.getString("EMAIL"));
            phoneNo.setText(extras.getString("PHONE_NO"));
            balance.setText(extras.getString("BALANCE"));
            ifscCode.setText(extras.getString("IFSC_CODE"));
        } else {
            Log.d("TAG", "Empty Intent");
        }


        transferMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterAmount();
            }
        });
    }


    private void enterAmount() {
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(activity_user_data.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_box, null);
        mBuilder.setTitle("Enter Amount").setView(mView).setCancelable(false);

        final EditText mAmount = (EditText) mView.findViewById(R.id.enter_money);
        mBuilder.setPositiveButton("SEND", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) { }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                transactionCancel();
            }
        });

        dialog = mBuilder.create();
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking the entered amount is valid or not to transafer
                int currentBalance  = Integer.parseInt(String.valueOf(balance.getText()));

                // Condition checker to entered amount is valid
                if (mAmount.getText().toString().isEmpty()){
                    mAmount.setError("Amount can't be empty");
                }
                else if (Integer.parseInt(mAmount.getText().toString()) > currentBalance){
                    mAmount.setError("Don't have Sufficient Amount To Transfer");
                }
                else {
                    Intent intent = new Intent(activity_user_data.this,activity_send_to_user.class);
                    intent.putExtra("FROM_USER_ACCOUNT_NO" ,Integer.parseInt(accountNo.getText().toString()));
                    intent.putExtra("FROM_USER_NAME",name.getText());
                    intent.putExtra("FROM_USER_ACCOUNT_BALANCE", balance.getText());
                    intent.putExtra("TRANSFER_AMOUNT", mAmount.getText().toString());
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void transactionCancel() {
        AlertDialog.Builder builder_exitbutton = new AlertDialog.Builder(activity_user_data.this);
        builder_exitbutton.setTitle("Do you want Cancel the Transaction").setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(activity_user_data.this, "Transaction Cancelled", Toast.LENGTH_LONG).show();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                enterAmount();
            }
        });
        AlertDialog alertexit = builder_exitbutton.create();
        alertexit.show();
    }

}
