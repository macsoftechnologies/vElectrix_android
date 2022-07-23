package com.macsoftech.vihaan.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.macsoftech.vihaan.R;

public class BookTestDriveActivity extends BaseActivity {

    EditText eName,eContactNo,eAdharNo,eAddress1,eAddress2,eLandmark,eCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booktestdrive);
        eName = findViewById(R.id.edit_name);
        eAdharNo = findViewById(R.id.edit_adharno);
        eContactNo = findViewById(R.id.edit_contactno);
        eAddress1 = findViewById(R.id.edit_addrs1);
        eAddress2 = findViewById(R.id.edit_addrs2);
        eLandmark = findViewById(R.id.edit_lmark);
        eCity = findViewById(R.id.edit_city);

        Button submit = findViewById(R.id.btn_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = eName.getText().toString();
                String adharNO = eAdharNo.getText().toString();
                String contactNo = eContactNo.getText().toString();
                String address1 = eAddress1.getText().toString();
                String address2 = eAddress2.getText().toString();
                String landMark = eLandmark.getText().toString();
                String city = eCity.getText().toString();


                
            }
        });
    }
}