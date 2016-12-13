package org.secureapps.securemessage;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.secureapps.securemessage.exception.ValidationFailureException;
import org.secureapps.securemessage.validator.PinValidator;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        Button registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void loginUser() {

        UserHandler userHandler = new UserHandler();

        EditText editText = (EditText) findViewById(R.id.pinNumber);
        String pinNumber  = editText.getText().toString();

        TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.pinNumberLayout);
        textInputLayout.setErrorEnabled(true);

        PinValidator pinValidator = new PinValidator(pinNumber);

        try {
            pinValidator.validate();
        } catch (ValidationFailureException e) {
            textInputLayout.setError(e.getMessage());
            return;
        }

        userHandler.login(pinValidator.getValidatedPinNumber());

        startActivity(new Intent(getApplicationContext(), ContactsActivity.class));
        finish();
    }

    private void registerUser() {

    }
}
