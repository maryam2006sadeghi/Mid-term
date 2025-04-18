package Spotify;

import java.util.ArrayList;

public class User {
    private final String username;
    private final String password;
    private ArrayList<User> followerList = new ArrayList<>();
    private ArrayList<User> followingList = new ArrayList<>();
    public UserBehavior behavior ;
    private ArrayList<Playlist> playlists = new ArrayList<>();
    private static ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String password){
        if (username.isEmpty()){
            throw new InvalidOperationException("username can not be empty");
        }
        if (password.length() < 8){
            throw new InvalidOperationException("Invalid length for password");
        }
        this.username = username;
        this.password = password;
        this.behavior = new RegularBehavior();
        allUsers.add(this);
    }

    public void follow(User user){
        if(followingList.contains(user))
            throw new InvalidOperationException("This user is already exist in following list");
        else{
            followingList.add(user);
        }

        if(followerList.contains(this))
            throw new InvalidOperationException("This user is already exist in follower list");
        else {
            followerList.add(this);
        }
    }

    public void createPlaylist(String Title){
        this.behavior.createPlaylist(Title, this);
    }

    public void playMusic(Music music){
        this.behavior.playMusic(music);
    }

    public void buyPremium(int month){
        this.behavior.buyPremium(this, month);
    }

    public static ArrayList<User> getAllUsers(){
        return allUsers;
    }

    public String getPassword(){
        return password;
    }

    public void setBehavior(UserBehavior behavior) {
        this.behavior = behavior;
    }

    public void setPlaylists(Playlist playlist) {
        playlists.add(playlist);
    }

    public ArrayList<Playlist> getPlaylist(){
        return playlists;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<User> getFollowingList() {
        return followingList;
    }

    public ArrayList<User> getFollowerList(){
        return followerList;
    }
}
