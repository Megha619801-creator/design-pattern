package adapter;

public class Main {
    public static void main(String[] args) {
        NewDateInterface date = new CalendarToNewDateAdapter();

        date.setDay(10);
        date.setMonth(4);
        date.setYear(2026);

        System.out.println("Original Date: "
                + date.getDay() + "/"
                + date.getMonth() + "/"
                + date.getYear());

        date.advanceDays(15);

        System.out.println("After advancing 15 days: "
                + date.getDay() + "/"
                + date.getMonth() + "/"
                + date.getYear());
    }
}