package com.example.chatmessenger

import android.annotation.SuppressLint
//conectividad para firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*

class Utils {
    companion object {
        @SuppressLint("StaticFieldLeak")
        val context = MyApplication.instance.applicationContext
        @SuppressLint("StaticFieldLeak")
        val firestore = FirebaseFirestore.getInstance()
        private val auth = FirebaseAuth.getInstance()
        private var userid: String = ""
        const val REQUEST_IMAGE_CAPTURE = 1
        const val REQUEST_IMAGE_PICK = 2
        const val MESSAGE_RIGHT = 1
        const val MESSAGE_LEFT = 2
        const val CHANNEL_ID = "com.example.chatmessenger"
        fun getUidLoggedIn(): String {
            if (auth.currentUser!=null){
                userid = auth.currentUser!!.uid
            }
            return userid
        }
//funcion del tiempo de envio de mensaje
        fun getTime(): String {
            val formatter = SimpleDateFormat("HH:mm:ss")
            val date: Date = Date(System.currentTimeMillis())
            val stringdate = formatter.format(date)
            return stringdate

        }
        //funcion para autentificacion por tokens para iniciar automaticamente
        // no funciona!!!!
//        fun getToken() : String{
//            var returntoken = ""
//            val mysharedPrefs = SharedPrefs(context)
//            val friendid = mysharedPrefs.getValue("friendid")
//            firestore.collection("Tokens").document(friendid!!).get().addOnSuccessListener {document->
//                if (document.exists() && document!=null){
//                    returntoken = document.toObject(Token::class.java).toString()
//                } else {
//                    Log.e("Utils", "TOKEN DOES NOT EXIST")
//                    Toast.makeText(context, "TOKEN DOES NOT EXISTS", Toast.LENGTH_SHORT).show()
//                }
//                Log.e("Utils", "Device token is ${returntoken}")
//            }
//            return returntoken
//        }
//
    }
}