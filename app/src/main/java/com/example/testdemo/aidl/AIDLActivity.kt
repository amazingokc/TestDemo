package com.example.testdemo.aidl

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.view.View.OnClickListener
import com.example.dagger2demo.ConnectAidl
import com.example.test.R
import kotlinx.android.synthetic.main.activity_aidl.*

class AIDLActivity : AppCompatActivity() {

    lateinit var connectAidl: ConnectAidl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aidl)

        val intent = Intent(this, AIDLService::class.java)

        bindService(intent, object : ServiceConnection {
            override fun onServiceDisconnected(name: ComponentName?) {

            }

            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                connectAidl = ConnectAidl.Stub.asInterface(service)
            }
        }, Service.BIND_AUTO_CREATE)

        btn_connect.setOnClickListener(object : OnClickListener {
            override fun onClick(v: View?) {
                connectAidl.connect()

            }
        })

        btn_disconnect.setOnClickListener(object : OnClickListener {
            override fun onClick(v: View?) {
                connectAidl.disConnect()
            }
        })

        btn_isconnect.setOnClickListener(object : OnClickListener {
            override fun onClick(v: View?) {
                connectAidl.isConnect
            }
        })


    }


}
