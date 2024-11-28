package Entities;

public class Individual extends TaxPayer {
    private Double healthExpenditures;

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public double tax() {
        double baseTax = (getAnualIncome() < 20000.0) ? 0.15 : 0.25;
        double healthDeduction = (healthExpenditures != null) ? healthExpenditures * 0.5 : 0.0;
        return (getAnualIncome() * baseTax) - healthDeduction;
    }
}