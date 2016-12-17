package comsiteprojectcyborn.google.sites.findyournexthome.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import comsiteprojectcyborn.google.sites.findyournexthome.R;

public class SignIn_activity extends AppCompatActivity {

    Button btn_SignUp;
    Button btn_SignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btn_SignUp = (Button) findViewById(R.id.btn_signup);
        btn_SignIn = (Button) findViewById(R.id.btn_Signin);

        btn_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn_activity.this,SignUp_Activity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
