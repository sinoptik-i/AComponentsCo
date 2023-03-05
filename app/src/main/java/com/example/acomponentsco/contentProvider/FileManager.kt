package com.example.acomponentsco.contentProvider

import android.net.Uri
import android.os.Environment
import android.util.Log
import java.io.File

class FileManager {

    val path = Environment.getExternalStoragePublicDirectory(
        Environment.DIRECTORY_DOWNLOADS
    ).path

    fun getMusicUri(
        musicPath: String = path
    ): List<Uri>? {

        val directory = File(musicPath)
        val uriList = File(directory.toString()).listFiles()?.map {
            Uri.fromFile(it)
        }
        return uriList
    }
}