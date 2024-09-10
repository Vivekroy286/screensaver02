package com.example.screensaver2

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView: ImageView = findViewById(R.id.screensaverImageView)

        // Get Firebase Storage reference
        val storageRef: StorageReference = FirebaseStorage.getInstance().reference
        val imageRef = storageRef.child("ben-grayland-vgER7ts0AmU-unsplash - Copy.jpg")

        imageRef.downloadUrl.addOnSuccessListener { uri ->
            // Load the image into the ImageView
            Picasso.get().load(uri).into(imageView)
        }.addOnFailureListener {
            // Handle any errors
        }
    }
}