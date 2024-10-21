package calculator;

import java.util.regex.Pattern;

public class Calculator {
    public static int add(String input) {
        // 빈 문자열 입력받은 경우
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens;

        // 커스텀 구분자가 있는 경우
        // "//"로 시작
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");

            // "//"로 시작했지만 "\n"이 없을때 예외던지기
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다. 커스텀 구분자를 찾을 수 없습니다.");
            }

            String customDelimiter = input.substring(2, delimiterIndex);
            String numbersPart = input.substring(delimiterIndex + 2);

            // 커스텀 구분자, 기본 구분자(",",":")로 파싱
            tokens = numbersPart.split(Pattern.quote(customDelimiter) + "|,|:");
        } else {
            // 커스텀 구분자가 없는 경우
            tokens = input.split(",|:");
        }

        int sum = 0;

        for (String token : tokens) {
            // trim()으로 공백을 제거하고 숫자를 파싱
            token = token.trim();

            if (!token.isEmpty()) {
                int number = Integer.parseInt(token);

                // 음수일때 예외던지기
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                }

                sum += number;
            }
        }

        return sum;
    }
}
