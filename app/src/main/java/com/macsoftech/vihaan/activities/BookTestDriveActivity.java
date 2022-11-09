package com.macsoftech.vihaan.activities;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.macsoftech.vihaan.R;
import com.macsoftech.vihaan.api.RestApi;
import com.macsoftech.vihaan.model.BrandResponse;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.macsoftech.vihaan.api.RestApi.prepareBodyPart;

public class BookTestDriveActivity extends BaseActivity {

    EditText eName, eContactNo, eAdharNo, eAddress1, eAddress2, eLandmark, eCity;
    Button submit;
    // TextView vehicleName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booktestdrive);
       getSupportActionBar().setTitle("Book a Ride");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().hide();
        eName = findViewById(R.id.edit_name);
        eAdharNo = findViewById(R.id.edit_adharno);
        eContactNo = findViewById(R.id.edit_contactno);
        eAddress1 = findViewById(R.id.edit_addrs1);
        eAddress2 = findViewById(R.id.edit_addrs2);
        eLandmark = findViewById(R.id.edit_lmark);
        eCity = findViewById(R.id.edit_city);
        submit = findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onBtnClick();
                }
            });
        }

    private void onBtnClick() {
        BrandResponse data = getIntent().getParcelableExtra("data");
        String name = eName.getText().toString();
        String adharNO = eAdharNo.getText().toString();
        String contactNo = eContactNo.getText().toString();
        String address1 = eAddress1.getText().toString();
        String address2 = eAddress2.getText().toString();
        String landMark = eLandmark.getText().toString();
        String city = eCity.getText().toString();

        //
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("aadharNo", adharNO);
        map.put("contactNo", contactNo);
        map.put("vehicleName", data.getVehicleName());
        map.put("model", data.getModel());
        map.put("address", address1);
        map.put("area", address2);
        map.put("landmark", landMark);
        map.put("city", city);
       // map.put("vehicle name", String.valueOf(vehicleName));
        showProgress();

        RestApi.getInstance().getService().bookRide(prepareBodyPart(map))
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        hideDialog();
                        if (name.isEmpty())
                        {
                            Toast.makeText(BookTestDriveActivity.this, "Please Enter your Name....", Toast.LENGTH_SHORT).show();
                        }
                        else if (adharNO.isEmpty())
                        {
                            Toast.makeText(BookTestDriveActivity.this, "Aadhar No Required", Toast.LENGTH_SHORT).show();
                        }
                        else if (contactNo.isEmpty())
                        {
                            Toast.makeText(BookTestDriveActivity.this, "Contact No Required", Toast.LENGTH_SHORT).show();
                        }
                        else if (address1.isEmpty())
                        {
                            Toast.makeText(BookTestDriveActivity.this, "Address Required", Toast.LENGTH_SHORT).show();
                        }
                        else if (address2.isEmpty())
                        {
                            Toast.makeText(BookTestDriveActivity.this, "Area Required", Toast.LENGTH_SHORT).show();
                        }
                        else if (landMark.isEmpty())
                        {
                            Toast.makeText(BookTestDriveActivity.this, "Landmark Required", Toast.LENGTH_SHORT).show();
                        }
                        else if (city.isEmpty())
                        {
                            Toast.makeText(BookTestDriveActivity.this, "City Required", Toast.LENGTH_SHORT).show();
                        }
                        else if(response.isSuccessful()) {
                            showToast("Book Ride Successfully.");
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        hideDialog();
                    }
                });

//        showProgress();
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                success();
//            }
//        }, 2000);
    }

    private void success() {
        hideDialog();
        showToast("Booked Successfully");
        finish();
    }
}