package Spotify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Playlist {
    private String title;
    private static ArrayList<Music> playlist = new ArrayList<>();
    private User owner;

    public Playlist(String title, User owner){
        Music.titleValidator(title);
        this.title = title;
        this.owner = owner;
    }

    public void editTitle(String title, String password){
        Music.titleValidator(title);
        passwordValidator(password);
        this.title = title;
    }

    public void addMusic(Music music, String password){
        passwordValidator(password);
        if (!Music.allMusics.contains(music)){
            throw new InvalidOperationException("This music does not exist");
        }
        playlist.add(music);
    }

    public void removeMusic(Music music, String password){
        passwordValidator(password);
        if (!Music.allMusics.contains(music)){
            throw new InvalidOperationException("This music does not exist");
        }
        Music.allMusics.remove(music);
    }

    public static ArrayList<Music> searchInPlaylist(String title){
        Music.titleValidator(title);
        ArrayList<Music> musics = new ArrayList<>();
        for (Music music : playlist)
        {
            if (music.title.equals(title)){
                musics.add(music);
            }
        }
        if (musics.isEmpty())
            return null;
        return musics;
    }

    public static Music searchInPlaylist(String title, User singer){
        Music.titleValidator(title);
        Music.userValidator(singer);
        for (Music music : playlist){
            if (music.title.equals(title) && music.singer.equals(singer))
                return music;
        }
        return null;
    }

    public static void playPlaylist(){
        for (Music music : playlist){
            Music.play(music);
        }
    }

    public static void shufflePlaylist(){
        Collections.shuffle(playlist, new Random());
        playPlaylist();
    }

    public void setTitle(String title) {
        Music.titleValidator(title);
        this.title = title;
    }

    public static ArrayList<Music> getPlaylist(){
        return playlist;
    }

    public void passwordValidator(String password){
        if (!owner.getPassword().equals(password)){
            throw new InvalidOperationException("Invalid password");
        }
    }

}
