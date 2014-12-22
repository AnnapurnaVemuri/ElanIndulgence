// @SOURCE:/home/sowmya/git/ElanIndulgence/conf/routes
// @HASH:a20c8e7dba78d808ec836645ecef4cf94a75c306
// @DATE:Mon Dec 22 17:38:56 EST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:45
// @LINE:42
// @LINE:39
// @LINE:36
// @LINE:33
// @LINE:30
// @LINE:27
// @LINE:24
// @LINE:21
// @LINE:18
// @LINE:15
// @LINE:12
// @LINE:9
// @LINE:6
package controllers {

// @LINE:45
class ReverseAssets {
    

// @LINE:45
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:42
class ReverseFilterDB {
    

// @LINE:42
def getProductByProdTypeAndRatingWithoutColor(t:Integer, p:Integer): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "prodTy" + queryString(List(Some(implicitly[QueryStringBindable[Integer]].unbind("t", t)), Some(implicitly[QueryStringBindable[Integer]].unbind("p", p)))))
}
                                                
    
}
                          

// @LINE:36
// @LINE:30
class ReverseRecoDB {
    

// @LINE:30
def getLatestProducts(p:Integer): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "newarrivals" + queryString(List(Some(implicitly[QueryStringBindable[Integer]].unbind("p", p)))))
}
                                                

// @LINE:36
def getLatestProductsForUser(p:Integer, u:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "unewarr" + queryString(List(Some(implicitly[QueryStringBindable[Integer]].unbind("p", p)), Some(implicitly[QueryStringBindable[String]].unbind("u", u)))))
}
                                                
    
}
                          

// @LINE:39
// @LINE:33
// @LINE:27
// @LINE:24
// @LINE:21
// @LINE:18
// @LINE:15
// @LINE:12
// @LINE:9
// @LINE:6
class ReverseApplication {
    

// @LINE:21
def merchantValidation(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "merval")
}
                                                

// @LINE:12
def loginValidation(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                                                

// @LINE:9
def registerUser(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "register")
}
                                                

// @LINE:6
def loadMain(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:15
def getUser(q:String, r:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("q", q)), Some(implicitly[QueryStringBindable[String]].unbind("r", r)))))
}
                                                

// @LINE:33
def loadProduct(p:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "product" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("p", p)))))
}
                                                

// @LINE:39
def loadUserProduct(p:String, u:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "uproduct" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("p", p)), Some(implicitly[QueryStringBindable[String]].unbind("u", u)))))
}
                                                

// @LINE:18
def registerMerchant(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "merreg")
}
                                                

// @LINE:27
def getMerchant(u:String, p:Integer): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "merchant" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("u", u)), Some(implicitly[QueryStringBindable[Integer]].unbind("p", p)))))
}
                                                

// @LINE:24
def saveUserPreferences(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "savepref")
}
                                                
    
}
                          
}
                  


// @LINE:45
// @LINE:42
// @LINE:39
// @LINE:36
// @LINE:33
// @LINE:30
// @LINE:27
// @LINE:24
// @LINE:21
// @LINE:18
// @LINE:15
// @LINE:12
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:45
class ReverseAssets {
    

// @LINE:45
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:42
class ReverseFilterDB {
    

// @LINE:42
def getProductByProdTypeAndRatingWithoutColor : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.FilterDB.getProductByProdTypeAndRatingWithoutColor",
   """
      function(t,p) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "prodTy" + _qS([(""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("t", t), (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("p", p)])})
      }
   """
)
                        
    
}
              

// @LINE:36
// @LINE:30
class ReverseRecoDB {
    

// @LINE:30
def getLatestProducts : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RecoDB.getLatestProducts",
   """
      function(p) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "newarrivals" + _qS([(""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("p", p)])})
      }
   """
)
                        

// @LINE:36
def getLatestProductsForUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RecoDB.getLatestProductsForUser",
   """
      function(p,u) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "unewarr" + _qS([(""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("p", p), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("u", u)])})
      }
   """
)
                        
    
}
              

// @LINE:39
// @LINE:33
// @LINE:27
// @LINE:24
// @LINE:21
// @LINE:18
// @LINE:15
// @LINE:12
// @LINE:9
// @LINE:6
class ReverseApplication {
    

// @LINE:21
def merchantValidation : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.merchantValidation",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "merval"})
      }
   """
)
                        

// @LINE:12
def loginValidation : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.loginValidation",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:9
def registerUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.registerUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
      }
   """
)
                        

// @LINE:6
def loadMain : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.loadMain",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:15
def getUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getUser",
   """
      function(q,r) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("q", q), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("r", r)])})
      }
   """
)
                        

