package com.lhdream.util

import TableInfo
import kotlin.reflect.KType
import kotlin.reflect.full.valueParameters

/**
 * 模板工具类
 */
object FreeMarkerUtil {



}

fun main() {
    val tableInfoValueParams = ::TableInfo.valueParameters
    for (tableInfoValueParam in tableInfoValueParams) {
        println("type: ${tableInfoValueParam.type} ${tableInfoValueParam.type}")

    }
}