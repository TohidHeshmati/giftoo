package com.project.giftoo.repositories;

import com.project.giftoo.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
