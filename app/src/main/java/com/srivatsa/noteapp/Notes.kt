package com.srivatsa.noteapp

import io.realm.Realm
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Notes (
    //unique key so primary
    @PrimaryKey
    var id:Int?=null,
    var title:String?=null,
    var description:String?=null

):RealmObject()