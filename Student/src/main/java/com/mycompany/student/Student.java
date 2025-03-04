/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.student;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author toan0
 */
public class Student {
    private String studentId;   // ID của sinh viên
    private String name;        // Tên sinh viên
    private int age;            // Tuổi sinh viên
    private Map<String, Double> grades; // Danh sách điểm theo môn học
    // Constructor để khởi tạo sinh viên
    public Student(String studentId, String name, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Tuổi không thể là số âm.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên không được để trống.");
        }
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.grades = new HashMap<>();
    }
    // Getter cho studentId
    public String getStudentId() {
        return studentId;
    }
    // Getter cho name
    public String getName() {
        return name;
    }
    // Cập nhật tên sinh viên
    public void updateName(String newName) {
        if (newName == null || newName.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên mới không được để trống.");
        }
        this.name = newName;
    }

    // Getter cho age
    public int getAge() {
        return age;
    }
    
    // Setter cho age với kiểm tra điều kiện hợp lệ
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Tuổi không thể là số âm.");
        }
        this.age = age;
    }

    // Thêm điểm cho môn học
    public void addGrade(String subject, double grade) {
        if (grade < 0 || grade > 10) {
            throw new IllegalArgumentException("Điểm phải từ 0 đến 10.");
        }
        if (grades.containsKey(subject)) {
            throw new IllegalArgumentException("Môn học đã tồn tại.");
        }
        grades.put(subject, grade);
    }

    // Cập nhật điểm của môn học đã có
    public void updateGrade(String subject, double newGrade) {
        if (!grades.containsKey(subject)) {
            throw new IllegalArgumentException("Môn học không tồn tại.");
        }
        if (newGrade < 0 || newGrade > 10) {
            throw new IllegalArgumentException("Điểm phải từ 0 đến 10.");
        }
        grades.put(subject, newGrade);
    }

    // Tính GPA trung bình của sinh viên
    public double calculateGPA() {
        if (grades.isEmpty()) {
            return 0.0; // Nếu chưa có môn nào, trả về 0
        }
        double total = 0;
        for (double grade : grades.values()) {
            total += grade;
        }
        return total / grades.size();
    }

    // Xếp loại học lực dựa trên GPA
    public String getAcademicStanding() {
        double gpa = calculateGPA();
        if (gpa >= 8.5) {
            return "Giỏi";
        } else if (gpa >= 6.5) {
            return "Khá";
        } else if (gpa >= 5.0) {
            return "Trung Bình";
        } else {
            return "Yếu";
        }
    }

    // Hiển thị thông tin sinh viên
    public void displayInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("GPA: " + calculateGPA());
        System.out.println("Academic Standing: " + getAcademicStanding());
    }
}