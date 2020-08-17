package com.example.myapplication;

import com.example.myapplication.dao.EducationDao;
import com.example.myapplication.model.Email;
import com.example.myapplication.model.Student;
import com.example.myapplication.model.StudentEmail;

import java.util.List;

// Вспомогательный класс, развязывающий
// зависимость между Room и RecyclerView
public class EducationSource {

    private final EducationDao educationDao;

    // Буфер с данными, сюда будем подкачивать данные из БД
    private List<Student> students;

    public EducationSource(EducationDao educationDao){
        this.educationDao = educationDao;
    }

    // Получить всех студентов
    public List<Student> getStudents(){
        // Если объекты еще не загружены, то загружаем их.
        // Сделано для того, чтобы не делать запросы в БД каждый раз
        if (students == null){
            LoadStudents();
        }
        return students;
    }

    // Загрузить студентов в буфер
    public void LoadStudents(){
        students = educationDao.getAllStudents();
    }

    // Получить количество записей
    public long getCountStudents(){
        return educationDao.getCountStudents();
    }

    // Добавить студента
    public void addStudent(Student student){
        long id = educationDao.insertStudent(student);
        Email email1 = new Email();
        email1.studentId = id;
        email1.email = "abc@mail.edu";
        educationDao.insertEmail(email1);
        Email email2 = new Email();
        email2.studentId = id;
        email2.email = "cde@another.mail";
        educationDao.insertEmail(email2);
        // После изменения БД надо перечитать буфер
        LoadStudents();
    }

    public StudentEmail getStudentEmail(long id){
        return educationDao.getOneStudentEmails(id);
    }

    // Заменить студента
    public void updateStudent(Student student){
        educationDao.updateStudent(student);
        LoadStudents();
    }

    // Удалить студента из базы
    public void removeStudent(long id){
        educationDao.deteleStudentById(id);
        LoadStudents();
    }

}
