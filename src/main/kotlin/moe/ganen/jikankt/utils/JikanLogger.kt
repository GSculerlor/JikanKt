package moe.ganen.jikankt.utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class JikanLogger {
    /**
     * Marks whether or not a SLF4J `StaticLoggerBinder` (pre 1.8.x) or
     * `SLF4JServiceProvider` implementation (1.8.x+) was found. If false, JDA will use its fallback logger.
     * <br></br>This variable is initialized during static class initialization.
     */

    companion object {
        var SLF4J_ENABLED = false
        private val LOGS: MutableMap<String, Logger> = mutableMapOf()

        init {
            var tmp: Boolean

            try {
                Class.forName("org.slf4j.impl.StaticLoggerBinder")

                tmp = true
            } catch (eStatic: ClassNotFoundException) {
                // there was no static logger binder (SLF4J pre-1.8.x)

                tmp = try {
                    val serviceProviderInterface: Class<*> = Class.forName("org.slf4j.spi.SLF4JServiceProvider")

                    // check if there is a service implementation for the service, indicating a provider for SLF4J 1.8.x+ is installed
                    ServiceLoader.load(serviceProviderInterface).iterator().hasNext()
                } catch (eService: ClassNotFoundException) {
                    // there was no service provider interface (SLF4J 1.8.x+)

                    //prints warning of missing implementation
                    LoggerFactory.getLogger(JikanLogger::class.java)

                    false
                }
            }

            SLF4J_ENABLED = tmp

        }
    }


    /**
     * Will get the [org.slf4j.Logger] with the given log-name
     * or create and cache a fallback logger if there is no SLF4J implementation present.
     *
     *
     * The fallback logger will be an instance of a slightly modified version of SLF4Js SimpleLogger.
     *
     * @param  name
     * The name of the Logger
     *
     * @return Logger with given log name
     */
    fun getLog(name: String): Logger {
        synchronized(LOGS) {
            return if (SLF4J_ENABLED) {
                LoggerFactory.getLogger(name)
            } else {
                LOGS.computeIfAbsent(
                    name
                ) { SimpleLogger(name) }
            }
        }
    }

    /**
     * Will get the [org.slf4j.Logger] for the given Class
     * or create and cache a fallback logger if there is no SLF4J implementation present.
     *
     *
     * The fallback logger will be an instance of a slightly modified version of SLF4Js SimpleLogger.
     *
     * @param  clazz
     * The class used for the Logger name
     *
     * @return Logger for given Class
     */
    fun getLog(clazz: Class<*>): Logger {
        synchronized(LOGS) {
            return if (SLF4J_ENABLED) {
                LoggerFactory.getLogger(clazz)
            } else {
                LOGS.computeIfAbsent(
                    clazz.name
                ) {
                    SimpleLogger(clazz.simpleName)
                }
            }
        }
    }
}