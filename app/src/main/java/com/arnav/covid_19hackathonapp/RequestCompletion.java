package com.arnav.covid_19hackathonapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import androidx.appcompat.app.AppCompatActivity;
import uk.co.jakebreen.sendgridandroid.SendGrid;
import uk.co.jakebreen.sendgridandroid.SendGridMail;
import uk.co.jakebreen.sendgridandroid.SendGridResponse;
import uk.co.jakebreen.sendgridandroid.SendTask;

public class RequestCompletion extends AppCompatActivity {
    //final page for form request, emails would be sent once donations come in
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_completion);
        try {
            sendMail();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

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
        mail.setSubject("Request Confirmation");
        //mail.setContent("Thank You for your donation, You will receive an email from a hospital or the helpper team in a few days");
        mail.setHtmlContent(EmailConstants.req);

        SendTask task = new SendTask(sendGrid, mail);
        SendGridResponse response = task.execute().get();
        response.isSuccessful();
        response.getCode();
        response.getErrorMessage();
        Toast.makeText(getApplicationContext(), "Confirmation Email Sent", Toast.LENGTH_SHORT).show();
    }
}
