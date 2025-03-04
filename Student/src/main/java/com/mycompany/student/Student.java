/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.student;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Student {
    // Thuộc tính lưu mã sinh viên
    private String studentId;
    // Thuộc tính lưu tên sinh viên
    private String name;
    // Thuộc tính lưu tuổi sinh viên
    private int age;
    // Danh sách môn học và điểm số tương ứng
    private Map<String, Double> grades;

    // Constructor khởi tạo đối tượng Student, kiểm tra điều kiện hợp lệ
    public Student(String studentId, String name, int age) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên sinh viên không được để trống");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Tuổi phải lớn hơn 0");
        }
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.grades = new HashMap<>(); // Khởi tạo danh sách môn học rỗng
    }

    // Getter cho studentId
    public String getStudentId() {
        return studentId;
    }

    // Getter cho name
    public String getName() {
        return name;
    }

    // Setter để cập nhật tên sinh viên, kiểm tra điều kiện hợp lệ
    public void updateName(String newName) {
        if (newName == null || newName.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên sinh viên không được để trống");
        }
        this.name = newName;
    }

    // Getter cho age
    public int getAge() {
        return age;
    }

    // Setter cho age, kiểm tra giá trị hợp lệ trước khi cập nhật
    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Tuổi phải lớn hơn 0");
        }
        this.age = age;
    }

    // Thêm môn học và điểm số tương ứng, kiểm tra điều kiện hợp lệ
    public void addSubject(String subject, double score) {
        if (score < 0 || score > 10) {
            throw new IllegalArgumentException("Điểm số phải từ 0 đến 10");
        }
        grades.put(subject, score);
    }

    // Xóa môn học khỏi danh sách, ném ngoại lệ nếu môn học không tồn tại
    public void removeSubject(String subject) {
        if (!grades.containsKey(subject)) {
            throw new NoSuchElementException("Không tìm thấy môn học: " + subject);
        }
        grades.remove(subject);
    }

    // Getter để lấy danh sách môn học và điểm số
    public Map<String, Double> getGrades() {
        return grades;
    }

    // Tính GPA trung bình các môn học
    public double calculateGPA() {
        if (grades.isEmpty()) {
            return 0.0; // Trả về 0 nếu không có môn học nào
        }
        double total = 0.0;
        for (double score : grades.values()) {
            total += score;
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
            return "Trung bình";
        } else {
            return "Yếu";
        }
    }
}