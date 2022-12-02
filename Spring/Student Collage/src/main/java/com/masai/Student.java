package com.masai;

class Student {

    private int roll;
    private int marks;

    public Student(int roll, int marks) {
        this.roll = roll;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", marks=" + marks +
                '}';
    }

}
