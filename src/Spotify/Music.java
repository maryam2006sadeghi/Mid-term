package Spotify;

import java.util.ArrayList;

public class Music {
    public String title;
    public User singer;
    public int numberOfStream;
    public static ArrayList<Music> allMusics = new ArrayList<>();

    public Music(String title, User singer){
        this.title = title;
        this.singer = singer;
        allMusics.add(this);
    }

    public static void play(Music music){
        for (Music m : allMusics){
            if (m.equals(music)){
                System.out.println("Music: " + m.title + "Singer: " + m.singer.getUsername() + "is playing");
                m.numberOfStream ++;
            }
        }
    }

    public static ArrayList<Music> search(String title){
        ArrayList<Music> musics = new ArrayList<>();
        for (Music music : allMusics)
        {
            if (music.title.equals(title)){
                musics.add(music);
            }
        }
        if (musics.isEmpty())
            return null;
        return musics;
    }

    public static Music search(String title, User singer){
        for (Music music : allMusics){
            if (music.title.equals(title) && music.singer.equals(singer))
                return music;
        }
        return null;
    }
}
