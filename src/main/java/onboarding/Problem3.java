package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number; i++) {
            answer += countClaps(i);
        }
        return answer;
    }

    public static int countClaps(int target) {
        int clap = 0;
        while(target > 0) {
            int units = target % 10;
            if(units == 3 || units == 6 || units == 9) {
                clap++;
            }
            target /= 10;
        }

        return clap;
    }
}
