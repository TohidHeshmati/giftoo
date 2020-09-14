package com.project.giftoo.clrunner;

import com.project.giftoo.entities.Comment;
import com.project.giftoo.entities.Tag;
import com.project.giftoo.entities.Wish;
import com.project.giftoo.entities.WishList;
import com.project.giftoo.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EntityLoader implements CommandLineRunner {

    private WishRepository wishRepository;
    private TagRepository tagRepository;
    private VoteRepository voteRepository;
    private WishListRepository wishListRepository;
    private CommentRepository commentRepository;

    public EntityLoader(
                        WishRepository wishRepository,
                        TagRepository tagRepository,
                        VoteRepository voteRepository,
                        WishListRepository wishListRepository,
                        CommentRepository commentRepository
    ) {
        this.wishRepository = wishRepository;
        this.tagRepository = tagRepository;
        this.voteRepository = voteRepository;
        this.wishListRepository = wishListRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("writing entities in DB");
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
}
