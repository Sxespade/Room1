package com.example.myapplication;

import android.app.Application;

import androidx.room.Room;

import com.example.myapplication.dao.EducationDao;
import com.example.myapplication.database.EducationDatabase;
import com.example.myapplication.database.Migration_1_2;


// паттерн синглтон, наследуем класс Application
// создаем базу данных в методе onCreate
public class App extends Application {

    private static App instance;

    // база данных
    private EducationDatabase db;

    // Так получаем объект приложения
    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // Это для синглтона, сохраняем объект приложения
        instance = this;

        // строим базу
        db = Room.databaseBuilder(
                    getApplicationContext(),
                    EducationDatabase.class,
                    "education_database")
                .allowMainThreadQueries() //Только для примеров и тестирования.
                .addMigrations(new Migration_1_2())
                .build();
    }

    // Получаем EducationDao для составления запросов
    public EducationDao getEducationDao() {
        return db.getEducationDao();
    }
}
