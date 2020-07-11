package com.example.testdemo.retrofit.exception

import android.net.ParseException
import com.google.gson.JsonParseException
import com.google.gson.stream.MalformedJsonException
import org.apache.http.conn.ConnectTimeoutException
import org.json.JSONException
import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLException

/**
 * Create by: xiaoguoqing
 * Date: 2018/12/27 0027
 * description: http异常处理
 */
object ExceptionHandle {
    private const val BAD_REQUEST = 400
    private const val UNAUTHORIZED = 401
    private const val FORBIDDEN = 403
    private const val NOT_FOUND = 404
    private const val REQUEST_TIMEOUT = 408
    private const val INTERNAL_SERVER_ERROR = 500
    private const val SERVICE_UNAVAILABLE = 503
    fun handleException(e: Throwable): ResponseThrowable {
        val ex: ResponseThrowable
        return if (e is HttpException) {
            val httpException = e
            ex = ResponseThrowable(e.message, ERROR.HTTP_ERROR)
            when (httpException.code()) {
                BAD_REQUEST -> ex.message = "错误请求" + httpException.code()
                UNAUTHORIZED -> ex.message = "操作未授权" + httpException.code()
                FORBIDDEN -> ex.message = "请求被拒绝" + httpException.code()
                NOT_FOUND -> ex.message = "资源不存在" + httpException.code()
                REQUEST_TIMEOUT -> ex.message = "服务器执行超时" + httpException.code()
                INTERNAL_SERVER_ERROR -> ex.message = "服务器内部错误" + httpException.code()
                SERVICE_UNAVAILABLE -> ex.message = "服务器不可用" + httpException.code()
                else -> ex.message = "网络错误" + httpException.code()
            }
            ex
        } else if (e is JsonParseException
                || e is JSONException
                || e is ParseException
                || e is MalformedJsonException
                || e is NullPointerException) {
            ex = ResponseThrowable("数据解析错误" + "(" + e.message + ")", ERROR.PARSE_ERROR)
            ex
        } else if (e is ConnectException) {
            ex = ResponseThrowable("连接失败，请重新进入页面", ERROR.NETWORD_ERROR)
            ex
        } else if (e is SSLException) {
            ex = ResponseThrowable("证书验证失败", ERROR.SSL_ERROR)
            ex
        } else if (e is ConnectTimeoutException) {
            ex = ResponseThrowable("连接超时，请检查网络情况", ERROR.TIMEOUT_ERROR)
            ex
        } else if (e is SocketTimeoutException) {
            ex = ResponseThrowable("连接超时，请检查网络情况", ERROR.TIMEOUT_ERROR)
            ex
        } else if (e is UnknownHostException) {
            ex = ResponseThrowable("主机地址未知，请检查网络情况", ERROR.TIMEOUT_ERROR)
            ex
        } else if (e is ResponseThrowable) {
            e
        } else if (e is IOException) {
            ex = ResponseThrowable("当前网络不可用，请更换网络或检测网络状态", ERROR.TIMEOUT_ERROR)
            ex
        } else {
            ex = ResponseThrowable("(" + e.message + ")", ERROR.UNKNOWN)
            ex
        }
    }

    /**
     * 约定异常 这个具体规则需要与服务端或者领导商讨定义
     */
    object ERROR {
        /**
         * 未知错误
         */
        const val UNKNOWN = 1000
        /**
         * 解析错误
         */
        const val PARSE_ERROR = 1001
        /**
         * 网络错误
         */
        const val NETWORD_ERROR = 1002
        /**
         * 协议出错
         */
        const val HTTP_ERROR = 1003
        /**
         * 证书出错
         */
        const val SSL_ERROR = 1005
        /**
         * 连接超时
         */
        const val TIMEOUT_ERROR = 1006
        const val NETWORK_DISABLE = 1007
    }
}