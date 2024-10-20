package calculator;

public class Calculator {
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens = input.split("[,|:]");  // 쉼표 또는 콜론으로 숫자 분리
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;  // 합산한 결과 반환
    }
}
