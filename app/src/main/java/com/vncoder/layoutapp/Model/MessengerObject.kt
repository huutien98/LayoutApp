package com.vncoder.layoutapp.Model


class MessengerObject(){
    lateinit var name: String
    lateinit var messenger: String
    lateinit var time: String
    var number:Int = 0
    var avatar: Int = 0


    constructor(
        name: String,
        messenger: String,
        time: String,
        number: Int
    ):this(){
        this.name=name
        this.messenger = messenger
        this.time = time
        this.number = number
        this.avatar = avatar

}}
