package com.example.a4su18is005app3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    EditText username,password;
    Button signInBtn;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        username = (EditText)findViewById(R.id.username);
        password =(EditText)findViewById(R.id.password);
        signInBtn = (Button)findViewById(R.id.signin);

        Bundle bundle  = getIntent().getExtras();
        String uname = bundle.getString("username");
        String pwd = bundle.getString("password");

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass =password.getText().toString();

                if(user.equals(uname) && pass.equals(pwd)){
                    Intent it = new Intent(getBaseContext(), Success.class);
                    startActivity(it);
                }
                else{
                    count++;
                    if(count>=3){
                        signInBtn.setEnabled(false);
                    }else{
                        Toast.makeText(SignIn.this,"Failed",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }
}