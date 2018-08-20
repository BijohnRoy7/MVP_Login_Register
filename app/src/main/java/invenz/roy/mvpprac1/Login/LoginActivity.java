package invenz.roy.mvpprac1.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import invenz.roy.mvpprac1.MainActivity;
import invenz.roy.mvpprac1.R;
import invenz.roy.mvpprac1.Registration.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private EditText etUserName, etPassword;
    private Button btLogin;
    private TextView tvRegHere;
    private ProgressBar progressBar;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserName = findViewById(R.id.idUserName);
        etPassword = findViewById(R.id.idPassword);
        btLogin = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressBar);
        tvRegHere = findViewById(R.id.idRegHere);

        mLoginPresenter = new LoginPresenterImpl(this);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mLoginPresenter.validateCred_presenter(etUserName.getText().toString().trim(), etPassword.getText().toString().trim(), LoginActivity.this);
            }
        });

        tvRegHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

    }

    @Override
    public void showProgressBar_view() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar_view() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUserNameError_view() {
        etUserName.setError("Username Empty");
    }

    @Override
    public void setPasswordError_view() {
        etPassword.setError("Password Empty");
    }

    @Override
    public void navigateToMainActivity_view() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    @Override
    public void showAlertMessage_view(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
