package com.lhdream.util

/**
 * 数据库类型与java互转
 */
object DBTypeToJavaUtil {

    fun trun(dbType:String):String{
        return when(dbType){
            "" -> "a"
            else -> "Object"
        }
    }

}