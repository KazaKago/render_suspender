package com.kazakago.render.suspender

import com.typesafe.config.ConfigFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.internal.EMPTY_REQUEST
import org.json.JSONObject

fun main(args: Array<String>) {
    val conf = ConfigFactory.load()
    val accessToken = conf.getString("render.token")
    val serviceIds = conf.getString("render.service.ids").filterNot { it.isWhitespace() }.split(",")
    serviceIds.forEach { if (!isSuspend(accessToken, it)) suspend(accessToken, it) }
}

private fun isSuspend(accessToken: String, serviceId: String): Boolean {
    val url = "https://api.render.com/v1/services/$serviceId"
    val client = OkHttpClient()
    val request = Request.Builder()
        .url(url)
        .get()
        .addHeader("Accept", "application/json")
        .addHeader("Authorization", "Bearer $accessToken")
        .build()
    val response = client.newCall(request).execute()
    val json = JSONObject(response.body?.string())
    val suspended = json.getString("suspended")
    return (suspended == "suspended")
}

private fun suspend(accessToken: String, serviceId: String) {
    val url = "https://api.render.com/v1/services/$serviceId/suspend"
    val client = OkHttpClient()
    val request = Request.Builder()
        .url(url)
        .post(EMPTY_REQUEST)
        .addHeader("Accept", "application/json")
        .addHeader("Authorization", "Bearer $accessToken")
        .build()
    val response = client.newCall(request).execute()
    if (!response.isSuccessful) throw IllegalStateException()
}
