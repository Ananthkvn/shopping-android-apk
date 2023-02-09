package com.example.shopping.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shopping.data.db.entities.ShoppingItem


@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem):Long

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}