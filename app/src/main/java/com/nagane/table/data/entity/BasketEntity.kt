package com.nagane.table.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

// 장바구니 entity
@Entity(tableName = "Basket",
    indices = [Index(value = ["menuNo"], unique = true)])
data class BasketEntity(
    // 장바구니 번호(pk)
    @ColumnInfo(name = "basketNo")
    @PrimaryKey(autoGenerate = true)
    var basketNo : Int,
    // 메뉴 번호(pk)
    @ColumnInfo(name = "menuNo")
    var menuNo : Long,
    // 메뉴 이름
    @ColumnInfo(name = "menuName")
    var menuName : String,
    // 메뉴 선택 수
    @ColumnInfo(
        name = "quantity",
        defaultValue = "1")
    var quantity : Int = 1,
)
