package com.ezbytes.cards.repository;

import com.ezbytes.cards.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardsRepository extends JpaRepository<CardEntity, Long> {

    List<CardEntity> findByCustomerId(int customerId);

}
