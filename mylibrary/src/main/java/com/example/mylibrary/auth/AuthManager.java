package com.example.mylibrary.auth;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AuthManager {

    public static Task<AuthResult> saveUser(String email, String password, FirebaseAuth auth) {
        return auth.createUserWithEmailAndPassword(email, password);
    }
}
