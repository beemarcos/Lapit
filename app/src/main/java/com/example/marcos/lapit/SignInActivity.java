package com.example.marcos.lapit;

import android.accounts.Account;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {

    private EditText nEmailField;
    private EditText nPasswordField;

    private Button nLoginBtn;
    private Toolbar nSignInToolbar;

    private FirebaseAuth nAuth;
    private FirebaseAuth.AuthStateListener nAuthListener;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        nAuth = FirebaseAuth.getInstance();

        nSignInToolbar = (Toolbar)findViewById(R.id.signInToolbar);
        setSupportActionBar(nSignInToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nEmailField = (EditText)findViewById(R.id.tfUsuario);
        nPasswordField = (EditText)findViewById(R.id.tfSenha);
        nLoginBtn = (Button) findViewById(R.id.buttonEntrar);

        nAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!= null){
                    startActivity(new Intent(SignInActivity.this, AccountActivity.class));
                }

            }
        };

        nLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignIn();
            }
        });






    }


    @Override
    protected void onStart() {
        super.onStart();
        nAuth.addAuthStateListener(nAuthListener);
    }


    private void startSignIn(){
        String email = nEmailField.getText().toString();
        String password = nPasswordField.getText().toString();

        if(TextUtils.isEmpty(email)||TextUtils.isEmpty(password)){
            Toast.makeText(SignInActivity.this,"Preencha todos os campos!",Toast.LENGTH_LONG).show();
        }else{
            nAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()){
                        Toast.makeText(SignInActivity.this,"Problema no login!",Toast.LENGTH_LONG).show();

                    }

                }
            });
        }



    }
}
