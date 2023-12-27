package com.example.mymemory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mymemory.models.BoardSize
import com.example.mymemory.utils.EXTRA_BOARD_SIZE

class CreateActivity : AppCompatActivity() {

    private lateinit var boardSize: BoardSize
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        boardSize = intent.getSerializableExtra(EXTRA_BOARD_SIZE, BoardSize::class.java)!!
    }
}