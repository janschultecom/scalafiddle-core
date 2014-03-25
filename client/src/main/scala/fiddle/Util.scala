package fiddle

import org.scalajs.dom
import scala.concurrent.Future

/**
 * Created by haoyi on 3/25/14.
 */
object Util {
  object Form{
    def post(path: String, args: (String, String)*): Unit = {
      ajax("post", path, args:_*)
    }
    def get(path: String, args: (String, String)*): Unit = {
      ajax("get", path, args:_*)
    }
    def ajax(method: String, path: String, args: (String, String)*): Unit = {
      val form = dom.document.createElement("form").asInstanceOf[dom.HTMLFormElement]
      form.setAttribute("method", method)
      form.setAttribute("action", path)

      for((k, v) <- args){
        val hiddenField = dom.document.createElement("input")
        hiddenField.setAttribute("type", "hidden")
        hiddenField.setAttribute("name", k)
        hiddenField.setAttribute("value", v)
        form.appendChild(hiddenField)
      }

      dom.document.body.appendChild(form)
      form.submit()
    }
  }
}