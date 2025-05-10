package com.powernode.factory;

public class Client {
    public static void main(String[] args) {
        Weapon dagger = WeaponFactory.getWeapon("Dagger");
        dagger.attack();
        Weapon tank = WeaponFactory.getWeapon("Tank");
        tank.attack();
        Weapon fighter = WeaponFactory.getWeapon("Fighter");
        fighter.attack();
    }
}
