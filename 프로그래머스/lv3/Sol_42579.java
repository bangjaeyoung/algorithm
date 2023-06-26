package programmers.level3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
1. 한 장르에 대한 재생 횟수의 중첩 값을 key, value 형태로 집어넣는다. - genresAndPlays
2. 재생 횟수에 대해서 장르를 내림차순하여 정렬한다. - typeOfGenres
3. 한 장르에 대한 노래 정보를 모두 추가하고, 재생 횟수에 대해 내림차순 정렬한다. - musicOfOneGenre
4. 내림차순 정렬된 리스트에서 한 장르에 대한 노래가 하나만 존재한다면 하나만 결과 리스트에 넣고,
두 개 이상 존재한다면 두 개까지 결과 리스트에 넣는다.
5. 결과 리스트를 배열로 변환하여 반환한다.
 */
public class Sol_42579 {
    static class Music {
        int idx;
        String genre;
        int play;

        public Music(int idx, String genre, int play) {
            this.idx = idx;
            this.genre = genre;
            this.play = play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresAndPlays = new HashMap<>();
        for (int i = 0; i < genres.length; i++)
            genresAndPlays.put(genres[i], genresAndPlays.getOrDefault(genres[i], 0) + plays[i]);

        List<String> typeOfGenres = new ArrayList<>(genresAndPlays.keySet());
        typeOfGenres.sort((o1, o2) -> genresAndPlays.get(o2) - genresAndPlays.get(o1));

        List<Integer> result = new ArrayList<>();

        for (String type : typeOfGenres) {
            List<Music> musicOfOneGenre = new ArrayList<>();

            for (int i = 0; i < genres.length; i++)
                if (genres[i].equals(type)) musicOfOneGenre.add(new Music(i, type, plays[i]));

            musicOfOneGenre.sort((o1, o2) -> o2.play - o1.play);

            result.add(musicOfOneGenre.get(0).idx);
            if (musicOfOneGenre.size() > 1) result.add(musicOfOneGenre.get(1).idx);
        }

        return result.stream().mapToInt(idx -> idx).toArray();
    }
}
