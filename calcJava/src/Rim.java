public enum Rim {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10);
    private int integer;

    Rim(int integer) {
        this.integer = integer;
    }

    public int getInteger() {
        return integer;
    }
}