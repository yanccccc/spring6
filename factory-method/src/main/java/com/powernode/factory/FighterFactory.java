package com.powernode.factory;

public class FighterFactory extends WeaponFactory{
    @Override
    public Weapon createWeapon() {
        return new Fighter();
    }
}
