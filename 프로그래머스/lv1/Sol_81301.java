package programmers.level1;

public class Sol_81301 {
    public int solution(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            switch (s.charAt(i)) {

                case 'z':
                    sb.append(0);
                    i += 3;
                    break;

                case 'o':
                    sb.append(1);
                    i += 2;
                    break;

                case 't':
                    if (s.charAt(i + 1) == 'w') {
                        sb.append(2);
                        i += 2;
                        break;
                    }
                    else {
                        sb.append(3);
                        i += 4;
                        break;
                    }

                case 'f':
                    if (s.charAt(i + 1) == 'o') {
                        sb.append(4);
                        i += 3;
                        break;
                    }
                    else {
                        sb.append(5);
                        i += 3;
                        break;
                    }

                case 's':
                    if (s.charAt(i + 1) == 'i') {
                        sb.append(6);
                        i += 2;
                        break;
                    }
                    else {
                        sb.append(7);
                        i += 4;
                        break;
                    }

                case 'e':
                    sb.append(8);
                    i += 4;
                    break;

                case 'n':
                    sb.append(9);
                    i += 3;
                    break;

                default:
                    sb.append(Character.getNumericValue(s.charAt(i)));
                    break;
            }
        }

        return Integer.parseInt(String.valueOf(sb));
    }
}
