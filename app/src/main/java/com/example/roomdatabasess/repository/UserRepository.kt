package com.example.roomdatabasess.repository

import androidx.lifecycle.LiveData
import com.example.roomdatabasess.data.UserDao
import com.example.roomdatabasess.model.User

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }
}