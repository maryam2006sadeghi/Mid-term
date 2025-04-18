package Spotify;

import static Spotify.User.getAllUsers;

public class PremiumBehavior implements UserBehavior{
    private int month;

    public PremiumBehavior(int month){
        this.month = month;
    }

    @Override
    public void createPlaylist(String Title, User Owner) {
        Playlist playlist = new Playlist(Title, Owner);
        playlist.setTitle(Title);

        for(User user : getAllUsers()){
            if(user.equals(Owner)){
                user.setPlaylists(playlist);
            }
        }
    }

    @Override
    public void playMusic(Music music) {
        Music.play(music);
    }

    @Override
    public void buyPremium(User owner, int month) {
         for (User user : getAllUsers()) {
             if (user.equals(owner)){
                 this.month += month;
             }
         }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
