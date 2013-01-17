package com.douban.models

import com.douban.common.BaseTest

/**
 * Copyright by <a href="http://crazyadam.net"><em><i>Joseph J.C. Tang</i></em></a> <br/>
 * Email: <a href="mailto:jinntrance@gmail.com">jinntrance@gmail.com</a>
 * @author joseph
 * @since 1/10/13 8:18 PM
 * @version 1.0
 */
class MovieTest extends BaseTest {
  val movieId = "2994851"
  val imdb = "tt1847713"
  val content = "《网络至死:如何在喧嚣的互联网时代重获我们的创造力和思维力》内容简介：我们也许已经晓悟，但也许并未察觉，我们正陷入空前的“网络统治一切”的危机之中，就像赫胥黎在《美丽新世界》中忧虑的那样，人们会渐渐爱上压迫，崇拜那些使他们丧失思考能力的技术，而现在这技术等同于网络。我们越来越依赖虚拟世界——网络所创造的一切，人们已经无法想象没有电脑、没有网络的生活，我们好像患上了某种强迫症，一遍遍地刷新网页，而短暂的断网也使我们心绪不宁。注意力极易分散，记忆力严重退化，想象力和创造力被极度扼杀……我们在网络越来越强大的信息世界面前，越来越措手不及，越来越被机器所主宰。"
  test("tesing movie byId") {
    prettyJSON(Movie.byId(movieId))
  }
  test("tesing movie search") {
    prettyJSON(Movie.search("Love", ""))
  }
  test("tesing movie popTags") {
    prettyJSON(Movie.popTags(movieId))
  }
  test("tesing movie tags") {
    prettyJSON(Movie.tags(userId))
  }
  test("tesing movie by imdb") {
    prettyJSON(Movie.byImdb(imdb))
  }
  test("tesing movie review") {
    val r = Movie.postReview(new MovieReviewPosted(movieId, "Test", content, 5))
    prettyJSON(r)
    prettyJSON(Movie.updateReview(r.id, new MovieReviewPosted("", "Test", content, 4)))
    prettyJSON(Movie.deleteReview(r.id))
  }

}
