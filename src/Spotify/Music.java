package Spotify;

import java.util.ArrayList;

public class Music {
    public String title;
    public User singer;
    public int numberOfStream;
    public static ArrayList<Music> allMusics = new ArrayList<>();

    public Music(String title, User singer){
        titleValidator(title);
        userValidator(singer);
        this.title = title;
        this.singer = singer;
        allMusics.add(this);
    }

    public static void play(Music music){
        if (!allMusics.contains(music)){
            throw new InvalidOperationException("This music does not exist");
        }

        for (Music m : allMusics){
            if (m.equals(music)){
                System.out.println("Music: " + m.title + "Singer: " + m.singer.getUsername() + "is playing");
                m.numberOfStream ++;
            }
        }
    }

    public static ArrayList<Music> search(String title){
        titleValidator(title);
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
        titleValidator(title);
        userValidator(singer);
        for (Music music : allMusics){
            if (music.title.equals(title) && music.singer.equals(singer))
                return music;
        }
        return null;
    }

    public static void userValidator(User user){
        if (!User.getAllUsers().contains(user)) {
            throw new InvalidOperationException("This user does not exist");
        }
    }
    public static void titleValidator(String title){
        if (title.isEmpty())
            throw new InvalidOperationException("Title can not be empty");
    }
}
