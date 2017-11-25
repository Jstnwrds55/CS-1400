public class TaxCalculator {
    public static void main(String[] args) {

        // declare values for food and non food bill
        Double foodBill = 150.0;
        Double nonFoodBill = 50.0;

        // calculate total tax on bill amounts
        Double total = foodTax(foodBill) + nonFoodTax(nonFoodBill);
        System.out.println("The total tax for you bill is: $" + total);
    }

    // calculate tax for food bill
    private static Double foodTax(Double bill) {
        return (bill * .03);
    }

    // calculate tax for non food bill
    private static Double nonFoodTax(Double bill) {
        return (bill * .0675);
    }
}

