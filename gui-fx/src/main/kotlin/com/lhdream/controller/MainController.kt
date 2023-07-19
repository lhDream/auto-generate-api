package com.lhdream.controller

import com.lhdream.util.CodeUtil
import com.lhdream.util.DBUtil
import tornadofx.*

/**
 * 主界面业务实现
 */
class MainController: Controller() {
    /**
     * 确认，根据模板生成文件
     */
    fun enter(ip:String,port:String,username:String,password:String,dbName:String,groupId:String,tablePrefix:String,savePath:String){
        val tableInfos = DBUtil.getTableInfos(ip, port, username, password, dbName, tablePrefix)
        if(tableInfos.isEmpty()){
            throw RuntimeException("获取表数量为 0")
        }
        CodeUtil.createCode(tableInfos,groupId, savePath)
    }

}