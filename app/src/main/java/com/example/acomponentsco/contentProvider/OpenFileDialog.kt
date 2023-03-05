package com.example.acomponentsco.contentProvider

import android.app.AlertDialog
import android.content.Context

class OpenFileDialog(context: Context) : AlertDialog.Builder(context) {

    init {
        setPositiveButton("Ok", null)
            .setNegativeButton("Cancel", null)
    }
}