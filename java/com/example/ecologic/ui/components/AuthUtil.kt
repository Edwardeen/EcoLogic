package com.example.ecologic.ui.components

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

//object AuthUtil {
//
//    private val auth = FirebaseAuth.getInstance()
//
//    fun registerUser(email: String, password: String, username: String, callback: (Boolean) -> Unit) {
//        auth.createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    val user = auth.currentUser
//                    val profileUpdates =  UserProfileChangeRequest.Builder()
//                        .setDisplayName(username)
//                        .build()
//
//                    user?.updateProfile(profileUpdates)
//                        ?.addOnCompleteListener { profileUpdateTask ->
//                            callback(profileUpdateTask.isSuccessful)
//                        }
//                } else {
//                    callback(false)
//                }
//            }
//    }
object AuthUtil {

    private val auth = FirebaseAuth.getInstance()

    fun registerUser(
        email: String,
        password: String,
        username: String,
        onComplete: (success: Boolean, errorMessage: String?) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onComplete(true, null)
                } else {
                    onComplete(false, task.exception?.message)
                }
            }
    }
}
