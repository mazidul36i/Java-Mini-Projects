package org.sb201;

import org.sb201.bean.Gym;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Gym gym = new Gym();
        System.out.println("Enter gym name: ");
        gym.setGym_name(sc.nextLine());
        System.out.println("Enter gym fee: ");
        gym.setMonthly_fee(sc.nextInt());

        Dao dao = new DaoImpl();
        dao.addGym(gym);
        System.out.println("Gym added successfully!");
    }
}