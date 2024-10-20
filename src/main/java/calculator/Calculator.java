package calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int add(String input) {
        // 빈 문자열 처리
        if (input == null || input.isEmpty()) {
            return 0;
        }
        // 빈 문자열이 아닌 경우
        String[] tokens;
        // input이 "//"로 시작되는 경우
        if (input.startsWith("//")) {
            // "//"와 "\n" 사이에 들어있는 문자열과 ",",":"을 구분자로 지정
            // input.indexOf()
            int delimiterIndex = input.indexOf("\\");
            String customDelimiter = input.substring(2, delimiterIndex);  // "//" 이후와 "\n" 사이에 있는 구분자 추출
            String numbersPart = input.substring(delimiterIndex + 2);  // "\n" 뒤의 숫자 부분 추출

            // 커스텀 구분자와 쉼표, 콜론을 모두 구분자로 사용해서 토큰을 파싱
            tokens = numbersPart.split(customDelimiter + "|,|:");
        } else {
            // input이 "//"로 시작되지 않는 경우 -> 커스텀 구분자 없음
            // 쉼표 또는 콜론으로 토큰을 파싱
            tokens = input.split(",|:");
        }

        // 합산
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
