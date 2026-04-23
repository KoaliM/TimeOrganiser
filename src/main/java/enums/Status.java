package enums;

public enum Status {
        NOT_STARTED("Not started"),
        IN_PROGRESS("In progress"),
        COMPLETED("Completed"),
        POSTPONED("Postponed");

        private final String name;
        Status(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
}