// @LINE:33
def loadProduct : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.loadProduct",
   """
      function(p) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "product" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("p", p)])})
      }
   """
)
                        

// @LINE:39
def loadUserProduct : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.loadUserProduct",
   """
      function(p,u) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "uproduct" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("p", p), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("u", u)])})
      }
   """
)
                        

// @LINE:18
def registerMerchant : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.registerMerchant",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "merreg"})
      }
   """
)
                        

// @LINE:27
def getMerchant : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getMerchant",
   """
      function(u,p) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "merchant" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("u", u), (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("p", p)])})
      }
   """
)
                        

// @LINE:24
def saveUserPreferences : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.saveUserPreferences",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "savepref"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:45
// @LINE:42
// @LINE:39
// @LINE:36
// @LINE:33
// @LINE:30
// @LINE:27
// @LINE:24
// @LINE:21
// @LINE:18
// @LINE:15
// @LINE:12
// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:45
class ReverseAssets {
    

// @LINE:45
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:42
class ReverseFilterDB {
    

// @LINE:42
def getProductByProdTypeAndRatingWithoutColor(t:Integer, p:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.FilterDB.getProductByProdTypeAndRatingWithoutColor(t, p), HandlerDef(this, "controllers.FilterDB", "getProductByProdTypeAndRatingWithoutColor", Seq(classOf[Integer], classOf[Integer]), "GET", """ Get products by product type filter""", _prefix + """prodTy""")
)
                      
    
}
                          

// @LINE:36
// @LINE:30
class ReverseRecoDB {
    

// @LINE:30
def getLatestProducts(p:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RecoDB.getLatestProducts(p), HandlerDef(this, "controllers.RecoDB", "getLatestProducts", Seq(classOf[Integer]), "GET", """ Get latest products""", _prefix + """newarrivals""")
)
                      

// @LINE:36
def getLatestProductsForUser(p:Integer, u:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RecoDB.getLatestProductsForUser(p, u), HandlerDef(this, "controllers.RecoDB", "getLatestProductsForUser", Seq(classOf[Integer], classOf[String]), "GET", """ Get latest products for a user""", _prefix + """unewarr""")
)
                      
    
}
                          

// @LINE:39
// @LINE:33
// @LINE:27
// @LINE:24
// @LINE:21
// @LINE:18
// @LINE:15
// @LINE:12
// @LINE:9
// @LINE:6
class ReverseApplication {
    

// @LINE:21
def merchantValidation(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.merchantValidation(), HandlerDef(this, "controllers.Application", "merchantValidation", Seq(), "POST", """ Merchant validation""", _prefix + """merval""")
)
                      

// @LINE:12
def loginValidation(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.loginValidation(), HandlerDef(this, "controllers.Application", "loginValidation", Seq(), "POST", """ Login validation""", _prefix + """login""")
)
                      

// @LINE:9
def registerUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.registerUser(), HandlerDef(this, "controllers.Application", "registerUser", Seq(), "POST", """ User registration""", _prefix + """register""")
)
                      

// @LINE:6
def loadMain(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.loadMain(), HandlerDef(this, "controllers.Application", "loadMain", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:15
def getUser(q:String, r:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getUser(q, r), HandlerDef(this, "controllers.Application", "getUser", Seq(classOf[String], classOf[String]), "GET", """ Go to user page""", _prefix + """user""")
)
                      

// @LINE:33
def loadProduct(p:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.loadProduct(p), HandlerDef(this, "controllers.Application", "loadProduct", Seq(classOf[String]), "GET", """ Load product details""", _prefix + """product""")
)
                      

// @LINE:39
def loadUserProduct(p:String, u:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.loadUserProduct(p, u), HandlerDef(this, "controllers.Application", "loadUserProduct", Seq(classOf[String], classOf[String]), "GET", """ Get product page for a user""", _prefix + """uproduct""")
)
                      

// @LINE:18
def registerMerchant(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.registerMerchant(), HandlerDef(this, "controllers.Application", "registerMerchant", Seq(), "POST", """ Merchant registration""", _prefix + """merreg""")
)
                      

// @LINE:27
def getMerchant(u:String, p:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getMerchant(u, p), HandlerDef(this, "controllers.Application", "getMerchant", Seq(classOf[String], classOf[Integer]), "GET", """ Go to merchant page""", _prefix + """merchant""")
)
                      

// @LINE:24
def saveUserPreferences(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.saveUserPreferences(), HandlerDef(this, "controllers.Application", "saveUserPreferences", Seq(), "POST", """ Add user preferences""", _prefix + """savepref""")
)
                      
    
}
                          
}
        
    