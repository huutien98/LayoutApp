package com.vncoder.layoutapp.Model

import java.io.Serializable

class HomeObject(
    var id: Int,
    var avatar: Int,
    var image: Int,
    var name: String,
    var status: String,
    var time: String,
    var pay: Int
): Serializable