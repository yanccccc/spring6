package com.powernode.factory;

/**
 * 静态工厂类
 */
public class WeaponFactory {

    public static Weapon getWeapon(String type) {
        if ("tank".equalsIgnoreCase(type)) {
            return new Tank();
        } else if ("fighter".equalsIgnoreCase(type)) {
            return new Fighter();
        } else if ("dagger".equalsIgnoreCase(type)) {
            return new Dagger();
        } else {
            return null;
        }
    }
}
