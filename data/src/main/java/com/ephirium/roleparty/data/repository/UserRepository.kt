package com.ephirium.roleparty.data.repository

import com.ephirium.roleparty.common.OnExceptionListener
import com.ephirium.roleparty.common.OnReceiveListener
import com.ephirium.roleparty.common.OnSuccessListener
import com.ephirium.roleparty.data.model.UserDto
import com.ephirium.roleparty.data.storage.Collection
import com.ephirium.roleparty.domain.dtobase.UserDtoBase
import com.ephirium.roleparty.domain.repositorybase.UserRepositoryBase
import com.google.firebase.firestore.FirebaseFirestore

class UserRepository: UserRepositoryBase {
    private val firestore = FirebaseFirestore.getInstance()
    private val users = firestore.collection(Collection.Users.path)

    override fun loadUserById(
        id: kotlin.String,
        onReceiveListener: OnReceiveListener<UserDtoBase>,
        onExceptionListener: OnExceptionListener,
    ) {
        users.document(id).addSnapshotListener { value, error ->
            try {
                onReceiveListener(value!!.toObject(UserDto::class.java)!!)
            } catch (e: Exception) {
                onExceptionListener(e)
            }
            error?.let(onExceptionListener)
        }
    }

    override fun saveUser(
        user: UserDtoBase,
        onSuccessListener: OnSuccessListener,
        onExceptionListener: OnExceptionListener,
    ) {
        
        users.document(user.id).set(
            hashSetOf(
                user.email to "email", user.login to "login", user.threads to "threads"
            )
        ).addOnSuccessListener { onSuccessListener() }.addOnFailureListener {
            onExceptionListener(it)
        }
    }
}