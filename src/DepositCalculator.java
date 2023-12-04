import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return calculateSum(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return calculateSum(amount + amount * yearRate * depositPeriod, 2);
    }

    double calculateSum(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateDeposit() {
        int period; 
        int action; 

        Scanner scanner = new Scanner(System.in); // не очень понятно, по какому принципу расставлены абзацные отступы
        System.out.println("Введите сумму вклада в рублях:");

        int amount = scanner.nextInt(); // здесь переменная отделилась от вывода в консоль
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt(); // а здесь и на 30 строке переменная находится вместе с выводом

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt(); // я думаю, что для лучшей читаемости лучше убрать отступы между переменными и выводом в блоке 22-29

        double depositSum = 0;
        if (action == 1) {
            depositSum = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            depositSum = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + depositSum);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }

}
