package com.akshay.kotlinmvp.registration

import com.akshay.kotlinmvp.APIServices
import com.akshay.kotlinmvp.Result
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class PresenterRegistration(private val view: ContractRegistration.View) : ContractRegistration.Presenter {

    // instance of interface created for Retrofit API calls
    val apiService by lazy {
        //initializing Retrofit stuff
        APIServices.create()
    }

    //Rx Java object that tracks fetching activity
    var disposable: Disposable? = null

    init {
        //supplying presenter instance to view.
        this.view.setPresenter(this)
    }

    override fun start() {
    }

    override fun createUser(firstName: String, password: String, emailAddress: String, mobileNumber: String, lastName: String) {
        disposable = apiService.createUser(firstName, lastName, mobileNumber, emailAddress, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> showResult(result) },
                        { error ->
                            error.printStackTrace()
                            showError(error.message.toString())
                        }
                )
    }

    private fun showResult(result: Result.Registration) {
        if (!result.error) {
            view.showToast(result.data.first_name)
        } else {
            view.showToast("error")
        }
    }

    private fun showError(error: String) {
        view.showToast(error)
    }
}