class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = 0;

        m = convertMelody(m);

        for (String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");
            String startTime = info[0];
            String endTime = info[1];
            String title = info[2];
            String melody = convertMelody(info[3]);

            int playTime = getPlayTime(startTime, endTime);
            String fullMelody = getFullMelody(melody, playTime);

            if (fullMelody.contains(m) && playTime > maxPlayTime) {
                maxPlayTime = playTime;
                answer = title;
            }
        }

        return answer;
    }

    private String convertMelody(String melody) {
        return melody.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("B#", "M")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a");
    }

    private int getPlayTime(String startTime, String endTime) {
        String[] start = startTime.split(":");
        String[] end = endTime.split(":");

        int startHour = Integer.parseInt(start[0]);
        int startMinute = Integer.parseInt(start[1]);
        int endHour = Integer.parseInt(end[0]);
        int endMinute = Integer.parseInt(end[1]);

        return (endHour - startHour) * 60 + (endMinute - startMinute);
    }

    private String getFullMelody(String melody, int playTime) {
        StringBuilder fullMelody = new StringBuilder();
        int melodyLength = melody.length();
        int repeatCount = playTime / melodyLength;
        int remainder = playTime % melodyLength;

        for (int i = 0; i < repeatCount; i++) {
            fullMelody.append(melody);
        }

        fullMelody.append(melody.substring(0, remainder));

        return fullMelody.toString();
    }
}