package controllers

import javax.inject._
import play.api._
import play.api.mvc._

import play.api.libs.json._
import play.api.libs.functional.syntax._

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
  def ping() = Action { _ => Ok("Pingy string. Very Web 1.0") }

  // Return JSON.
  def jing() = Action { _ =>
    Ok(
      Json.obj(
        "hello" -> "world",
        "magic number" -> 23,
        "working" -> true
      )
    )
  }

  // Return API request data.
  def echo(anything: String) = Action { _ =>
    Ok(
      Json.obj(
        "echo" -> anything,
        "working" -> true
      )
    )
  }

  // Handle post request.

  def postBox = Action { implicit request =>
    println("Got it")
    val body : AnyContent = request.body
    val jsonBody : Option[JsValue] = body.asJson

    jsonBody.foreach(x => println(x))
   
    //val incomingKeys = jsonBody.map[String](println(_))

    jsonBody.foreach(println)

    Ok(
      Json.obj(
        "got" -> jsonBody,
        "working" -> true
      )
    )
  }

}
