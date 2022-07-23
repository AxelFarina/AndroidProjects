package com.cursosandroidant.snapshots

import android.app.Application
import com.google.firebase.auth.FirebaseUser

/****
 * Project: Snapshots
 * From: com.cursosant.android.snapshots
 * Created by Alain Nicolás Tello on 12/26/20 at 2:52 PM
 * Course: Android Practical with Kotlin from zero.
 * All rights reserved 2021.
 *
 * All my Courses(Only on Udemy):
 * https://www.udemy.com/user/alain-nicolas-tello/
 ***/
class SnapshotsApplication : Application() {
    companion object {
        const val PATH_SNAPSHOTS = "snapshots"
        const val PROPERTY_LIKE_LIST = "likeList"

        lateinit var currentUser: FirebaseUser
    }
}