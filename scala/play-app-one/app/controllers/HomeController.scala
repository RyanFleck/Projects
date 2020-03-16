package controllers

import javax.inject._
import play.api._
import play.api.mvc._

import play.api.libs.json._

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject() (val controllerComponents: ControllerComponents)
    extends BaseController {

  /**
    * Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  // Return text data.
  def ping() = Action { implicit request => Ok("Pingy string. Very Web 1.0") }

  // Return JSON.
  def jing() = Action { implicit request =>
    Ok(
      Json.obj(
        "hello" -> "world",
        "magic number" -> 23,
        "working" -> true
      )
    )
  }
}
