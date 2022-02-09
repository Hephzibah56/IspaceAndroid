package com.example.fetchstaticdata.ui

import android.content.Context

class FileHelper {

companion object {
    fun getTextFromResources(context: Context, resourceId: Int): String {
        return context.resources.openRawResource(resourceId).use {
            it.bufferedReader().use {
                it.readText()
            }
        }
    }
}
}