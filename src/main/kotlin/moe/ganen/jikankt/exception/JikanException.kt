package moe.ganen.jikankt.exception

open class JikanException(override val message: String?, val code: Int? = null) : Exception()