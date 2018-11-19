package com.akshay.kotlinmvp

class Result {
    data class Registration(val error: Boolean, val data: Data)

    data class Data(val first_name: String, val last_name: String,
                    val email_address: String, val mobile_number: String,
                    val updated_at: String, val created_at: String, val id: String)
}