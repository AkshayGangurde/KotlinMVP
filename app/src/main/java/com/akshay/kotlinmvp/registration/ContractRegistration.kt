package com.akshay.kotlinmvp.registration

import android.widget.Toast
import com.akshay.kotlinmvp.BasePresenter
import com.akshay.kotlinmvp.BaseView

interface ContractRegistration {


    //interface will be implemented by View
    interface View : BaseView<Presenter> {
        abstract fun showToast(first_name: String)
    }

    //interface will be implemented by Presenter
    interface Presenter : BasePresenter {
        fun createUser(firstName: String, password: String, emailAddress: String, mobileNumber: String, lastName: String) {
            //logic for creating new user
        }
    }

}