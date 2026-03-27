package com.example.javatest;

import java.util.ArrayList;

public class Student {

    String name;
    int[] scores = {};

    public String getName() {
        return name;
    }

    public int[] getScores() {
        return scores;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public Double getAverage() {
        int sum = 0;
        for (int i : scores) {
            sum += i;
        }
        Double avg = (double) sum / scores.length;
        return avg;
    }

    public String getGrade() {
        if (getAverage() >= 90) {
            return "A";
        } else if (getAverage() >= 80) {
            return "B";
        } else if (getAverage() >= 70) {
            return "C";
        } else if (getAverage() >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(Student student) {
        this.name = student.name;
        this.scores = student.scores;
    }

    public static void main(String[] args) {

        Student s1 = new Student("홍길동");
        Student s2 = new Student("임꺽정");
        Student s3 = new Student("흥선");

        s1.setScores(new int[] { 100, 90, 80 });
        s2.setScores(new int[] { 80, 70, 60 });
        s3.setScores(new int[] { 60, 50, 40 });

        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        list.stream().filter(i -> i.getAverage() >= 80).forEach(
                i -> System.out.println("이름: " + i.getName() + "평균: " + i.getAverage() + "등급: " + i.getGrade()));

    }

}
