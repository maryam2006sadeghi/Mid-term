package Spotify;

import static Spotify.User.getAllUsers;

public class PremiumBehavior implements UserBehavior{
    private int month;

    public PremiumBehavior(int month){
        monthValidator(month);
        this.month = month;
    }

    @Override
    public void createPlaylist(String Title, User Owner) {
        Music.titleValidator(Title);
        Music.userValidator(Owner);

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
        if (!Music.allMusics.contains(music)){
            throw new InvalidOperationException("This music does not exist");
        }

        Music.play(music);
    }

    @Override
    public void buyPremium(User owner, int month) {
        monthValidator(month);
        Music.userValidator(owner);

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
        monthValidator(month);
        this.month = month;
    }

    public static void monthValidator(int month){
        if (month < 0)
            throw new InvalidOperationException("Month must be positive");
    }
}
