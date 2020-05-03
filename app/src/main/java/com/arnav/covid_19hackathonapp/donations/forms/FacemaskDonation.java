package com.arnav.covid_19hackathonapp.donations.forms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.arnav.covid_19hackathonapp.R;
import com.arnav.covid_19hackathonapp.donations.firebase.FirebaseFacemaskData;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FacemaskDonation extends AppCompatActivity {
    TextInputLayout addressdon, apartmentdon, statedon, zipcodedon, facemasksdon, commentsdon, citydon, phonedon;
    Button submitdon;
    CheckBox dropdon, shipdon, volunteerdon;
    CardView cardview;

    FirebaseDatabase database;
    DatabaseReference reference, authref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facemask_donation);

        //Hooks
        addressdon = findViewById(R.id.street_address_facemask_domation);
        apartmentdon = findViewById(R.id.apt_donation);
        statedon = findViewById(R.id.state_facemask_donation);
        zipcodedon = findViewById(R.id.zip_facemask_donation);
        facemasksdon = findViewById(R.id.amount_facemask_donation);
        commentsdon = findViewById(R.id.comments_facemask);
        submitdon = findViewById(R.id.submit_facmask);
        dropdon = findViewById(R.id.drop_facmask);
        shipdon = findViewById(R.id.ship_facemask);
        volunteerdon = findViewById(R.id.volunteer_facemask);
        citydon = findViewById(R.id.city_facemask_donation);
        cardview = findViewById(R.id.donate_facemasks_box);
        phonedon = findViewById(R.id.phone_facemask_donation);

        submitdon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateAddress() || !validateApartment() || !validateState() || !validateNumber() || !validateComments() || !validateCity() || !validateOption() || !validateZip()) {
                    return;
                }
                database = FirebaseDatabase.getInstance();
                authref = database.getReference("Users");
                reference = database.getReference("FacemaskDonation");


                String address = addressdon.getEditText().getText().toString();
                String apartment = apartmentdon.getEditText().getText().toString();
                String state = statedon.getEditText().getText().toString();
                String facemasks = facemasksdon.getEditText().getText().toString();
                String comments = commentsdon.getEditText().getText().toString();
                String city = citydon.getEditText().getText().toString();
                String zipcode = zipcodedon.getEditText().getText().toString();
                final String phone = phonedon.getEditText().getText().toString();

                final FirebaseFacemaskData faceMaskData = new FirebaseFacemaskData(address, apartment, facemasks, city, zipcode, state, comments);

                authref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            String nameFromDB = dataSnapshot.child("name").getValue(String.class);
                            String phoneNumberFromDB = dataSnapshot.child(phone).child("phoneNumber").getValue(String.class);
                            String emailFromDB = dataSnapshot.child("email").getValue(String.class);
                            reference.child(phoneNumberFromDB).child("Name").setValue(nameFromDB);
                            reference.child(phoneNumberFromDB).child("Phone_Number").setValue(phoneNumberFromDB);
                            reference.child(phoneNumberFromDB).child("Email").setValue(emailFromDB);
                            reference.child(phoneNumberFromDB).setValue(faceMaskData);
                            if (dropdon.isChecked()) {
                                reference.child(phoneNumberFromDB).child("Drop_Off").setValue("Yes");
                            } else {
                                reference.child(phoneNumberFromDB).child("Drop_Off").setValue("No");
                            }
                            if (shipdon.isChecked()) {
                                reference.child(phoneNumberFromDB).child("Ship").setValue("Yes");
                            } else {
                                reference.child(phoneNumberFromDB).child("Ship").setValue("No");
                            }
                            if (volunteerdon.isChecked()) {
                                reference.child(phoneNumberFromDB).child("Volunteer").setValue("Yes");
                            } else {
                                reference.child(phoneNumberFromDB).child("Volunteer").setValue("No");
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

    }

    private Boolean validateAddress() {
        String value = addressdon.getEditText().getText().toString();
        if (value.isEmpty()) {
            addressdon.setError("Field Is Required");
            return false;
        } else {
            addressdon.setError(null);
            addressdon.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateApartment() {
        String value = apartmentdon.getEditText().getText().toString();
        if (value.isEmpty()) {
            apartmentdon.setError(null);
            apartmentdon.setSoundEffectsEnabled(false);
            return true;
        } else {
            apartmentdon.setError(null);
            apartmentdon.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateState() {
        String value = statedon.getEditText().getText().toString();
        if (value.isEmpty()) {
            statedon.setError("Field Is Required");
            return false;
        } else {
            statedon.setError(null);
            statedon.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateNumber() {
        String value = facemasksdon.getEditText().getText().toString();
        if (value.isEmpty()) {
            facemasksdon.setError("Field Is Required");
            return false;
        } else {
            facemasksdon.setError(null);
            facemasksdon.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateComments() {
        String value = commentsdon.getEditText().getText().toString();
        if (value.isEmpty()) {
            commentsdon.setError(null);
            commentsdon.setErrorEnabled(false);
            return true;
        } else {
            commentsdon.setError(null);
            commentsdon.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateCity() {
        String value = citydon.getEditText().getText().toString();
        if (value.isEmpty()) {
            citydon.setError("Field Is Required");
            return false;
        } else {
            citydon.setError(null);
            citydon.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateOption() {
        if (dropdon.isChecked() || shipdon.isChecked() || volunteerdon.isChecked()) {
            dropdon.setError(null);
            shipdon.setError(null);
            volunteerdon.setError(null);
            return true;
        } else {
            dropdon.setError("At least one option is required");
            shipdon.setError("At least one option is required");
            volunteerdon.setError("At least one option is required");
            return false;
        }
    }

    private Boolean validateZip() {
        String value = zipcodedon.getEditText().getText().toString();
        if (value.isEmpty()) {
            zipcodedon.setError("Field Is Required");
            return false;
        } else {
            zipcodedon.setError(null);
            zipcodedon.setErrorEnabled(false);
            return true;
        }
    }


}
