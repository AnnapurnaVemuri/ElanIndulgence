
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object header extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<div>
	<div class="header">
		<a href=""""),_display_(Seq[Any](/*3.13*/routes/*3.19*/.Application.loadMain())),format.raw/*3.42*/(""""  role="button" class="transparent logo">Elan Indulgence</a>
		<a href="#" role="button" class="btn btn-default login" data-toggle="modal" data-target="#loginmodal" >Sign in | Register</a>
	</div>
	<div id="loginmodal" class="modal fade" role="dialog" aria-labelledby="basicModal" aria-hidden="true">  
		<div class="modal-dialog" style="width: 800px; margin-top: 125px">
	        <div class="modal-content">
			    <div class="modal-header">  
			    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			    	<h3 class="loginh3">Elan Indulgence</h3>
			    </div>      
			    <div class="modal-body" id="loginModal">
			    	<div class="container">
				   		<div class="row">
				        	<div class="col-xs-4" style="border-right: 1px dashed #ccc">
				        		<h4 class="centerh4">Register</h4>
				        		<form id="registerForm" method="post" class="form-horizontal" action=""""),_display_(Seq[Any](/*18.86*/routes/*18.92*/.Application.registerUser())),format.raw/*18.119*/("""">
				        			<div class="form-group">
				        				<label for="inputEmail" class="col-sm-3 control-label">Email</label>
									    <div class="col-sm-8">
									      <input type="email" class="form-control" id="inputEmail" placeholder="Email" name="email">
									    </div>
				                    </div>
				                    <div class="form-group">
				                    	<label for="inputUser" class="col-sm-3 control-label">Username</label>
									    <div class="col-sm-8">
									      <input type="text" class="form-control" id="inputUser" placeholder="Username" name="username">
									    </div>
				                    </div>
				                    <div class="form-group">
				                    	<label for="inputPassword" class="col-sm-3 control-label">Password</label>
									    <div class="col-sm-8">
									      <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="password">
									    </div>
				                    </div>
				                    <div class="form-group">
				                    	<label for="inputConfirmPass" class="col-sm-3 control-label">Confirm Password</label>
									    <div class="col-sm-8">
									      <input type="password" class="form-control" id="inputConfirmPass" placeholder="Confirm Password">
									    </div>
				                    </div>
				                    <div class="form-group">
				                        <div class="col-sm-10 col-sm-offset-4">
				                            <button type="submit" class="btn btn-default loginButton" style="width:125px">Register</button>
				                        </div>
				                    </div>
				                </form>
				        	</div>
				        	<div class="col-xs-4">
				        		<h4 class="centerh4">Sign in</h4>
				        		<form id="loginForm" method="post" class="form-horizontal" action=""""),_display_(Seq[Any](/*52.83*/routes/*52.89*/.Application.loginValidation())),format.raw/*52.119*/("""">
				                    <div class="form-group">
				                    	<label for="loginUser" class="col-sm-3 control-label">Username</label>
									    <div class="col-sm-8">
									      <input type="text" class="form-control" id="loginUser" placeholder="Username" name="username">
									    </div>
				                    </div>
				                    <div class="form-group">
				                    	<label for="loginPassword" class="col-sm-3 control-label">Password</label>
									    <div class="col-sm-8">
									      <input type="password" class="form-control" id="loginPassword" placeholder="Password" name="password">
									    </div>
				                    </div>
				                    <div class="form-group">
				                        <div class="col-sm-10 col-sm-offset-4">
				                            <button type="submit" class="btn btn-default loginButton" style="width:125px">Sign in</button>
				                        </div>
				                    </div>
				                </form>
				        	</div>
				        </div>
				    </div>
				</div>  
		    </div>
	    </div>
	</div>
</div>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Dec 20 16:32:52 EST 2014
                    SOURCE: /home/sowmya/git/ElanIndulgence/app/views/header.scala.html
                    HASH: 2966ecea04adedd114f39c05701be5f60469d64e
                    MATRIX: 856->0|931->40|945->46|989->69|1956->1000|1971->1006|2021->1033|3959->2935|3974->2941|4027->2971
                    LINES: 29->1|31->3|31->3|31->3|46->18|46->18|46->18|80->52|80->52|80->52
                    -- GENERATED --
                */
            