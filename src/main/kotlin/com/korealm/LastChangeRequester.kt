package com.korealm

data class LastChangeRequester(var state: Status) {
    enum class Status {
        USER_MADE,
        SYSTEM_MADE
    }
}