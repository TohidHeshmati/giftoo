package com.project.giftoo.repositories;

import com.project.giftoo.entities.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<WishList, Long> {
}
