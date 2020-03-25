package ru.ifmo.base.lesson7;

public class Doctor extends BattleUnit{
    private int medicineScore;

    public Doctor(int healthScore, int speed, int attackScore, int medicineScore) {
        super(healthScore, speed, attackScore);
        setMedicineScore(medicineScore);
    }

    public void setMedicineScore(int medicineScore) {
        this.medicineScore = medicineScore;
    }

    public int getMedicineScore() {
        return medicineScore;
    }

    @Override // указатель компилятору, что метод переопределен
    public void attack(BattleUnit friend) {
        if (!(friend instanceof Doctor)){
            System.out.println("Doctor attack");
            friend.healthScore += attackScore + medicineScore;
        }
    }

    @Override
    public void run() {
        System.out.println("Doctor run");
    }

    @Override
    public void rest() {
        System.out.println("Doctor rest");
    }


}
