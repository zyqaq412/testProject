package com.studentTest.service;

import com.studentTest.bean.Major;
import com.studentTest.bean.User;
import com.studentTest.dao.FileDao;
import com.studentTest.dao.FileDaoImpl;

import java.util.ArrayList;

public class FileServiceImpl implements FileService{
    FileDao fs = new FileDaoImpl();
    @Override
    public ArrayList<User> getAllStudent() {

        return fs.getAllStudent();
    }

    @Override
    public User getFileByNameOrId(String v) {

        return fs.getFileByNameOrId(v);
    }

    @Override
    public User getAdmin(String id) {

        return fs.getAdmin(id);
    }

    @Override
    public ArrayList getPersonFile(String studentId) {
        return fs.getPersonFile(studentId);
    }

    @Override
    public void delPersonFile(String studentId) {
        fs.delPersonFile(studentId);
    }

    @Override
    public void upScore(String stuId, String a1, String a2, String a3, String a4) {
        fs.upScore(stuId,a1,a2,a3,a4);
    }

    @Override
    public void addUp(int a1, String a2, String a3, String a4, String a5, int a6) {
        fs.addUp(a1,a2,a3,a4,a5,a6);
    }

    @Override
    public void update(String stuId, String a1, String a2, String a3, String a4) {
        fs.update(stuId,a1,a2,a3,a4);
    }

}
