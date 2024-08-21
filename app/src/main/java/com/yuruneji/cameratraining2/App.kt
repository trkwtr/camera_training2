package com.yuruneji.cameratraining2

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import com.yuruneji.cameratraining2.domain.usecase.LogFile
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

/**
 * @author toru
 * @version 1.0
 */
@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var logFile: LogFile

    override fun onCreate() {
        super.onCreate()

        // Timber.plant(Timber.DebugTree())
        Timber.plant(LogTree(context = this, logFile = logFile))

        // App.appContext=applicationContext
    }

    init {
        // instance = this
    }

    // companion object {
    //     // var instance: App? = null
    //
    //     // fun appContext(): Context {
    //     //     return instance!!.applicationContext
    //     // }
    //
    //     lateinit var appContext: Context
    //
    // }
    class LogTree(private val context: Context, private val logFile: LogFile) : Timber.DebugTree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            logFile.postLog(context, priority, tag, message, t)
        }
    }
}
