package com.shareExp.backend.repository;

import com.shareExp.backend.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
  //  Optional<List<Experience>> findAllByUserId(long id);

    //Optional<List<Experience>> findAllOffersByUserFirstNameAndCoachLastName(String firstName, String lastName);

}
