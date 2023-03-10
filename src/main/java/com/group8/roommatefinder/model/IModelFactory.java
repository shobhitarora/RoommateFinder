
package com.group8.roommatefinder.model;

public interface IModelFactory {

    public UserProfile createUserProfileUsingBuilder(IUserProfileBuilder userProfileBuilder);
    public IUserProfileBuilder createUserProfileBuilder();
    public Comment createCommentBuilder(ICommentBuilder commentBuilder);
    public ICommentBuilder createCommentBuilder();
    public Post createPostUsingBuilder(IPostBuilder postBuilder);
    public IPostBuilder createPostBuilder();
    public UserAccount createUserAccountUsingBuilder(IUserAccountBuilder userAccountBuilder);
    public IUserAccountBuilder createUserAccountBuilder();
    
}
