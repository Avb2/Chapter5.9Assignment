package com.example.restaurantrater;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.restaurantrater.models.RestaurantModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        clearButton();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void clearButton(){
        Button button = findViewById(R.id.cancelButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText addressText = findViewById(R.id.addressEditText);
                EditText nameText = findViewById(R.id.nameEditText);
                EditText cityText = findViewById(R.id.cityEditText);
                EditText zipcodeText = findViewById(R.id.zipcodeEditText);
                EditText stateText = findViewById(R.id.stateEditText);

                addressText.setText("");
                nameText.setText("");
                cityText.setText("");
                zipcodeText.setText("");
                stateText.setText("");

            }
        });
    }

    public void saveButton(){
        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /// Text Fields
                EditText addressText = findViewById(R.id.addressEditText);
                EditText nameText = findViewById(R.id.nameEditText);
                EditText cityText = findViewById(R.id.cityEditText);
                EditText zipcodeText = findViewById(R.id.zipcodeEditText);
                EditText stateText = findViewById(R.id.stateEditText);

                /// Model
                int zipcode = 0;
                if (!zipcodeText.getText().toString().isEmpty()){
                    zipcode = Integer.parseInt(zipcodeText.getText().toString());
                }
                RestaurantModel restaurantModel = new RestaurantModel(
                        nameText.getText().toString(),
                        addressText.getText().toString(),
                        cityText.getText().toString(),
                        stateText.getText().toString(),
                        zipcode
                );

                ///
            }
        });
    }

}