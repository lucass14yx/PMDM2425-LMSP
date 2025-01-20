package com.maestre.wisdompills.Model

import android.provider.ContactsContract.CommonDataKinds.Nickname

data class User(var idUser: String? = null,
                var nickname: Nickname,
                var password: String? = null)