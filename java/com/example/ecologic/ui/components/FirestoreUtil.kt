package com.example.ecologic.ui.components

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

object FirestoreUtil {

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

    fun addUserToFirestore(username: String) {
        val user = auth.currentUser

        user?.let {
            val userData = hashMapOf(
                "uid" to it.uid,
                "email" to it.email,
                "username" to username,
                // Add other fields as needed
            )

            db.collection("users")
                .document(it.uid)
                .set(userData)
                .addOnSuccessListener {
                    // User data added to Firestore successfully
                }
                .addOnFailureListener { e ->
                    // Handle the failure to add user data to Firestore
                }
        }
    }

    // Add other Firestore-related methods as needed
}