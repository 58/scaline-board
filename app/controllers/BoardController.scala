package controllers

import javax.inject._
import play.api.mvc._
import scala.concurrent.ExecutionContext
import models.BoardPostRepository

@Singleton
class BoardController @Inject()(
  cc: MessagesControllerComponents,
  boardPostRepo: BoardPostRepository
)(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

  // 一覧表示
  def index() = Action.async { implicit request =>
    boardPostRepo.findAll().map { posts =>
      Ok(views.html.index(posts))
    }
  }

  // 投稿フォームの処理
  def post() = Action.async { implicit request =>
    val formData = request.body.asFormUrlEncoded
    val name     = formData.flatMap(_.get("name").flatMap(_.headOption)).filter(_.nonEmpty).getOrElse("名無し")
    val message  = formData.flatMap(_.get("message").flatMap(_.headOption)).getOrElse("")
    val ip       = request.remoteAddress

    boardPostRepo.create(name, message, ip).map { _ =>
      Redirect(routes.BoardController.index())
    }
  }
}
