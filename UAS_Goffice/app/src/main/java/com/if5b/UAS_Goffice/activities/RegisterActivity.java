package com.if5b.UAS_Goffice.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.if5b.UAS_Goffice.R;
import com.if5b.UAS_Goffice.databinding.ActivityRegisterBinding;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;
    FirebaseFirestore fstore;
    FirebaseAuth mAuth;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.etUsername.getText().toString();
                String email = binding.etRegEmail.getText().toString();
                String notelephone = binding.etNoTelephone.getText().toString();
                String password = binding.etRegPass.getText().toString();

                if (TextUtils.isEmpty(username)) {
                    binding.etUsername.setError("UserName jangan Kosong");
                    binding.etUsername.requestFocus();
                }
                if (TextUtils.isEmpty(email)) {
                    binding.etRegEmail.setError("Email jangan Kosong");
                    binding.etRegEmail.requestFocus();
                }
                if (TextUtils.isEmpty(notelephone)) {
                    binding.etNoTelephone.setError("Nomor Telephone jangan Kosong");
                    binding.etNoTelephone.requestFocus();
                }
                if (TextUtils.isEmpty(password)) {
                    binding.etRegPass.setError("Password jangan Kosong");
                    binding.etRegPass.requestFocus();
                } else {
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                    Toast.makeText(RegisterActivity.this, "Register Berhasil!", Toast.LENGTH_SHORT).show();
                                    userID = mAuth.getCurrentUser().getUid();
                                    DocumentReference documentReference = fstore.collection("Users").document(userID);
                                    Map<String, Object> user = new HashMap<>();
                                    user.put("username", username);
                                    user.put("notelephone", notelephone);
                                    user.put("email", email);
                                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            Toast.makeText(RegisterActivity.this, "Username Telah di buat", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(RegisterActivity.this, "Register Gagal!", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });

        binding.tvLoginHere.setOnClickListener(view -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        });
    }
}

