package com.project.giftoo.clrunner;

import com.project.giftoo.entities.*;
import com.project.giftoo.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

@Component
public class EntityLoader implements CommandLineRunner {

    //TODO a very big todo here: separate different entities in methods and load them in DB. just simple hard work.

    private WishRepository wishRepository;
    private TagRepository tagRepository;
    private VoteRepository voteRepository;
    private WishListRepository wishListRepository;
    private CommentRepository commentRepository;
    private RoleRepository roleRepository;
    private UserRepository userRepository;

    public EntityLoader(
                        WishRepository wishRepository,
                        TagRepository tagRepository,
                        VoteRepository voteRepository,
                        WishListRepository wishListRepository,
                        CommentRepository commentRepository,
                        RoleRepository roleRepository,
                        UserRepository userRepository
    ) {
        this.wishRepository = wishRepository;
        this.tagRepository = tagRepository;
        this.voteRepository = voteRepository;
        this.wishListRepository = wishListRepository;
        this.commentRepository = commentRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("writing entities in DB");
        System.out.println("------------------------------------------------");
        loadUserAndRoles();
        System.out.println("user and roles written in DB");
        System.out.println("------------------------------------------------");

        Comment comment1 = new Comment("comment1");
        Comment comment2 = new Comment("comment2");
        Comment comment3 = new Comment("comment3");
        commentRepository.save(comment1);
        commentRepository.save(comment2);
        commentRepository.save(comment3);

        Wish wish1 = new Wish("wish1", (byte) 2);
        Wish wish2 = new Wish("wish2", (byte) 3);
        Wish wish3 = new Wish("wish3", (byte) 4);
        wish1.setComments(new ArrayList<>(){{add(comment1);add(comment2);}});

        wishRepository.save(wish1);
        wishRepository.save(wish2);
        wishRepository.save(wish3);

        WishList wishList1 = new WishList("wishList1");
        WishList wishList2 = new WishList("wishList1");
        WishList wishList3 = new WishList("wishList1");
        wishListRepository.save(wishList1);
        wishListRepository.save(wishList2);
        wishListRepository.save(wishList3);


    }

    private void loadUserAndRoles() {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("password"));
        String encoded = "{bcrypt}" + encoder.encode("password");
        System.out.println(encoded);

        Role userRole = new Role("ROLE_USER");
        roleRepository.save(userRole);

        Role adminRole = new Role("ROLE_ADMIN");
        roleRepository.save(adminRole);

        User user = new User("username", encoded);
        user.addRole(userRole);
        userRepository.save(user);

        User admin = new User("adminname", encoded);
        admin.addRole(adminRole);
        userRepository.save(admin);

        User superUser = new User("superuser", encoded);
        superUser.setRoles(new HashSet<>(Arrays.asList(userRole, adminRole)));
        userRepository.save(superUser);

    }
}
