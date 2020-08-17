package com.example.myapplication.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.myapplication.dao.EducationDao;
import com.example.myapplication.model.DateConverter;
import com.example.myapplication.model.Email;
import com.example.myapplication.model.Student;


@Database(entities = {Student.class, Email.class}, version = 2)
@TypeConverters(DateConverter.class)
public abstract class EducationDatabase extends RoomDatabase {
    public abstract EducationDao getEducationDao();
}
