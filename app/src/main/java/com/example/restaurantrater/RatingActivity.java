package com.example.restaurantrater;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.restaurantrater.helper.RatingData;
import com.example.restaurantrater.models.RatingModel;

public class RatingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rating);

        saveRatingButton();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }



    public void saveRatingButton(){
        Button saveButton = findViewById(R.id.ratingSaveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /// Fields
                EditText nameEditText = findViewById(R.id.nameEditText);
                RatingBar ratingBar = findViewById(R.id.ratingBar);
                String type = "entree";

                /// Field Values
                String name = nameEditText.getText().toString();
                int rating = ratingBar.getNumStars();

                /// Radio buttons
                RadioButton entreeRadio = findViewById(R.id.entreeRadio);
                RadioButton appetizerRadio = findViewById(R.id.appetizerRadio);
                RadioButton dessertRadio = findViewById(R.id.dessertRadio);

                if (entreeRadio.isChecked()) {
                    type = "entree";
                } else if (appetizerRadio.isChecked()) {
                    type = "appetizer";
                } else if (dessertRadio.isChecked()) {
                    type = "dessert";
                }

                /// Rating model
                RatingModel ratingModel = new RatingModel(
                        type,
                        name,
                        rating
                );

                /// Get intent vals
                Bundle bundle = getIntent().getExtras();
                String restaurantname = bundle.getString("restaurantName");
                String address = bundle.getString("address");

                /// Create /insert db vals
                try {
                    RatingData ratingData = new RatingData(RatingActivity.this, restaurantname, address);
                    ratingData.open();
                    ratingData.insertVals(ratingModel);
                    ratingData.close();
                } catch (Exception e) {
                }
            }
        });
    }
}