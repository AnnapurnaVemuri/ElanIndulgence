// @SOURCE:/home/sowmya/git/ElanIndulgence/conf/routes
// @HASH:a20c8e7dba78d808ec836645ecef4cf94a75c306
// @DATE:Mon Dec 22 17:38:56 EST 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_loadMain0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:9
private[this] lazy val controllers_Application_registerUser1 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("register"))))
        

// @LINE:12
private[this] lazy val controllers_Application_loginValidation2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:15
private[this] lazy val controllers_Application_getUser3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user"))))
        

// @LINE:18
private[this] lazy val controllers_Application_registerMerchant4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("merreg"))))
        

// @LINE:21
private[this] lazy val controllers_Application_merchantValidation5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("merval"))))
        

// @LINE:24
private[this] lazy val controllers_Application_saveUserPreferences6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("savepref"))))
        

// @LINE:27
private[this] lazy val controllers_Application_getMerchant7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("merchant"))))
        

// @LINE:30
private[this] lazy val controllers_RecoDB_getLatestProducts8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("newarrivals"))))
        

// @LINE:33
private[this] lazy val controllers_Application_loadProduct9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("product"))))
        

// @LINE:36
private[this] lazy val controllers_RecoDB_getLatestProductsForUser10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("unewarr"))))
        

// @LINE:39
private[this] lazy val controllers_Application_loadUserProduct11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("uproduct"))))
        

// @LINE:42
private[this] lazy val controllers_FilterDB_getProductByProdTypeAndRatingWithoutColor12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("prodTy"))))
        

// @LINE:45
private[this] lazy val controllers_Assets_at13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.loadMain()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """register""","""controllers.Application.registerUser()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.loginValidation()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user""","""controllers.Application.getUser(q:String, r:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """merreg""","""controllers.Application.registerMerchant()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """merval""","""controllers.Application.merchantValidation()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """savepref""","""controllers.Application.saveUserPreferences()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """merchant""","""controllers.Application.getMerchant(u:String, p:Integer)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """newarrivals""","""controllers.RecoDB.getLatestProducts(p:Integer)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """product""","""controllers.Application.loadProduct(p:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """unewarr""","""controllers.RecoDB.getLatestProductsForUser(p:Integer, u:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """uproduct""","""controllers.Application.loadUserProduct(p:String, u:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """prodTy""","""controllers.FilterDB.getProductByProdTypeAndRatingWithoutColor(t:Integer, p:Integer)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_loadMain0(params) => {
   call { 
        invokeHandler(controllers.Application.loadMain(), HandlerDef(this, "controllers.Application", "loadMain", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:9
case controllers_Application_registerUser1(params) => {
   call { 
        invokeHandler(controllers.Application.registerUser(), HandlerDef(this, "controllers.Application", "registerUser", Nil,"POST", """ User registration""", Routes.prefix + """register"""))
   }
}
        

// @LINE:12
case controllers_Application_loginValidation2(params) => {
   call { 
        invokeHandler(controllers.Application.loginValidation(), HandlerDef(this, "controllers.Application", "loginValidation", Nil,"POST", """ Login validation""", Routes.prefix + """login"""))
   }
}
        

// @LINE:15
case controllers_Application_getUser3(params) => {
   call(params.fromQuery[String]("q", None), params.fromQuery[String]("r", None)) { (q, r) =>
        invokeHandler(controllers.Application.getUser(q, r), HandlerDef(this, "controllers.Application", "getUser", Seq(classOf[String], classOf[String]),"GET", """ Go to user page""", Routes.prefix + """user"""))
   }
}
        

// @LINE:18
case controllers_Application_registerMerchant4(params) => {
   call { 
        invokeHandler(controllers.Application.registerMerchant(), HandlerDef(this, "controllers.Application", "registerMerchant", Nil,"POST", """ Merchant registration""", Routes.prefix + """merreg"""))
   }
}
        

// @LINE:21
case controllers_Application_merchantValidation5(params) => {
   call { 
        invokeHandler(controllers.Application.merchantValidation(), HandlerDef(this, "controllers.Application", "merchantValidation", Nil,"POST", """ Merchant validation""", Routes.prefix + """merval"""))
   }
}
        

// @LINE:24
case controllers_Application_saveUserPreferences6(params) => {
   call { 
        invokeHandler(controllers.Application.saveUserPreferences(), HandlerDef(this, "controllers.Application", "saveUserPreferences", Nil,"POST", """ Add user preferences""", Routes.prefix + """savepref"""))
   }
}
        

// @LINE:27
case controllers_Application_getMerchant7(params) => {
   call(params.fromQuery[String]("u", None), params.fromQuery[Integer]("p", None)) { (u, p) =>
        invokeHandler(controllers.Application.getMerchant(u, p), HandlerDef(this, "controllers.Application", "getMerchant", Seq(classOf[String], classOf[Integer]),"GET", """ Go to merchant page""", Routes.prefix + """merchant"""))
   }
}
        

// @LINE:30
case controllers_RecoDB_getLatestProducts8(params) => {
   call(params.fromQuery[Integer]("p", None)) { (p) =>
        invokeHandler(controllers.RecoDB.getLatestProducts(p), HandlerDef(this, "controllers.RecoDB", "getLatestProducts", Seq(classOf[Integer]),"GET", """ Get latest products""", Routes.prefix + """newarrivals"""))
   }
}
        

// @LINE:33
case controllers_Application_loadProduct9(params) => {
   call(params.fromQuery[String]("p", None)) { (p) =>
        invokeHandler(controllers.Application.loadProduct(p), HandlerDef(this, "controllers.Application", "loadProduct", Seq(classOf[String]),"GET", """ Load product details""", Routes.prefix + """product"""))
   }
}
        

// @LINE:36
case controllers_RecoDB_getLatestProductsForUser10(params) => {
   call(params.fromQuery[Integer]("p", None), params.fromQuery[String]("u", None)) { (p, u) =>
        invokeHandler(controllers.RecoDB.getLatestProductsForUser(p, u), HandlerDef(this, "controllers.RecoDB", "getLatestProductsForUser", Seq(classOf[Integer], classOf[String]),"GET", """ Get latest products for a user""", Routes.prefix + """unewarr"""))
   }
}
        

// @LINE:39
case controllers_Application_loadUserProduct11(params) => {
   call(params.fromQuery[String]("p", None), params.fromQuery[String]("u", None)) { (p, u) =>
        invokeHandler(controllers.Application.loadUserProduct(p, u), HandlerDef(this, "controllers.Application", "loadUserProduct", Seq(classOf[String], classOf[String]),"GET", """ Get product page for a user""", Routes.prefix + """uproduct"""))
   }
}
        

// @LINE:42
case controllers_FilterDB_getProductByProdTypeAndRatingWithoutColor12(params) => {
   call(params.fromQuery[Integer]("t", None), params.fromQuery[Integer]("p", None)) { (t, p) =>
        invokeHandler(controllers.FilterDB.getProductByProdTypeAndRatingWithoutColor(t, p), HandlerDef(this, "controllers.FilterDB", "getProductByProdTypeAndRatingWithoutColor", Seq(classOf[Integer], classOf[Integer]),"GET", """ Get products by product type filter""", Routes.prefix + """prodTy"""))
   }
}
        

// @LINE:45
case controllers_Assets_at13(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     