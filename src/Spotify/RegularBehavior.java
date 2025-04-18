package Spotify;

import static Spotify.User.getAllUsers;

public class RegularBehavior implements UserBehavior{
    public int playingLimit = 5;

    @Override
    public void createPlaylist(String Title, User Owner) {
        throw new InvalidOperationException("Invalid behavior for regular user");
    }

    @Override
    public void playMusic(Music music) {
        if (playingLimit == 0){
            throw new InvalidOperationException("There is a limit for you");
        }
        if (!Music.allMusics.contains(music)){
            throw new InvalidOperationException("This music does not exist");
        }

        Music.play(music);
        playingLimit --;
    }

    @Override
    public void buyPremium(User owner, int month) {
        PremiumBehavior.monthValidator(month);
        Music.userValidator(owner);

        for (User user : getAllUsers()) {
             if (owner.equals(user)){
                 user.setBehavior(new PremiumBehavior(month));
             }
        }
    }
}
