package com.example.roomdatabasess.fragments.update

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.roomdatabasess.R
import com.example.roomdatabasess.model.User
import com.example.roomdatabasess.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.etUpdateFirstName.setText(args.currentUser.firstName)
        view.etUpdateLastName.setText(args.currentUser.lastName)
        view.etUpdateAge.setText(args.currentUser.age.toString())

        view.btnUpdate.setOnClickListener {

        }
        return view
    }

    fun updateUser(){
        val firstName = etUpdateFirstName.text.toString()
        val lastName = etUpdateLastName.text.toString()
        val age = Integer.parseInt(etUpdateAge.text.toString())

        if (inputCheck(firstName, lastName, etUpdateAge.text)){
            val updatedUser = User(args.currentUser.id, firstName, lastName, age)
            mUserViewModel.updateUser(updatedUser)
            findNavController().navigate(R.id.action_updateFragment_to_listFragment2)
        }
    }

    private fun inputCheck(firstName:String, lastName:String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }

}