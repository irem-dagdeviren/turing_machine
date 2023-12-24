enum Direction {
    LEFT("L"),
    RIGHT("R");

    private final String value;

    Direction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Direction fromString(String value) {
        for (Direction direction : Direction.values()) {
            if (direction.value.equals(value)) {
                return direction;
            }
        }
        throw new IllegalArgumentException("No enum constant Direction." + value);
    }
}
