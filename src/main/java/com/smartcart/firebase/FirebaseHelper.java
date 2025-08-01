package com.smartcart.firebase;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.smartcart.data.ItemEntity;
import com.smartcart.data.ListEntity;

import com.google.android.gms.tasks.OnCompleteListener;

public class FirebaseHelper {
    private final FirebaseAuth auth = FirebaseAuth.getInstance();
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();

    public void signIn(String email, String password, OnCompleteListener<AuthResult> listener) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(listener);
    }

    public void uploadList(ListEntity list) {
        db.collection("lists").document(String.valueOf(list.listId)).set(list);
    }

    public void uploadItem(ItemEntity item) {
        db.collection("items").document(String.valueOf(item.itemId)).set(item);
    }
}