package com.douban.models

import java.util.Date
import com.douban.common.Req
import Req._
import java.util.List

/**
 * Copyright by <a href="http://www.josephjctang.com"><em><i>Joseph J.C. Tang</i></em></a> <br/>
 * Email: <a href="mailto:jinntrance@gmail.com">jinntrance@gmail.com</a><br/>
 * <em>see:</em><br/>
 * <a href="http://developers.douban.com/wiki/?title=movie_v2">豆瓣电影API</a>
 * @author joseph
 * @since 1/10/13 1:55 PM
 * @version 1.0
 */

object Movie extends BookMovieMusicAPI[Movie, MovieSearchResult, MovieReview] {
  protected def url_prefix = api_prefix + "movie/"

  private val byImdbUrl = url_prefix + "imdb/%s"

  def byImdb(imdb: String) = get[Movie](byImdbUrl.format(imdb))


}

case class Author(name: String)  extends Bean

case class MovieAttribute(language: List[String], pubdate: List[String], title: List[String], country: List[String], writer: List[String], director: List[String], cast: List[String], movie_duration: List[String], year: List[String], movie_type: List[String])  extends Bean

case class MovieReview(id: Long, title: String, alt: String, author: User, movie: Movie, rating: ReviewRating,
                       votes: Int, useless: Int, comments: Int, summary: String, published: Date, updated: Date)
  extends Review(id, title, alt, author, rating, votes, useless, comments, summary, published, updated)

case class Movie(id: String, title: String, author: List[Author], image: String, rating: ItemRating, summary: String, tags: List[Tag], alt: String, alt_title: String, mobile_link: String, attrs: MovieAttribute)  extends Bean

/**
 *
 * @param movie 电影id
 * @param title 标题
 * @param content 内容
 * @param rating  打分1-5
 */
case class MovieReviewPosted(movie: String, title: String, content: String, rating: Int = 0) extends ReviewPosted(title, content, rating)

case class MovieSearchResult(start: Int, count: Int, total: Int, movies: List[Movie]) extends ListResult(start,count,total)
