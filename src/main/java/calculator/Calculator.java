package calculator;

public class Calculator {
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;  // 빈 문자열일 경우 0 반환
        }
        return Integer.parseInt(input);  // 하나의 숫자 입력 처리
    }
}
