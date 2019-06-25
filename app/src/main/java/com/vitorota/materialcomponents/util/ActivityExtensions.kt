package com.vitorota.materialcomponents.util

import android.app.Activity
import android.widget.Toast

fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}