package com.example.javalearningexampledatatransferserializable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView dataMainActivity; //Поле вывода информации из главного экрана
    private Button button; //Поле кнопки

    private String name; //поле хранения имени
    private String address; //поле хранения адреса
    private String email; //поле хранения почты

    private User user; //поле сущности пользователя

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Привязка к полям
        dataMainActivity = findViewById(R.id.dataMainActivity);
        button = findViewById(R.id.button);

        //Считывание данных из главной активности
        Bundle bundleIntent = getIntent().getExtras();

        if (bundleIntent != null){
            //Инициализируем поле сущности пользователя
            user = (User) bundleIntent.getSerializable(User.class.getSimpleName());

            //Вывод на экран данных из главной активности
            dataMainActivity.setText("Имя: " + user.getName() + "\n"
                    + "Адрес: " + user.getAddress() + "\n"
                    + "Электронная почта: " + user.getEmail() + "\n");
        }

        /*
        //Простая передача данных
        //Инициализация данных
        name = bundleIntent.get("name").toString(); //Считывание и нинициализация имени
        address = bundleIntent.get("address").toString(); //Считывание и нинициализация адреса
        email = bundleIntent.get("email").toString(); //Считывание и нинициализация почты

        //Вывод на экран данных из главной активности
        dataMainActivity.setText("Имя: " + name + "\n"
                + "Адрес: " + address + "\n"
                + "Электронная почта: " + email + "\n");
        */

        button.setOnClickListener(listener); //Обработка нажатия кнопки

    }

    //Слушиватель кнопки
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Возврат обратно на главную активность

            //Создание намерения переключения на другой экран
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent); //Старт переключения активности

        }
    };

}