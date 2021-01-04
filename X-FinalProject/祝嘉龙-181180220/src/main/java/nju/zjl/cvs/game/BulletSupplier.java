package nju.zjl.cvs.game;

@FunctionalInterface
interface BulletSupplier{
    Affector get(int x, int y, int target, int damage);        
}

