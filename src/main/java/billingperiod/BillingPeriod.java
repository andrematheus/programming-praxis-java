package billingperiod;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;

class BillingPeriod {
    private final Id id;

    private BillingPeriod(int year, int number) {
        this.id = new Id(year, number);
    }

    static BillingPeriod ofDate(LocalDate date) {
        int year = date.getYear();
        LocalDate iterationDay = LocalDate.of(year, 1, 1);
        int billingPeriodNumber = 1;
        while (iterationDay.isBefore(date)) {
            iterationDay = iterationDay.plusDays(1);
            if (iterationDay.getDayOfWeek().equals(DayOfWeek.SATURDAY) || iterationDay.getDayOfMonth() == 1) {
                billingPeriodNumber++;
            }
        }
        return new BillingPeriod(year, billingPeriodNumber);
    }

    static Id idOf(int year, int number) {
        return new Id(year, number);
    }

    Id getId() {
        return id;
    }

    static class Id {
        final int year;
        final int number;

        Id(int year, int number) {
            this.year = year;
            this.number = number;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Id id = (Id) o;
            return year == id.year &&
                    number == id.number;
        }

        @Override
        public int hashCode() {
            return Objects.hash(year, number);
        }

        @Override
        public String toString() {
            return "Id{" +
                    "year=" + year +
                    ", number=" + number +
                    '}';
        }
    }
}
