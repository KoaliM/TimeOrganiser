package dto;

import org.example.timeorganiser.model.Users;

public class FriendsDTO {
    public Users user = null;
    public Users friend = null;

    public Users getUser(){
        return user;
    };
    public void setUser(Users user){
        this.user = user;
    };
    public Users getFriend(){
        return friend;
    };
    public void setFriend(Users friend){
        this.friend = friend;
    };

}
