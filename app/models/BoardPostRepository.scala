package models

import slick.jdbc.JdbcProfile
import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}
import java.time.Instant
import play.api.db.slick.DatabaseConfigProvider

@Singleton
class BoardPostRepository @Inject()(
  dbConfigProvider: DatabaseConfigProvider
)(implicit ec: ExecutionContext) {

  private val dbConfig = dbConfigProvider.get[JdbcProfile]
  import dbConfig._
  import profile.api._

  // テーブルスキーマを定義
  private class BoardPostTable(tag: Tag) extends Table[BoardPost](tag, "BOARD_POSTS") {
    def id        = column[Long]("ID", O.PrimaryKey, O.AutoInc)
    def name      = column[String]("NAME")
    def message   = column[String]("MESSAGE")
    def ipAddress = column[String]("IP_ADDRESS")
    def createdAt = column[Instant]("CREATED_AT")

    def * = (id.?, name, message, ipAddress, createdAt) <> (
      (BoardPost.apply _).tupled, 
      BoardPost.unapply
    )
  }

  private val query = TableQuery[BoardPostTable]

  /** 新規書き込み */
  def create(name: String, message: String, ipAddress: String): Future[BoardPost] = {
    val now = Instant.now()
    val newPost = BoardPost(None, name, message, ipAddress, now)
    val insertQuery = (query returning query.map(_.id) into ((post, id) => post.copy(id = Some(id)))) += newPost
    db.run(insertQuery)
  }

  /** 全投稿取得 (最新ID順) */
  def findAll(): Future[Seq[BoardPost]] =
    db.run(query.sortBy(_.id.desc).result)
}
