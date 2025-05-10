package com.powernode.factory;

public class TankFactory extends WeaponFactory{
    @Override
    public Weapon createWeapon() {
        return new Tank();
    }
}
