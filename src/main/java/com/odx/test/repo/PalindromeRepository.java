package com.odx.test.repo;

import org.springframework.stereotype.Repository;

import com.odx.test.model.Palindrome;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface PalindromeRepository extends CrudRepository<Palindrome,Integer>{

}
