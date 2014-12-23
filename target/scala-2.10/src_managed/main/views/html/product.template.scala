
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
object product extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Product,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(p : Product):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.15*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>Elan Indulgence</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("stylesheets/main.css"))),format.raw/*8.94*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*9.54*/routes/*9.60*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*9.103*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*10.54*/routes/*10.60*/.Assets.at("stylesheets/bootstrap-theme.min.css"))),format.raw/*10.109*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*11.59*/routes/*11.65*/.Assets.at("images/favicon.png"))),format.raw/*11.97*/("""">
        <link href=""""),_display_(Seq[Any](/*12.22*/routes/*12.28*/.Assets.at("stylesheets/star-rating.min.css"))),format.raw/*12.73*/("""" media="all" rel="stylesheet" type="text/css" />
        <script src=""""),_display_(Seq[Any](/*13.23*/routes/*13.29*/.Assets.at("javascripts/jquery-2.1.1.min.js"))),format.raw/*13.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*14.23*/routes/*14.29*/.Assets.at("javascripts/jquery-2.1.1.min.map"))),format.raw/*14.75*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*15.23*/routes/*15.29*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*15.71*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*16.23*/routes/*16.29*/.Assets.at("javascripts/main.js"))),format.raw/*16.62*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*17.23*/routes/*17.29*/.Assets.at("javascripts/star-rating.min.js"))),format.raw/*17.73*/("""" type="text/javascript"></script>
    </head>
    <body>
    	"""),_display_(Seq[Any](/*20.7*/header())),format.raw/*20.15*/("""
    	"""),_display_(Seq[Any](/*21.7*/navigation())),format.raw/*21.19*/("""
    	<div class="container">
			<div class="row">
				<div class="col-sm-6" style="width: 400px;">
					<img src="data:image/jpg;base64,"""),_display_(Seq[Any](/*25.39*/p/*25.40*/.photo)),format.raw/*25.46*/("""">
				</div>
				<div class="col-sm-6">
					<div class="jumbotron" style="margin-bottom: 0px;margin-left: 250px;width: 520px;text-align: center">
		  				<label style="text-transform: uppercase;font-size: x-large;">"""),_display_(Seq[Any](/*29.71*/p/*29.72*/.merchant)),format.raw/*29.81*/("""</label>
		  				<input class="rating" data-size="xxs" data-disabled="true" value="""),_display_(Seq[Any](/*30.75*/p/*30.76*/.rating)),format.raw/*30.83*/(""">
		  				<label style="font-size: large;">$"""),_display_(Seq[Any](/*31.44*/p/*31.45*/.price)),format.raw/*31.51*/("""</label>
		  				<!-- <p>Quantity Available</p> -->
		  				<div class="container">
		  					<div class="row">
		  						<div class="col-sm-4">
		  							<div class="btn-group">
		  								<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false" style="padding-left: 16px; padding-right: 16px; padding-top: 10px; padding-bottom: 10px; height: 32px; line-height:16px; margin-right: 0px;">Size Selection <span class="caret"></span></button>
		  								<ul class="dropdown-menu" role="menu">
		    								<li><a href="#">One Size</a></li>
		    								<li class="divider"></li>
		    								<li><a href="#">XS</a></li>
		    								<li><a href="#">S</a></li>
		    								<li><a href="#">M</a></li>
		    								<li><a href="#">L</a></li>
		    								<li><a href="#">XL</a></li>
		    								<li><a href="#">XXL</a></li>
		  								</ul>
									</div>	
		  						</div> 
		  						<div class="col-sm-4">
		  							<a class="btn btn-primary btn-md" href="#" role="button" style="
		    							margin-left: 40px;" data-toggle="modal" data-target="#loginmodal">Buy Now!</a>
		  						</div>
		  					</div>
						</div>
					</div>
				</div>
			</div>
			
			<!-- <div class="row">
				<div class="jumbotron" style="margin-top: 50px;height: 235.9999923706054px;width: 1185px;"">
		  		<h1>Product Description</h1>
		  		<p>This is a short description about the product</p>
				</div> 
			</div> -->
		</div>
		"""),_display_(Seq[Any](/*67.4*/footer())),format.raw/*67.12*/("""	
		<script type="text/javascript">
			window.onload = function() """),format.raw/*69.31*/("""{"""),format.raw/*69.32*/("""
	        	$("body").css("background-image", "url('assets/images/bg4.jpg')");
			"""),format.raw/*71.4*/("""}"""),format.raw/*71.5*/("""
		</script>
    </body>
</html>"""))}
    }
    
    def render(p:Product): play.api.templates.HtmlFormat.Appendable = apply(p)
    
    def f:((Product) => play.api.templates.HtmlFormat.Appendable) = (p) => apply(p)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Dec 22 17:34:17 EST 2014
                    SOURCE: /home/sowmya/git/ElanIndulgence/app/views/product.scala.html
                    HASH: 4bcea8ff7802cfe18d7a1e7644773cab106c3b6b
                    MATRIX: 777->1|884->14|1048->143|1062->149|1117->183|1208->239|1222->245|1287->288|1379->344|1394->350|1466->399|1563->460|1578->466|1632->498|1692->522|1707->528|1774->573|1882->645|1897->651|1964->696|2057->753|2072->759|2140->805|2233->862|2248->868|2312->910|2405->967|2420->973|2475->1006|2568->1063|2583->1069|2649->1113|2748->1177|2778->1185|2820->1192|2854->1204|3028->1342|3038->1343|3066->1349|3320->1567|3330->1568|3361->1577|3480->1660|3490->1661|3519->1668|3600->1713|3610->1714|3638->1720|5145->3192|5175->3200|5269->3266|5298->3267|5406->3348|5434->3349
                    LINES: 26->1|29->1|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|48->20|48->20|49->21|49->21|53->25|53->25|53->25|57->29|57->29|57->29|58->30|58->30|58->30|59->31|59->31|59->31|95->67|95->67|97->69|97->69|99->71|99->71
                    -- GENERATED --
                */
            