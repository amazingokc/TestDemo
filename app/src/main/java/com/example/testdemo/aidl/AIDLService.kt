package com.example.testdemo.aidl

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Handler
import android.os.IBinder
import android.widget.Toast
import com.example.dagger2demo.ConnectAidl
import com.example.dagger2demo.ConnectAidl.Stub

class AIDLService : Service() {

    private var isConnect = false
    private lateinit var handler: Handler

    override fun onCreate() {
        super.onCreate()
        handler = Handler()
    }

    override fun onBind(intent: Intent): IBinder {
        return connectAidl.asBinder()
    }

    private val connectAidl = object : Stub() {
        override fun connect() {
            this@AIDLService.isConnect = true
            handler.post { Toast.makeText(this@AIDLService, "connect", Toast.LENGTH_SHORT).show() }
        }

        override fun disConnect() {
            this@AIDLService.isConnect = false
            handler.post { Toast.makeText(this@AIDLService, "disConnect", Toast.LENGTH_SHORT).show() }
        }

        override fun isConnect(): Boolean {
            handler.post {
                Toast.makeText(this@AIDLService, this@AIDLService.isConnect.toString(),
                        Toast.LENGTH_SHORT).show()
            }
            return this@AIDLService.isConnect
        }
    }


}
