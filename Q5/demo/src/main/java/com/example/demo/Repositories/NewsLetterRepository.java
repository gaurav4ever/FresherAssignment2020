package com.example.demo.Repositories;

import com.example.demo.Model.NewsLetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsLetterRepository extends JpaRepository<NewsLetter, Integer> {
//    List<NewsLetter> findByTitleContaingOrContentContaining(String text, String textAgain);
}
