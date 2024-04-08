package com.shashank.sony.fancytoastlib

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.IntDef
import androidx.annotation.NonNull
import com.example.toastlibrary.R

class FancyToast(context: Context) : Toast(context) {

    companion object {
        const val SUCCESS = 1
        const val WARNING = 2
        const val ERROR = 3
        const val INFO = 4
        const val DEFAULT = 5
        const val CONFUSING = 6

        const val LENGTH_SHORT = Toast.LENGTH_SHORT
        const val LENGTH_LONG = Toast.LENGTH_LONG
    }

    @Retention(AnnotationRetention.SOURCE)
    @IntDef(SUCCESS, WARNING, ERROR, INFO, DEFAULT, CONFUSING)
    annotation class LayoutType

    @Retention(AnnotationRetention.SOURCE)
    annotation class Duration

    init {
        setDuration(Toast.LENGTH_SHORT)
    }

    fun makeText(
        context: Context,
        message: CharSequence?,
        duration: Int,
        @LayoutType type: Int,
        androidIcon: Boolean
    ): Toast {
        val toast = Toast(context)
        toast.duration = duration
        val layout: View =
            LayoutInflater.from(context).inflate(R.layout.activity_stylish_toast, null, false)
        val l1 = layout.findViewById<TextView>(R.id.toast_text)
        val linearLayout = layout.findViewById<LinearLayout>(R.id.toast_type)
        val img = layout.findViewById<ImageView>(R.id.toast_icon)
        val img1 = layout.findViewById<ImageView>(R.id.imageView4)
        l1.text = message
        if (androidIcon) img1.visibility = View.VISIBLE else img1.visibility = View.GONE
        when (type) {
            SUCCESS -> {
                linearLayout.setBackgroundResource(R.drawable.icon_successfull)
                img.setImageResource(R.drawable.ic_check_black_24dp)
            }
            WARNING -> {
                linearLayout.setBackgroundResource(R.drawable.warning_shape)
                img.setImageResource(R.drawable.ic_pan_tool_black_24dp)
            }
            ERROR -> {
                linearLayout.setBackgroundResource(R.drawable.icon_error)
                img.setImageResource(R.drawable.ic_clear_black_24dp)
            }
            INFO -> {
                linearLayout.setBackgroundResource(R.drawable.info_shape)
                img.setImageResource(R.drawable.ic_info_outline_black_24dp)
            }
            DEFAULT -> {
                linearLayout.setBackgroundResource(R.drawable.default_shape)
                img.visibility = View.GONE
            }
            CONFUSING -> {
                linearLayout.setBackgroundResource(R.drawable.confusing_shape)
                img.setImageResource(R.drawable.ic_refresh_black_24dp)
            }
        }
        toast.view = layout
        return toast
    }

    fun makeText(
        context: Context,
        message: CharSequence?,
        duration: Int,
        @LayoutType type: Int,
        @DrawableRes ImageResource: Int,
        androidIcon: Boolean
    ): Toast {
        val toast = Toast(context)
        toast.duration = duration
        val layout: View =
            LayoutInflater.from(context).inflate(R.layout.activity_stylish_toast, null, false)
        val l1 = layout.findViewById<TextView>(R.id.toast_text)
        val linearLayout = layout.findViewById<LinearLayout>(R.id.toast_type)
        val img = layout.findViewById<ImageView>(R.id.toast_icon)
        val img1 = layout.findViewById<ImageView>(R.id.imageView4)
        l1.text = message
        img.setImageResource(ImageResource)
        if (androidIcon) img1.visibility = View.VISIBLE else img1.visibility = View.GONE
        when (type) {
            SUCCESS -> linearLayout.setBackgroundResource(R.drawable.icon_successfull)
            WARNING -> linearLayout.setBackgroundResource(R.drawable.icon_warning)
            ERROR -> linearLayout.setBackgroundResource(R.drawable.icon_error)
            INFO -> linearLayout.setBackgroundResource(R.drawable.info_toast_background)
            DEFAULT -> {
                linearLayout.setBackgroundResource(R.drawable.default_shape)
                img.visibility = View.GONE
            }
            CONFUSING -> linearLayout.setBackgroundResource(R.drawable.confusing_shape)
            else -> {
                linearLayout.setBackgroundResource(R.drawable.default_shape)
                img.visibility = View.GONE
            }
        }
        toast.view = layout
        return toast
    }
}
