package com.example.btl.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.btl.MainActivity;
import com.example.btl.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    private EditText edtEmail,edtPassword;
    Button btnSignUp;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initUi();   //init giao diện
        initListener(); // init sự kiện listen
    }

    private void initListener() {
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSignUp();
            }
        });
    }

    private void onClickSignUp() {
        String email=edtEmail.getText().toString().trim();
        String password=edtPassword.getText().toString().trim();
        FirebaseAuth auth= FirebaseAuth.getInstance();
        progressDialog.show();
        auth.createUserWithEmailAndPassword(email, password)    // truyền vào tham số email và pass
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) { // nhận phản hồi
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(SignUpActivity.this, MainActivity.class); // tự động truyền vào MainActivity
                            startActivity(intent);
                            finishAffinity();
                        } else {
                            Toast.makeText(SignUpActivity.this, "Đăng kí thất bại.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void initUi() {
        edtEmail=findViewById(R.id.edtEmail);
        edtPassword=findViewById(R.id.edtPassword);
        btnSignUp=findViewById(R.id.btn_SignUp);
        progressDialog=new ProgressDialog(this);
    }
}