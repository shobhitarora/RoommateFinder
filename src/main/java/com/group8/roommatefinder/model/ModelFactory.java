package com.group8.roommatefinder.model;

public class ModelFactory implements IModelFactory 
{

	private static ModelFactory modelFactoryInstance = null;

	public static ModelFactory instance() 
	{
		if (null == modelFactoryInstance) 
		{
			modelFactoryInstance = new ModelFactory();
		}
		return modelFactoryInstance;
	}

	@Override
	public UserProfile createUserProfileUsingBuilder(IUserProfileBuilder builder) 
	{

		return new UserProfile(builder);

	}

	@Override
	public IUserProfileBuilder createUserProfileBuilder() 
	{

		return new UserProfileBuilder();
	}

	@Override
	public Post createPostUsingBuilder(IPostBuilder postBuilder) 
	{
		return new Post(postBuilder);
	}

	@Override
	public IPostBuilder createPostBuilder() 
	{
		return new postBuilder();
	}

	@Override
	public Comment createCommentBuilder(ICommentBuilder builder) 
	{

		return new Comment(builder);
	}

	@Override
	public ICommentBuilder createCommentBuilder() 
	{

		return new CommentBuilder();
	}

	@Override
	public UserAccount createUserAccountUsingBuilder(IUserAccountBuilder userAccountBuilder) 
	{
		
		return new UserAccount(userAccountBuilder);
	}

	@Override
	public IUserAccountBuilder createUserAccountBuilder() 
	{
		
		return new UserAccountBuilder();
	}

}
