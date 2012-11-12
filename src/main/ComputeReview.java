package main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Vector;
import io.*;

/*
 * ComputeReview Class: containing several methods to compute the number of good review keywords and bad review keywords.
 * Then map it into the 5 stars scaling.
 * Author: Khoa Pham - khoa.pham@me.com - all rights reserved.
 */
public class ComputeReview {
	public ComputeReview() {}
	IO io = new IO();
	BoyerMoore boyermoore = new BoyerMoore();
	
	/*
	 * Define two static review keywords arrasy.
	 */
	public static final String[] badReviewKeywords = new String[] {"bad","cheap", "stupid", "unbearable",
		"horrible", "aweful", "worst", "worse", "hate", "waste", "hated", "no","not",
		"garbage","dumb","never","nonsense","no stars","nonsensible","doesn't","leave","don't",
		"aren't","isn't", "inappropriate"};
	public static final String[] goodReviewKeywords = new String[] {"good","best", "fine", "OK",
		"awesome", "great", "kind", "average", "enjoy", "enjoyable", "remarkable", "wonderful","beautiful",
		"relax","fun","happy","love","laughing","laugh","top","creative","amazing",
		"perfect","amaze", "fantastic"};
	
	/*
	 * Get the good review keywords by scanning a review and find a matching pattern using boyermoore method.
	 */
	public int getGoodReviewKeywords(String Review) {
		int numberOfGoodReviewKeywordsInReview = 1; //Any review starts from 1 good review keywords for smoothing purpose.
		for(int i = 0; i < goodReviewKeywords.length; i++) {
			numberOfGoodReviewKeywordsInReview += boyermoore.numberOfPatternFound(boyermoore.searchForPattern(goodReviewKeywords[i], Review));
		}
		return numberOfGoodReviewKeywordsInReview;
	}
	/*
	 * Get the bad review keywords by scanning a review and find a matching pattern using boyermoore method.
	 */
	public int getBadReviewKeywords(String Review) {
		int numberOfBadReviewKeywordsInReview = 1; //Any review starts from 1 good review keywords for smoothing purpose.
		for(int i = 0; i < badReviewKeywords.length; i++) {
			numberOfBadReviewKeywordsInReview += boyermoore.numberOfPatternFound(boyermoore.searchForPattern(badReviewKeywords[i], Review));
		}
		return numberOfBadReviewKeywordsInReview;
	}
	
	/*
	 * For each review, we get the #goodReviewKeywords, #badReviewKeywords, and reviewRate; then add it to the ReviewNode.
	 * Each ReviewNode will be added to the ReviewList.
	 */
	public Vector<Review> getReviewList(Vector<String> storedData) {
		Vector<Review> reviewList = new Vector<Review>();
		for(int i = 0; i < storedData.size(); i++) {
			String reviewString = storedData.elementAt(i);
			int numberOfBadReviewKeywordsInReview = this.getBadReviewKeywords(reviewString);
			int numberOfGoodReviewKeywordsInReview = this.getGoodReviewKeywords(reviewString);
			float reviewRate = numberOfGoodReviewKeywordsInReview / (float)numberOfBadReviewKeywordsInReview;
			String reviewStar = this.convertReviewRateToStar(reviewRate);
			Review reviewNode = new Review(null, null, reviewString.length(), numberOfGoodReviewKeywordsInReview,
											numberOfBadReviewKeywordsInReview, reviewRate, reviewStar);
			reviewList.add(reviewNode);
		}
		return reviewList;
	}
	/*
	 * Maping the review rate to 5 stars scaling.
	 */
	public String convertReviewRateToStar(float reviewRate) {
		if(reviewRate >= 2) {
			return "*****";
		}
		if (reviewRate >= 1.3 && reviewRate < 2) {
			return "****";
		}
		if(reviewRate >= 0.9 && reviewRate < 1.3) {
			return "***";
		}
		if(reviewRate >= 0.5 && reviewRate < 0.9) {
			return "**";
		}
		return "*";
	}
	/*
	 * Print out the review scales.
	 */
	public void printReviewStar(Vector<Review> reviewList) {
		for(int i = 0; i < reviewList.size(); i++) {
			System.out.println(reviewList.elementAt(i).reviewStar);
		}
	}
	public static void main(String args[]) throws IOException {
		IO io = new IO();
		ComputeReview computeReview = new ComputeReview();
		final String output = System.getProperty("user.dir") + ("/scale_data/scaledata/SteveRhodes/output.txt");
		final String filename = System.getProperty("user.dir") + ("/scale_data/scaledata/SteveRhodes/subj.SteveRhodes");
		Vector<String> storedData = io.readFile(filename);
		Vector<Review> reviewList = computeReview.getReviewList(storedData);
		PrintStream pst = new PrintStream(new FileOutputStream(output));
		io.printStream(pst);
		computeReview.printReviewStar(reviewList);
		System.out.println();
		io.closeStream(pst);
	}
}
