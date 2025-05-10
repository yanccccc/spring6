package com.powernode.factory;

public class Client {
    public static void main(String[] args) {
        WeaponFactory factory = new TankFactory();
        Weapon tank = factory.createWeapon();
        tank.attack();

        WeaponFactory factory1 = new FighterFactory();
        Weapon fighter = factory1.createWeapon();
        fighter.attack();
    }
}
