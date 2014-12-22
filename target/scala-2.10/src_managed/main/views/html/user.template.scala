
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
object user extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(user: String)(register: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.34*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>ElanIndulgence</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("stylesheets/main.css"))),format.raw/*8.94*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*9.54*/routes/*9.60*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*9.103*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*10.54*/routes/*10.60*/.Assets.at("stylesheets/bootstrap-theme.min.css"))),format.raw/*10.109*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*11.59*/routes/*11.65*/.Assets.at("images/favicon.png"))),format.raw/*11.97*/("""">
        <script src=""""),_display_(Seq[Any](/*12.23*/routes/*12.29*/.Assets.at("javascripts/jquery-2.1.1.min.js"))),format.raw/*12.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*13.23*/routes/*13.29*/.Assets.at("javascripts/jquery-2.1.1.min.map"))),format.raw/*13.75*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*14.23*/routes/*14.29*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*14.71*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*15.23*/routes/*15.29*/.Assets.at("javascripts/main.js"))),format.raw/*15.62*/("""" type="text/javascript"></script>
    </head>
    <body>
    	"""),_display_(Seq[Any](/*18.7*/userheader(user = user, register = register))),format.raw/*18.51*/("""
    	"""),_display_(Seq[Any](/*19.7*/usernav(user))),format.raw/*19.20*/("""
    	"""),_display_(Seq[Any](/*20.7*/slider())),format.raw/*20.15*/("""
    	"""),_display_(Seq[Any](/*21.7*/grid())),format.raw/*21.13*/("""
		"""),_display_(Seq[Any](/*22.4*/footer())),format.raw/*22.12*/("""
	
		<script type="text/javascript">
			window.onload = function() """),format.raw/*25.31*/("""{"""),format.raw/*25.32*/("""
	        	$("body").css("background-image", "url('assets/images/bg4.jpg')");
			"""),format.raw/*27.4*/("""}"""),format.raw/*27.5*/("""
		</script>
    </body>
</html>"""))}
    }
    
    def render(user:String,register:String): play.api.templates.HtmlFormat.Appendable = apply(user)(register)
    
    def f:((String) => (String) => play.api.templates.HtmlFormat.Appendable) = (user) => (register) => apply(user)(register)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Dec 22 17:34:17 EST 2014
                    SOURCE: /home/sowmya/git/ElanIndulgence/app/views/user.scala.html
                    HASH: b867c915f9709a1871f465719c480d3d19d429c8
                    MATRIX: 780->1|906->33|1069->161|1083->167|1138->201|1229->257|1243->263|1308->306|1400->362|1415->368|1487->417|1584->478|1599->484|1653->516|1714->541|1729->547|1796->592|1889->649|1904->655|1972->701|2065->758|2080->764|2144->806|2237->863|2252->869|2307->902|2406->966|2472->1010|2514->1017|2549->1030|2591->1037|2621->1045|2663->1052|2691->1058|2730->1062|2760->1070|2855->1137|2884->1138|2992->1219|3020->1220
                    LINES: 26->1|29->1|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|46->18|46->18|47->19|47->19|48->20|48->20|49->21|49->21|50->22|50->22|53->25|53->25|55->27|55->27
                    -- GENERATED --
                */
            