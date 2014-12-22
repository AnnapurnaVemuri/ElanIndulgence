
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
object footer extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<div class="container-fluid footer-section">
	<div class="row">
		<div class="col-md-6" style="text-align: center;padding-right: 100px">
			<label class="aboutus"> WHAT IS ELAN INDULGENCE?</label>
			<p class="aboutTxt">
             	Want to make your special occasion even more special? Get your attire custom designed for you. Elan Indulgence is the perfect blend of luxury, comfort and simplicity. Indulge yourself by getting your outfit personalized for you. Browse through our upcoming designer’s collections and boutiques and tell us what you like or our stylists will suggest something different based on your profile and don’t worry, we keep in mind your budget too! 
            </p>
		</div>
		<div class="col-md-3" style="padding-top: 15px">
			<a href="#" role="button" class="transparent designerBtn" style="margin-right: 30px" data-toggle="modal" data-target="#merchantmodal" id="designerButton">Are you a designer/botique owner?</a>
		</div>
		<div class="col-md-3" style="text-align: center">
			<div>
				<label class="contactus">
					CONTACT US!
				</label>
			</div>
			<div>
				<label class="contactlink">
					<a href="#">elanindulgence[at]gmail.com</a>
				</label>
			</div>
		</div>
	</div>	
</div>

<div id="merchantmodal" class="modal fade" role="dialog" aria-labelledby="merchantModal" aria-hidden="true">  
	<div class="modal-dialog" style="width: 800px; margin-top: 125px">
		<div class="modal-content">
			<div class="modal-header">  
			    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			    <h3 class="loginh3">Elan Indulgence</h3>
			</div>      
			<div class="modal-body" id="merchantBody">
			    <div class="container-fluid">
			    	<p class="aboutTxt"> Join us today to be a part of the growing network of designers and boutiques! Elan caters to a large set of customers across the globe.</p>
			    	<div style="margin-left: 310px">
			    		<a href="#" role="button" class="btn btn-default prefSave" data-dismiss="modal"  data-toggle="modal" data-target="#merchantmodal2" >Join our network!</a>
			    	</div>
				</div>  
		   	</div>
		</div>
	</div>
</div>    
<div id="merchantmodal2" class="modal fade" role="dialog" aria-labelledby="merchantModal2" aria-hidden="true">  
		<div class="modal-dialog" style="width: 800px; margin-top: 125px">
	        <div class="modal-content">
			    <div class="modal-header">  
			    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			    	<h3 class="loginh3">Elan Indulgence</h3>
			    </div>      
			    <div class="modal-body" id="merchantRBody">
			    	<div class="container">
				   		<div class="row">
				        	<div class="col-xs-4" style="border-right: 1px dashed #ccc">
				        		<h4 class="centerh4">Register</h4>
				        		<form id="registerForm" method="post" class="form-horizontal" action=""""),_display_(Seq[Any](/*57.86*/routes/*57.92*/.Application.registerMerchant())),format.raw/*57.123*/("""">
				        			<div class="form-group">
				        				<label for="inputName" class="col-sm-3 control-label">Name</label>
									    <div class="col-sm-8">
									      <input type="text" class="form-control" id="inputName" placeholder="Name" name="name">
									    </div>
				                    </div>
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
									    <div class="col-sm-offset-2 col-sm-8">
									      <div class="checkbox">
									        <label>
									          <input type="checkbox" name="is_designer"> Are you a designer?
									        </label>
									      </div>
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
				        		<form id="loginForm" method="post" class="form-horizontal" action=""""),_display_(Seq[Any](/*106.83*/routes/*106.89*/.Application.merchantValidation())),format.raw/*106.122*/("""">
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
	</div>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Dec 22 17:34:17 EST 2014
                    SOURCE: /home/sowmya/git/ElanIndulgence/app/views/footer.scala.html
                    HASH: e08af7e8e969d6c9930e147a83ff1fa9b8002ae0
                    MATRIX: 856->0|3793->2901|3808->2907|3862->2938|6443->5482|6459->5488|6516->5521
                    LINES: 29->1|85->57|85->57|85->57|134->106|134->106|134->106
                    -- GENERATED --
                */
            