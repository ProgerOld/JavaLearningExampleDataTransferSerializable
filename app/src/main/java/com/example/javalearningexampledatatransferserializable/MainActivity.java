package com.example.javalearningexampledatatransferserializable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nameIn; //Поле имя
    private EditText addressIn; //Поле адреса
    private EditText emailIn; //Поле электронного адреса
    private Button button; //Поле кнопки

    private String name; //поле хранения имени
    private String address; //поле хранения адреса
    private String email; //поле хранения почты

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Привязка к полям
        nameIn = findViewById(R.id.nameIn);
        addressIn = findViewById(R.id.addressIn);
        emailIn = findViewById(R.id.emailIn);
        button = findViewById(R.id.button);

        button.setOnClickListener(listener); //Обработка нажатия кнопки

    }

    //Слушиватель кнопки
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Переключение на другой экран

            //Считывание данных с экрана
            name = nameIn.getText().toString();
            address = addressIn.getText().toString();
            email = emailIn.getText().toString();

            //Создаем объект сущности и через конструктор инициализируем его
            User user = new User(name, address, email);


            //Создание намерения переключения на другой экран
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

            //Запаковка данных в контейнер намерения
            intent.putExtra(User.class.getSimpleName(), user); //ser.class.getSimpleName() является ключом для запаковки в контейнер

            //Старт переключения активности
            startActivity(intent);

        }
    };
}