package com.arnav.covid_19hackathonapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.ExecutionException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import uk.co.jakebreen.sendgridandroid.SendGrid;
import uk.co.jakebreen.sendgridandroid.SendGridMail;
import uk.co.jakebreen.sendgridandroid.SendGridResponse;
import uk.co.jakebreen.sendgridandroid.SendTask;

public class DonationCompletion extends AppCompatActivity {
    //final screen, once request come in emails will be sent through firebase messaging service
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_completion);
        try {
            sendMail();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        //new SendEmail().execute();

    }

    //   public static void main(String[] args) throws IOException {

    // }

    public void sendMail() throws ExecutionException, InterruptedException {
        //EmailConstants emailconstants = new EmailConstants();
        SendGrid sendGrid = SendGrid.create("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");
        Intent intent = getIntent();
        String email = intent.getStringExtra("emailFromDB");
        String name = intent.getStringExtra("nameFromDB");
        SendGridMail mail = new SendGridMail();
        assert email != null;
        mail.addRecipient(email, name);
        mail.setFrom("sarn248@gmail.com", "HelPPEr");
        mail.setSubject("Donation Confirmation");
        //mail.setContent("Thank You for your donation, You will receive an email from a hospital or the helpper team in a few days");
        mail.setHtmlContent(EmailConstants.donate);

        SendTask task = new SendTask(sendGrid, mail);
        SendGridResponse response = task.execute().get();
        response.isSuccessful();
        response.getCode();
        response.getErrorMessage();
        Toast.makeText(getApplicationContext(), "Confirmation Email Sent", Toast.LENGTH_SHORT).show();
    }

}
