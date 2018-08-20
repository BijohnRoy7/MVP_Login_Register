package invenz.roy.mvpprac1.Registration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import invenz.roy.mvpprac1.Login.LoginActivity;
import invenz.roy.mvpprac1.MainActivity;
import invenz.roy.mvpprac1.R;

public class RegisterActivity extends AppCompatActivity implements RegView{

    private EditText etUserName, etPassword, etEmail;
    private Button btRegsiter;
    private TextView tvLoginHere;
    private ProgressBar progressBar;

    private RegPresenter mRegPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUserName = findViewById(R.id.idUserName_reg);
        etPassword = findViewById(R.id.idPassword_reg);
        etEmail = findViewById(R.id.idEmail_reg);
        btRegsiter = findViewById(R.id.button_reg);
        progressBar = findViewById(R.id.progressBar_reg);
        tvLoginHere =findViewById(R.id.idLoginHere_reg);

        mRegPresenter = new RegPresenterImpl(this);

        btRegsiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRegPresenter.register_presenter(etUserName.getText().toString().trim(), etEmail.getText().toString().trim(), etPassword.getText().toString().trim(), RegisterActivity.this);
            }
        });


        tvLoginHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
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
        etUserName.setError("UserName Empty");
    }

    @Override
    public void setPasswordError_view() {
        etPassword.setError("PAssword Empty");
    }

    @Override
    public void setEmailError_view() {
        etEmail.setError("Email Empty");
    }

    @Override
    public void navigateMainActivity_view() {
        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
    }

    @Override
    public void showAlert_view(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
