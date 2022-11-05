package com.studentTest.dao;

import com.studentTest.bean.Major;
import com.studentTest.bean.User;

import java.util.ArrayList;

public interface FileDao {
    ArrayList<User> getAllStudent();

    User getFileByNameOrId(String v);
    User getAdmin(String id);

    ArrayList getPersonFile(String studentId);

    void delPersonFile(String studentId);

    void upScore(String stuId, String a1, String a2, String a3, String a4);

    void addUp(int a1, String a2, String a3, String a4, String a5, int a6);

    void update(String stuId, String a1, String a2, String a3, String a4);
}
