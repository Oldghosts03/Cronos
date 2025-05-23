package com.example.cronos.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Entidades=Tablas,atributo=campo
@Entity(tableName = "cronos")
data class Cronos(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "title")
    val title:String,
    @ColumnInfo(name = "crono")
    val crono: Long
)
