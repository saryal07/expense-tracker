package com.example.expensetracker.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {
    @Insert suspend fun insertExpense(expense: Expense)

    @Query("SELECT * FROM expenses ORDER BY date DESC")
    fun getAllExpenses(): Flow<List<Expense>>

    @Query("SELECT SUM(amount) FROM expenses WHERE category = :category")
    suspend fun getTotalByCategory(category: String): Double
}
