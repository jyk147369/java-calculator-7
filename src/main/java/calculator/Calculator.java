package calculator;

import java.util.Scanner;

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

    // 코드 확인을 위한 Scanner 임시 추가
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Scanner로 입력 받기

        System.out.print("덧셈할 문자열을 입력해 주세요: ");
        String input = scanner.nextLine();

        try {
            int result = add(input);
            System.out.println("결과: " + result);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 숫자만 포함된 문자열을 입력해 주세요.");
        }
    }
}
