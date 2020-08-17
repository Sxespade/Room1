package com.example.myapplication.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.io.Serializable;
import java.util.List;

// Результат запроса через Relation
// первый запрос по студентам,
// далее запросы по каждому студенту для получения Email
public class StudentEmail implements Serializable {

    @Embedded
    public Student student;

    @Relation(parentColumn = "id", entityColumn = "student_id")
    public List<Email> emails;
}
