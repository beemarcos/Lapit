package com.example.marcos.lapit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity {

    private EditText mEmailField;
    private EditText mPasswordField;

    private Button mLoginBtn;

    private Toolbar mSignInToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mSignInToolbar = (Toolbar)findViewById(R.id.signInToolbar);
        setSupportActionBar(mSignInToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mEmailField = (EditText)findViewById(R.id.tfUsuario);
        mPasswordField = (EditText)findViewById(R.id.tfSenha);









    }
}
