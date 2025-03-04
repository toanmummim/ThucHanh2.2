/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package com.mycompany.student;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import java.util.NoSuchElementException;

public class StudentNGTest {
    
    // Kiểm tra danh sách môn học ban đầu có rỗng không
    @Test
    public void testInitialGradesEmpty() {
        Student student = new Student("S001", "John Doe", 20);
        assertTrue(student.getGrades().isEmpty(), "Danh sách môn học ban đầu không rỗng!");
    }
    
    // Kiểm tra GPA khi không có môn học nào
    @Test
    public void testCalculateGPAWithNoSubjects() {
        Student student = new Student("S001", "John Doe", 20);
        assertEquals(student.calculateGPA(), 0.0, "GPA phải bằng 0 khi không có môn học!");
    }
    
    // Kiểm tra học lực Giỏi
    @Test
    public void testAcademicStandingExcellent() {
        Student student = new Student("S001", "John Doe", 20);
        student.addSubject("Math", 9.0);
        assertEquals(student.getAcademicStanding(), "Giỏi");
    }
    
    // Kiểm tra học lực Khá
    @Test
    public void testAcademicStandingGood() {
        Student student = new Student("S001", "John Doe", 20);
        student.addSubject("Physics", 7.0);
        assertEquals(student.getAcademicStanding(), "Khá");
    }
    
    // Kiểm tra học lực Trung bình
    @Test
    public void testAcademicStandingAverage() {
        Student student = new Student("S001", "John Doe", 20);
        student.addSubject("History", 5.5);
        assertEquals(student.getAcademicStanding(), "Trung bình");
    }
    
    // Kiểm tra học lực Yếu
    @Test
    public void testAcademicStandingWeak() {
        Student student = new Student("S001", "John Doe", 20);
        student.addSubject("Literature", 4.0);
        assertEquals(student.getAcademicStanding(), "Yếu");
    }
    
    // Kiểm tra xóa môn học
    @Test
    public void testRemoveSubject() {
        Student student = new Student("S001", "John Doe", 20);
        student.addSubject("Biology", 8.0);
        student.removeSubject("Biology");
        assertFalse(student.getGrades().containsKey("Biology"), "Môn học chưa được xóa!");
    }
    
    // Kiểm tra xóa môn học không tồn tại (phải ném ngoại lệ)
    @Test(expectedExceptions = NoSuchElementException.class)
    public void testRemoveNonExistingSubject() {
        Student student = new Student("S001", "John Doe", 20);
        student.removeSubject("Art");
    }
    
    // Kiểm tra cập nhật tên sinh viên
    @Test
    public void testUpdateName() {
        Student student = new Student("S001", "John Doe", 20);
        student.updateName("Jane Doe");
        assertEquals(student.getName(), "Jane Doe", "Tên không được cập nhật đúng!");
    }
    
    // Kiểm tra cập nhật tuổi sinh viên
    @Test
    public void testUpdateAge() {
        Student student = new Student("S001", "John Doe", 20);
        student.setAge(25);
        assertEquals(student.getAge(), 25, "Tuổi không được cập nhật đúng!");
    }
    
    // Kiểm tra đặt tuổi không hợp lệ (phải ném ngoại lệ)
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetInvalidAge() {
        Student student = new Student("S001", "John Doe", 20);
        student.setAge(-5);
    }
    
    // Kiểm tra thêm môn học trùng lặp (điểm phải được cập nhật)
    @Test
    public void testAddDuplicateSubject() {
        Student student = new Student("S001", "John Doe", 20);
        student.addSubject("English", 7.5);
        student.addSubject("English", 8.5);
        assertEquals(student.getGrades().get("English"), 8.5, "Điểm của môn học không được cập nhật đúng!");
    }
    
    // Kiểm tra GPA sau khi xóa môn học
    @Test
    public void testRemoveSubjectAffectGPA() {
        Student student = new Student("S001", "John Doe", 20);
        student.addSubject("Math", 9.0);
        student.addSubject("Science", 5.0);
        student.removeSubject("Math");
        assertEquals(student.calculateGPA(), 5.0, "GPA không cập nhật đúng sau khi xóa môn học!");
    }
    
    // Kiểm tra thêm môn học với điểm không hợp lệ (phải ném ngoại lệ)
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAddSubjectWithInvalidScore() {
        Student student = new Student("S001", "John Doe", 20);
        student.addSubject("Music", -3.0);
    }
}
