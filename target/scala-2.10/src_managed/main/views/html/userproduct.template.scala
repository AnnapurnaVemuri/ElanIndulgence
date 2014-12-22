
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
object userproduct extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Product,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(u:String, p : Product):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.25*/("""

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
    	"""),_display_(Seq[Any](/*20.7*/userheader(u, "FALSE"))),format.raw/*20.29*/("""
    	"""),_display_(Seq[Any](/*21.7*/usernav(u))),format.raw/*21.17*/("""
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
    
    def render(u:String,p:Product): play.api.templates.HtmlFormat.Appendable = apply(u,p)
    
    def f:((String,Product) => play.api.templates.HtmlFormat.Appendable) = (u,p) => apply(u,p)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Dec 22 17:38:56 EST 2014
                    SOURCE: /home/sowmya/git/ElanIndulgence/app/views/userproduct.scala.html
                    HASH: 24827d025c93c23c27c5e4dbbfa139bd1ca08623
                    MATRIX: 788->1|905->24|1069->153|1083->159|1138->193|1229->249|1243->255|1308->298|1400->354|1415->360|1487->409|1584->470|1599->476|1653->508|1713->532|1728->538|1795->583|1903->655|1918->661|1985->706|2078->763|2093->769|2161->815|2254->872|2269->878|2333->920|2426->977|2441->983|2496->1016|2589->1073|2604->1079|2670->1123|2769->1187|2813->1209|2855->1216|2887->1226|3061->1364|3071->1365|3099->1371|3353->1589|3363->1590|3394->1599|3513->1682|3523->1683|3552->1690|3633->1735|3643->1736|3671->1742|5178->3214|5208->3222|5302->3288|5331->3289|5439->3370|5467->3371
                    LINES: 26->1|29->1|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|48->20|48->20|49->21|49->21|53->25|53->25|53->25|57->29|57->29|57->29|58->30|58->30|58->30|59->31|59->31|59->31|95->67|95->67|97->69|97->69|99->71|99->71
                    -- GENERATED --
                */
            