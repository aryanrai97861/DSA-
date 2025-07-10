public String toBinaryManual(int num) {
    if (num == 0)
        return "0";

    StringBuilder binary = new StringBuilder();

    while (num > 0) {
        int bit = num % 2;
        binary.append(bit);
        num /= 2;
    }

    return binary.reverse().toString();
}
