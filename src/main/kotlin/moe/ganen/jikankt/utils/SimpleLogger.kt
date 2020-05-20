package moe.ganen.jikankt.utils

import org.slf4j.helpers.MarkerIgnoringBase
import org.slf4j.spi.LocationAwareLogger


class SimpleLogger(name: String) : MarkerIgnoringBase() {

    init {
        this.name = name
    }

    companion object {
        private const val LOG_LEVEL_TRACE = LocationAwareLogger.TRACE_INT
        private const val LOG_LEVEL_DEBUG = LocationAwareLogger.DEBUG_INT
        private const val LOG_LEVEL_INFO = LocationAwareLogger.INFO_INT
        private const val LOG_LEVEL_WARN = LocationAwareLogger.WARN_INT
        private const val LOG_LEVEL_ERROR = LocationAwareLogger.ERROR_INT
    }

    var currentLevel: Int = LOG_LEVEL_INFO

    private fun log(level: Int, message: String, t: Throwable? = null) {
        if (level < currentLevel) return
        val buf = StringBuilder(64)

        buf.append('[')
        buf.append(Thread.currentThread().name)
        buf.append("] [")

        when (level) {
            LOG_LEVEL_TRACE -> buf.append("TRACE")
            LOG_LEVEL_DEBUG -> buf.append("DEBUG")
            LOG_LEVEL_INFO -> buf.append("INFO")
            LOG_LEVEL_WARN -> buf.append("WARN")
            LOG_LEVEL_ERROR -> buf.append("ERROR")
        }
        buf.append("] ")


        val finalName = if (name.contains(".")) {
            val betterNameBuilder = StringBuilder()
            var lastDotPos = -1

            name.forEachIndexed { index, c ->
                if (index == lastDotPos + 1) {
                    betterNameBuilder
                        .append(c)
                        .append('.')
                }
                if (c == '.') lastDotPos = index
            }
            val betterName = betterNameBuilder.toString()
            betterName.take(betterName.length - 1) + name.substring(kotlin.math.max(lastDotPos, 0), name.length)
        } else name
        buf.append(finalName).append(" - ")



        buf.append(message)
        println(buf.toString())
        t?.printStackTrace(System.out)
        System.out.flush()
    }

    override fun warn(msg: String) {
        log(LOG_LEVEL_WARN, msg)
    }

    override fun warn(format: String, arg: Any?) {
        log(LOG_LEVEL_WARN, format.format(arg))
    }

    override fun warn(format: String, vararg arguments: Any?) {
        log(LOG_LEVEL_WARN, format.format(arguments))
    }

    override fun warn(format: String, arg1: Any?, arg2: Any?) {
        log(LOG_LEVEL_WARN, format.format(arg1, arg2))
    }

    override fun warn(msg: String, t: Throwable?) {
        log(LOG_LEVEL_WARN, msg, t)
    }

    override fun info(msg: String) {
        log(LOG_LEVEL_INFO, msg)
    }

    override fun info(format: String, arg: Any?) {
        log(LOG_LEVEL_INFO, format.format(arg))
    }

    override fun info(format: String, arg1: Any?, arg2: Any?) {
        log(LOG_LEVEL_INFO, format.format(arg1, arg2))
    }

    override fun info(format: String, vararg arguments: Any?) {
        log(LOG_LEVEL_INFO, format.format(arguments))
    }

    override fun info(msg: String, t: Throwable?) {
        log(LOG_LEVEL_INFO, msg, t)
    }

    override fun isErrorEnabled(): Boolean = currentLevel <= LOG_LEVEL_ERROR

    override fun error(msg: String) {
        log(LOG_LEVEL_ERROR, msg)
    }

    override fun error(format: String, arg: Any?) {
        log(LOG_LEVEL_ERROR, format.format(arg))
    }

    override fun error(format: String, arg1: Any?, arg2: Any?) {
        log(LOG_LEVEL_ERROR, format.format(arg1, arg2))
    }

    override fun error(format: String, vararg arguments: Any?) {
        log(LOG_LEVEL_ERROR, format.format(arguments))
    }

    override fun error(msg: String, t: Throwable?) {
        log(LOG_LEVEL_ERROR, msg, t)
    }

    override fun isDebugEnabled(): Boolean = currentLevel <= LOG_LEVEL_DEBUG

    override fun debug(msg: String) {
        log(LOG_LEVEL_DEBUG, msg)
    }

    override fun debug(format: String, arg: Any?) {
        log(LOG_LEVEL_DEBUG, format.format(arg))
    }

    override fun debug(format: String, arg1: Any?, arg2: Any?) {
        log(LOG_LEVEL_DEBUG, format.format(arg1, arg2))
    }

    override fun debug(format: String, vararg arguments: Any?) {
        log(LOG_LEVEL_DEBUG, format.format(arguments))
    }

    override fun debug(msg: String, t: Throwable?) {
        log(LOG_LEVEL_DEBUG, msg, t)
    }

    override fun isInfoEnabled(): Boolean = currentLevel <= LOG_LEVEL_INFO

    override fun trace(msg: String) {
        log(LOG_LEVEL_TRACE, msg)
    }

    override fun trace(format: String, arg: Any?) {
        log(LOG_LEVEL_TRACE, format.format(arg))
    }

    override fun trace(format: String, arg1: Any?, arg2: Any?) {
        log(LOG_LEVEL_TRACE, format.format(arg1, arg2))
    }

    override fun trace(format: String, vararg arguments: Any?) {
        log(LOG_LEVEL_TRACE, format.format(arguments))
    }

    override fun trace(msg: String, t: Throwable?) {
        log(LOG_LEVEL_TRACE, msg, t)
    }

    override fun isWarnEnabled(): Boolean = currentLevel <= LOG_LEVEL_WARN

    override fun isTraceEnabled(): Boolean = currentLevel <= LOG_LEVEL_TRACE
}