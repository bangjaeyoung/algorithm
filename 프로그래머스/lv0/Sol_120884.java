package 프로그래머스.lv0;

public class Sol_120884 {
    public int solution(int chicken) {
        int serviceChicken = 0;
        while (chicken > 9) {
            serviceChicken += chicken / 10;
            chicken = (chicken / 10) + (chicken % 10);
        }
        return serviceChicken;
    }
}
