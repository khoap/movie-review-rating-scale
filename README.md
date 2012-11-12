movie-review-rating-scale
=========================

Scaling Moving Review To Standard 5 Stars Review <br/>

<strong> Project Proposal: Classification of Online User Review and Five Stars Scaling </strong> <br/> <br/>
<strong> I. Motivation </strong> 
<p> As a part of my interest of recommendation system, the classification of online user reviews is also an important tool for some recommendation systems. In this project, I want to explore several methods that can not only classify a review as a good one or bad one, but also scale it into 5 stars rating scale.
The project will first investigate approaches using in the research of Bo Pang and Lillian Lee, "Seeing stars: Exploiting class relationships for sentiment categorization with respect to rating scales," and then comparing between Pang, and Lee's approaches to the approach using in this project.
</p>
<strong> II. Methods </strong> 

<p> In other to work on this projects, several tools will be using such as Support Vector Machines, Weka Toolkit, and the main programming language is Java.
Some of information extraction may be applied to preprocess the database; however, I still haven't understood how this can be used.
</p> 
<strong> III. Pilot Results </strong> 

Database <br/>
<p> The database using for the pilot results was the same one as Pang and Lee did in their research. The scaleset database can be found here: http://www.cs.cornell.edu/people/pabo/movie- review-data/ </p>

First approach 
<p> The first approach using to analyze the review in database was base on the #good-review- keywords divided by #bad-review-keywords. This ratio will then map to the 5 stars rating scale. </p>

<p> A review is:  </p>
<ul> 
  <li> 5 stars if ratio >= 2 </li>
  <li> 4 stars if 1.3 <= ratio < 2 </li>
  <li> 3 stars if 0.9 <= ratio < 1.3 </li>
  <li> 2 stars if 0.5 <= ratio < 0.9 </li>
  <li> 1 star if ratio < 0.5 </li>
</ul>
<p> The numbers are chosen based on the analysis of many reviews in the database. </p>