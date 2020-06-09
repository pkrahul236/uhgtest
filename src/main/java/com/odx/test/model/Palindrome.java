package com.odx.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Palindrome {
	
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column  
	private int id;
	

	@Column
	private int maxSubStringPalindromeLength;
	
	@Column
	private String request;
	
	@Column
	private String maxSubStringPalindrome;
	
	public Palindrome() {}
	
	public Palindrome(int maxSubStringPalindromeLength,String request,String maxSubStringPalindrome) {
		this.maxSubStringPalindromeLength = maxSubStringPalindromeLength;
		this.request = request;
		this.maxSubStringPalindrome = maxSubStringPalindrome;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaxSubStringPalindromeLength() {
		return maxSubStringPalindromeLength;
	}

	public void setMaxSubStringPalindromeLength(int maxSubStringPalindromeLength) {
		this.maxSubStringPalindromeLength = maxSubStringPalindromeLength;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getMaxSubStringPalindrome() {
		return maxSubStringPalindrome;
	}

	public void setMaxSubStringPalindrome(String maxSubStringPalindrome) {
		this.maxSubStringPalindrome = maxSubStringPalindrome;
	}
	
	

}
