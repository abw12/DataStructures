package SOLID.LSP;

//since Instagram does not support the groupVideoCall feature it is of no use implements its method
//also now we implement all the parent method of Instagram via SocialMedia,PostPhotos interface
// so Instagram have become the substitute of the parent hence follows the Liskov's Substitution Principle
public class Instagram implements SocialMedia,PostPhotos{
    @Override
    public void postPictures() {

    }

    @Override
    public void chatWithFriends() {

    }

    @Override
    public void sendVideosPhotos(String... media) {

    }
}
