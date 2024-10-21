package calculator;

import java.util.Scanner;

public class Calculator {
    public static int add(String input) {
        // 빈 문자열 처리
        if (input == null || input.isEmpty()) {
            return 0;
        }
        // 빈 문자열이 아닌 경우
        String[] tokens;
        if (input.startsWith("//")) {
            // "//"와 "\n" 사이에 들어있는 문자열과 ",",":"을 구분자로 지정
            int delimiterIndex = input.indexOf("\\");
            String customDelimiter = input.substring(2, delimiterIndex);
            String numbersPart = input.substring(delimiterIndex + 2);

            tokens = numbersPart.split(customDelimiter + "|,|:");
        } else {
            tokens = input.split(",|:");
        }

        // 합산
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}
