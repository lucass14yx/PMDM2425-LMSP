package com.maestre.wisdompills.Model.persistence

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.maestre.wisdompills.Model.User

class UserRepository {
    private var databaseReference: DatabaseReference
    init {
        databaseReference = FirebaseDatabase.getInstance("https://fir-example-fc9e4-default-rtdb.europe-west1.firebasedatabase.app/").reference
    }

    fun addUser(user: User) {
        val key = databaseReference.child("users").push().key
        user.idUser = key
        databaseReference.child("users").child(key!!).setValue(user)
    }

    fun getUser(nickname: String): User {
        val users = MutableLiveData<List<User>>()
        val user = User()

        // Cada vez que los datos cambien, se llamará al evento onDataChange con la nueva lista de datos
        val firebaseDataListener = FirebaseDataListenerUser(users)
        databaseReference.child("users").addValueEventListener(firebaseDataListener)
        for(u in users.value!!){
            if(u.nickname == nickname){
                user.idUser = u.idUser
                user.nickname = u.nickname
                user.password = u.password
                user.email = u.email
                user.birthdate = u.birthdate
            }
        }

        return user
    }
}