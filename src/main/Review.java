package main;

/*
 *  Review Class.
 *  Author: Khoa Pham - khoa.pham@me.com - all rights reserved.
 */
public class Review {
	String author;
	String reviewID;
	int totalWords;
	int goodWords;
	int badWords;
	float reviewRate;	
	String reviewStar;
	
	public Review() {}
	public Review(String author, String reviewID, int totalWords, int goodWords, int badWords, float reviewRate, String reviewStar) {
		this.author = author;
		this.reviewID = reviewID;
		this.totalWords = totalWords;
		this.goodWords = goodWords;
		this.badWords = badWords;
		this.reviewRate = reviewRate;
		this.reviewStar = reviewStar;
	}
}
