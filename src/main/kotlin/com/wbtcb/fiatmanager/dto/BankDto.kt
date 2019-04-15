package com.wbtcb.fiatmanager.dto

import java.io.Serializable

data class BankDto constructor(
    var id: Integer,
    var code: String,
    var name: String
) : Serializable
