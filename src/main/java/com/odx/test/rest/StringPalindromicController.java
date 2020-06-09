package com.odx.test.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.odx.test.model.Palindrome;
import com.odx.test.repo.PalindromeRepository;

@RestController
public class StringPalindromicController {
	
	private final int REQUEST_MAX_LENGTH = 1000;
	
	@Autowired
	PalindromeRepository palindromeRepository;
	
	@PostMapping(path= "/stringPalindromic", consumes = "application/json", produces = "application/json")	
    public String persistPerson(@RequestBody String request) {  
		if(null != request && request.length() <= REQUEST_MAX_LENGTH) {
			Palindrome maxLenthPalindromic = longestPalSubstr(request);
			if(null != maxLenthPalindromic) {				
				palindromeRepository.save(maxLenthPalindromic);
				return maxLenthPalindromic.getMaxSubStringPalindrome();
			}else {
				return "Palindromic Strig not found in given request "+request;
			}			
		}
        return "requested string is more than 1000 charecters";
    }
	
	
	
	Palindrome longestPalSubstr(String str) { 
        int maxLength = 1; // The result (length of LPS) 
  
        int start = 0; 
        int len = str.length(); 
  
        int low, high; 
  
        // One by one consider every character as center 
        // point of even and length palindromes 
        for (int i = 1; i < len; ++i)  
        { 
            // Find the longest even length palindrome with  
            // center points as i-1 and i. 
            low = i - 1; 
            high = i; 
            while (low >= 0 && high < len  && str.charAt(low) == str.charAt(high)) { 
                if (high - low + 1 > maxLength) { 
                    start = low; 
                    maxLength = high - low + 1; 
                } 
                --low; 
                ++high; 
            } 
  
            // Find the longest odd length palindrome with  
            // center point as i 
            low = i - 1; 
            high = i + 1; 
            while (low >= 0 && high < len 
                    && str.charAt(low) == str.charAt(high)) { 
                if (high - low + 1 > maxLength) { 
                    start = low; 
                    maxLength = high - low + 1; 
                } 
                --low; 
                ++high; 
            } 
        } 
        Palindrome palindrome = null;
        if(maxLength > 1) {
        	String longestPalindromeSubStr = str.substring(start, (start + maxLength - 1) + 1);
        	palindrome = new Palindrome(longestPalindromeSubStr.length(),str,longestPalindromeSubStr);
        }        	
       
        return palindrome;
       
    } 

}
