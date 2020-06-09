drop table if exists Palindrome;
create table Palindrome(
id int AUTO_INCREMENT  primary key,
maxSubStringPalindromeLength int,
request varchar(1000) NOT NULL,
maxSubStringPalindrome varchar(1000) NULL
);