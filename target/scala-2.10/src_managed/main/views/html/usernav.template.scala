
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
object usernav extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(username: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.20*/("""

<div style="margin:0">
		<nav class="navbar" role="navigation" style="background-color: #6D9BC3;border-radius: 0px;font-size:12px;">
			<div class="container-fluid">
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
		        		<li><a id="unewarr" href="#" style="color:white;font-family: fantasy;" class="maindrop">NEW ARRIVALS</a></li>
				        <li class="dropdown">
				          <a href="#" class="dropdown-toggle maindrop" data-toggle="dropdown" role="button" aria-expanded="false" style="color:white;font-family: fantasy;">WOMEN<span class="caret"></span></a>
				          <ul class="dropdown-menu" role="menu">
				            <li><a href="#" style="font-weight: bold;font-size: 12px;color: #6D9BC3;font-family: fantasy;">ETHNIC</a></li>
				            <li class="divider"></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">SAREE</a></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">LEHENGAS</a></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">KURTIS</a></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">SALWAR KAMEEZ</a></li>
				            <li style="padding-top:20px"><a href="#" style="font-weight: bold;font-size: 12px;color: #6D9BC3;font-family: fantasy;">WESTERN</a></li>
				            <li class="divider"></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">DRESSES</a></li>
				            <li style="padding-top:20px"><a href="#" style="font-weight: bold;font-size: 12px;color: #6D9BC3;font-family: fantasy;">ACCESSORIES</a></li>
				            <li class="divider"></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">JEWELLERY</a></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">BAGS</a></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">FOOTWEAR</a></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">SCARVES</a></li>
				          </ul>
				        </li>
				        <li class="dropdown">
				          <a href="#" class="dropdown-toggle maindrop" data-toggle="dropdown" role="button" aria-expanded="false" style="color:white;font-family: fantasy;">MEN<span class="caret"></span></a>
				          <ul class="dropdown-menu" role="menu">
				            <li><a href="#" style="font-weight: bold;font-size: 12px;font-family: fantasy;color: #6D9BC3">ETHNIC</a></li>
				            <li class="divider"></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">SHERWANI</a></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">KURTAS</a></li>
				            <li style="padding-top:20px"><a href="#" style="font-weight: bold;font-size: 12px;font-family: fantasy;color: #6D9BC3">WESTERN</a></li>
				            <li class="divider"></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">SUITS</a></li>
				          </ul>
				        </li>
				        <li class="dropdown">
				          <a href="#" class="dropdown-toggle maindrop" data-toggle="dropdown" role="button" aria-expanded="false" style="color:white;font-family: fantasy;">KIDS<span class="caret"></span></a>
				          <ul class="dropdown-menu" role="menu">
				            <li><a href="#" style="font-weight: bold;font-size: 12px;font-family: fantasy;color: #6D9BC3">GIRLS</a></li>
				            <li class="divider"></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">ETHNIC</a></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">FROCKS</a></li>
				            <li style="padding-top:20px"><a href="#" style="font-weight: bold;font-size: 12px;font-family: fantasy;color: #6D9BC3">BOYS</a></li>
				            <li class="divider"></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">ETHNIC</a></li>
				          </ul>
				        </li>
				        <li class="dropdown">
				          <a href="#" class="dropdown-toggle maindrop" data-toggle="dropdown" role="button" aria-expanded="false" style="color:white;font-family: fantasy;">DESIGNERS<span class="caret"></span></a>
				          <ul class="dropdown-menu" role="menu">
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">ANITA REDDY</a></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">BHARGAVI KUNAM</a></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">PAWAN & PRANAV HAUTE COUTURE</a></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">SRIDEVI & SWAPNA</a></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">VARUNI GOPEN</a></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">SANVI</a></li>
				          </ul>
				        </li>
				        <li class="dropdown">
				          <a href="#" class="dropdown-toggle maindrop" data-toggle="dropdown" role="button" aria-expanded="false" style="color:white;font-family: fantasy;">BOUTIQUES<span class="caret"></span></a>
				          <ul class="dropdown-menu" role="menu">
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">BHAMINEE</a></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">MANYA COLLECTIONS</a></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">POLKA DOTS</a></li>
				            <li><a href="#" style="font-size: 10px;font-family: fantasy;">SAMYAKK</a></li>
				          </ul>
				        </li>
		      		</ul>
		    	</div>
			</div>
		</nav>
	</div>
<script>
	$("#unewarr").click(function() """),format.raw/*79.33*/("""{"""),format.raw/*79.34*/("""
		var parts = window.location.href.split("/");
		var l = parts.length;
		var lastpart = parts[l - 1];
		var url = window.location.href.split("/")[0];
		window.location.href = url + "/unewarr?u="""),_display_(Seq[Any](/*84.45*/username)),format.raw/*84.53*/("""&p=1";
	"""),format.raw/*85.2*/("""}"""),format.raw/*85.3*/(""");
</script>"""))}
    }
    
    def render(username:String): play.api.templates.HtmlFormat.Appendable = apply(username)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (username) => apply(username)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Dec 22 17:38:56 EST 2014
                    SOURCE: /home/sowmya/git/ElanIndulgence/app/views/usernav.scala.html
                    HASH: 65a22e5cbb24f58b1e42077c84f4e79dca959110
                    MATRIX: 776->1|888->19|6710->5813|6739->5814|6970->6009|7000->6017|7035->6025|7063->6026
                    LINES: 26->1|29->1|107->79|107->79|112->84|112->84|113->85|113->85
                    -- GENERATED --
                */
            