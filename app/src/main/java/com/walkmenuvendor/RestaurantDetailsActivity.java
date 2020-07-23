package com.walkmenuvendor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class RestaurantDetailsActivity extends AppCompatActivity {

    FirebaseUser firebaseUser;
    String phoneNumber;

    Toolbar toolbar;

    String restaurantType;

    FirebaseFirestore db;

    EditText txtrestaurantName, txtrestaurantEmail, txtrestaurantFSSAI, txtrestaurantGST, txtrestaurantAlternateNumber;

    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Orders");
        this.setSupportActionBar(toolbar);

        txtrestaurantName = findViewById(R.id.restaurant_name_edit);
        txtrestaurantEmail = findViewById(R.id.restaurant_email_edit);
        txtrestaurantFSSAI = findViewById(R.id.restaurant_FSSAI_code_edit);
        txtrestaurantGST = findViewById(R.id.restaurant_GST_number_edit);
        txtrestaurantAlternateNumber = findViewById(R.id.restaurant_alternate_number_edit);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        phoneNumber = firebaseUser.getPhoneNumber();

        db = FirebaseFirestore.getInstance();

        Log.i("PhoneNumber is",phoneNumber);

        save = findViewById(R.id.data_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRestaurantType();
            }
        });
    }

    private void getRestaurantType(){
        db.collection("ServiceProviders").document(phoneNumber).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot documentSnapshot = task.getResult();
                    restaurantType = documentSnapshot.getString("restaurantType");
                }
            }
        });

        saveRestaurantData();
    }

    private void saveRestaurantData(){

        String restaurantName = txtrestaurantName.getText().toString().trim();
        String restaurantEmail = txtrestaurantEmail.getText().toString().trim();
        String restaurantFSSAI = txtrestaurantFSSAI.getText().toString().trim();
        String restaurantGST = txtrestaurantGST.getText().toString().trim();
        String restaurantAlternateNumber = txtrestaurantAlternateNumber.getText().toString();
        String restaurantDesc = "Yet to be updated";
        String restaurantNumber = phoneNumber;
        Boolean deliveryStatus = true;
        Boolean dineinStatus = true;
        Boolean takeawayStatus = true;
        int latitude = 0;
        int longitude = 0;

        if(TextUtils.isEmpty(restaurantName)){
            Toast.makeText(getApplicationContext(),"Enter Restaurant Name",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(restaurantEmail)){
            Toast.makeText(getApplicationContext(),"Enter Restaurant Email",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(restaurantFSSAI)){
            Toast.makeText(getApplicationContext(),"Enter Restaurant FSSAI",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(restaurantGST)){
            Toast.makeText(getApplicationContext(),"Enter Restaurant GST",Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(restaurantAlternateNumber)){
            Toast.makeText(getApplicationContext(),"Enter Restaurant Alternate Number",Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isDigitsOnly(restaurantAlternateNumber) == false){
            Toast.makeText(getApplicationContext(),"Enter correct number",Toast.LENGTH_SHORT).show();
        }

        HashMap<String, Object> restaurantData = new HashMap<>();
        restaurantData.put("restaurantName",restaurantName);
        restaurantData.put("restaurantEmail",restaurantEmail);
        restaurantData.put("restaurantFSSAI",restaurantFSSAI);
        restaurantData.put("restaurantGST",restaurantGST);
        restaurantData.put("restaurantAlternateNumber",restaurantAlternateNumber);
        restaurantData.put("restaurantDesc",restaurantDesc);
        restaurantData.put("restaurantNumber",restaurantNumber);
        restaurantData.put("deliveryStatus",deliveryStatus);
        restaurantData.put("dineinStatus",dineinStatus);
        restaurantData.put("takeawayStatus",takeawayStatus);
        restaurantData.put("latitude",latitude);
        restaurantData.put("longitude",longitude);

        db.collection(restaurantType).document(phoneNumber).set(restaurantData).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Intent intent = new Intent(RestaurantDetailsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}