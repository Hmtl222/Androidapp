package com.example.androidapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Включаем поддержку edge-to-edge
        setContentView(R.layout.activity_main)

        // Обработка изменения отступов для системы (например, статус-бар)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Инициализация элементов
        val main: TextView = findViewById(R.id.main)
        val userData: EditText = findViewById(R.id.userData)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val text = userData.text.toString().trim()

            // Проверка на пустой ввод
            if (text.isEmpty()) {
                Toast.makeText(this, "Пожалуйста, введите текст", Toast.LENGTH_SHORT).show()
            } else if (text.equals("toast", ignoreCase = true)) {
                Toast.makeText(this, "Вы ввели 'toast'", Toast.LENGTH_SHORT).show()
            } else {
                main.text = text
            }
        }
    }
}
