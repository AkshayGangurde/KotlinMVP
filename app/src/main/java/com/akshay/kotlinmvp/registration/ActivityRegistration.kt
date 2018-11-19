package com.akshay.kotlinmvp.registration

import android.content.Context
import android.os.Bundle
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.akshay.kotlinmvp.R
import kotlinx.android.synthetic.main.activity_registration.*

class ActivityRegistration : AppCompatActivity(), ContractRegistration.View {

    //reference variable for calling methods in Presenter
    private lateinit var mPresenter: ContractRegistration.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        PresenterRegistration(this)

        buttonRegister.setOnClickListener {
            register()
        }
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun setPresenter(presenter: ContractRegistration.Presenter) {
        this.mPresenter = presenter
    }

    private fun register() {
        //calling presenter method for creating user
        mPresenter.createUser(editTextFirstName.text.toString(), editTextLastName.text.toString(), editTextMobileNumber.text.toString(),
                editTextEmailId.text.toString(), editTextPassword.text.toString())
    }
}