package com.monolithic.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.monolithic.bean.Post;
import com.monolithic.bean.User;
import com.monolithic.repo.PostRepository;
import com.monolithic.repo.UserRepository;

@Component
public class UserData implements CommandLineRunner {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PostRepository postRepo;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User("Arun", 25, 1234567890l, "arun@gmail.com");
		User u2 = new User("Rahul", 18, 1212343423l, "rahul@gmail.com");
		User u3 = new User("Rohit", 23, 9097782343l, "rohit@gmail.com");
		User u4 = new User("Ajay", 29, 9978564567L, "ajay@gmail.com");
		User u5 = new User("Amar", 26, 9996757678L, "amar@gmail.com");

		Post p1 = new Post("This is comment no- 1");
		p1.setUser(u1);

		Post p2 = new Post("This is comment no- 2");
		p2.setUser(u2);
		
		Post p3 = new Post("This is comment no- 3");
		p3.setUser(u3);
		
		Post p4 = new Post("This is comment no- 4");
		p4.setUser(u4);
		
		Post p5 = new Post("This is comment no- 5");
		p5.setUser(u5);
		
		Post p6 = new Post("This is comment no- 6");
		p6.setUser(u4);
		
		Post p7 = new Post("This is comment no- 7");
		p7.setUser(u2);
		
		Post p8 = new Post("This is comment no- 8");
		p8.setUser(u1);
		
		List<User> users = List.of(u1,u2,u3,u4,u5);
		List<Post> posts = List.of(p1,p2,p3,p4,p5,p6,p7,p8);
		userRepo.saveAll(users);
		
		postRepo.saveAll(posts);
	}

}
