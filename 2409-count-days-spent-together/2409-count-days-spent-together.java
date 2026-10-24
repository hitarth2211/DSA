class Solution {
    int calculateDays(String date, int[] monthDays) {
        int day = Integer.parseInt(date.substring(3,5));
        int month = Integer.parseInt(date.substring(0,2));
        int totalDays = day;
        for(int i = 1; i < month; i++) {
            totalDays += monthDays[i];
        }
        return totalDays;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int n = monthDays.length;

        int arriving_day_of_alice_365 = calculateDays(arriveAlice, monthDays);
        int leaving_day_of_alice_365 = calculateDays(leaveAlice, monthDays);
        int arriving_day_of_bob_365 = calculateDays(arriveBob, monthDays);
        int leaving_day_of_bob_365 = calculateDays(leaveBob, monthDays);
        
        int start = Math.max(arriving_day_of_alice_365, arriving_day_of_bob_365);
        int end = Math.min(leaving_day_of_alice_365, leaving_day_of_bob_365);

        return Math.max(0, end - start + 1);
    }
}