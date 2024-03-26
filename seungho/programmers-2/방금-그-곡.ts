/*
라디오를 자주 듣는 네오는 라디오에서 방금 나왔던 음악이 무슨 음악인지 궁금해질 때가 많다. 그럴 때 네오는 다음 포털의 '방금그곡' 서비스를 이용하곤 한다. 방금그곡에서는 TV, 라디오 등에서 나온 음악에 관해 제목 등의 정보를 제공하는 서비스이다.

네오는 자신이 기억한 멜로디를 가지고 방금그곡을 이용해 음악을 찾는다. 그런데 라디오 방송에서는 한 음악을 반복해서 재생할 때도 있어서 네오가 기억하고 있는 멜로디는 음악 끝부분과 처음 부분이 이어서 재생된 멜로디일 수도 있다. 반대로, 한 음악을 중간에 끊을 경우 원본 음악에는 네오가 기억한 멜로디가 들어있다 해도 그 곡이 네오가 들은 곡이 아닐 수도 있다. 그렇기 때문에 네오는 기억한 멜로디를 재생 시간과 제공된 악보를 직접 보면서 비교하려고 한다. 다음과 같은 가정을 할 때 네오가 찾으려는 음악의 제목을 구하여라.

방금그곡 서비스에서는 음악 제목, 재생이 시작되고 끝난 시각, 악보를 제공한다.
네오가 기억한 멜로디와 악보에 사용되는 음은 C, C#, D, D#, E, F, F#, G, G#, A, A#, B 12개이다.
각 음은 1분에 1개씩 재생된다. 음악은 반드시 처음부터 재생되며 음악 길이보다 재생된 시간이 길 때는 음악이 끊김 없이 처음부터 반복해서 재생된다. 음악 길이보다 재생된 시간이 짧을 때는 처음부터 재생 시간만큼만 재생된다.
음악이 00:00를 넘겨서까지 재생되는 일은 없다.
조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다. 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
조건이 일치하는 음악이 없을 때에는 “(None)”을 반환한다.
*/

type MusicInfo = string;

const replaceSharp = (melody: string): string => {
    return melody.replace(/C#/g, 'c').replace(/D#/g, 'd').replace(/F#/g, 'f').replace(/G#/g, 'g').replace(/A#/g, 'a');
}

const calculatePlayTime = (start: string, end: string): number => {
    const [startHour, startMinute] = start.split(':').map(Number);
    const [endHour, endMinute] = end.split(':').map(Number);
    return (endHour - startHour) * 60 + (endMinute - startMinute);
}

const getActualMelody = (playTime: number, sheetMusic: string): string => {
    const length = sheetMusic.length;
    const repeats = Math.floor(playTime / length);
    const remainder = playTime % length;
    return sheetMusic.repeat(repeats) + sheetMusic.substring(0, remainder);
}

interface Answer {
    title: string;
    playTime: number;
}

const findMatchingMusic = (m: string, musicinfos: MusicInfo[]): string => {
    m = replaceSharp(m);
    let answer: Answer = { title: '(None)', playTime: 0 };

    musicinfos.forEach((info: MusicInfo) => {
        let [start, end, title, sheetMusic] = info.split(',');
        sheetMusic = replaceSharp(sheetMusic);
        const playTime = calculatePlayTime(start, end);
        const actualMelody = getActualMelody(playTime, sheetMusic);

        if (actualMelody.includes(m) && playTime > answer.playTime) {
            answer = { title, playTime };
        }
    });

    return answer.title;
}
