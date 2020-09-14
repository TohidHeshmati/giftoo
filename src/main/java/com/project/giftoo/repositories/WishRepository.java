package com.project.giftoo.repositories;

import com.project.giftoo.entities.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishRepository extends JpaRepository<Wish, Long> {
}
