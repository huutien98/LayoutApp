package com.vncoder.layoutapp.Model

import java.net.IDN


class MessengerObject(){
    var id: Int = 0
    lateinit var name: String
    lateinit var messenger: String
    lateinit var time: String
    var number:Int = 0
    var avatar: Int = 0
    
    constructor(
        id: Int,
        name: String,
        messenger: String,
        time: String,
        number: Int,
        avatar:Int

    ):this(){
        this.id=id
        this.name=name
        this.messenger = messenger
        this.time = time
        this.number = number
        this.avatar = avatar

}
}
