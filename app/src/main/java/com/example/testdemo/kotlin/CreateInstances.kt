package com.example.testdemo.kotlin

/**
 * 作者：xiaoguoqing
 * 创建时间：2019-10-18 下午 5:17
 * 文件描述：
 *
 */
class CreateInstances private constructor(){

    fun callMethod() {
        val instance1 = getInstance()

        val instance2 = Second.getInstance()

        val instance3 = Third.getInstance()
    }

    companion object {
        fun getInstance(): CreateInstances {
            return CreateInstances()
        }
    }

    object Second {
        fun getInstance(): CreateInstances {
            return CreateInstances()
        }
    }

    class Third {
        companion object {
            fun getInstance() {

            }
        }
    }
}