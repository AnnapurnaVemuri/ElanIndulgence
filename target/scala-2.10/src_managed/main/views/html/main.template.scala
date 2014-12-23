
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(error: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(Seq[Any](/*7.17*/title)),format.raw/*7.22*/("""</title>
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
    	"""),_display_(Seq[Any](/*18.7*/header())),format.raw/*18.15*/("""
    	"""),_display_(Seq[Any](/*19.7*/navigation())),format.raw/*19.19*/("""
    	
			    <div id="errormodal" class="modal fade" role="dialog" aria-labelledby="errorModal">  
					<div class="modal-dialog" style="width: 800px; margin-top: 125px">
				        <div class="modal-content">
						    <div class="modal-header">  
						    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						    	<h3 class="loginh3">Elan Indulgence</h3>
						    </div>      
						    <div class="modal-body" id="errorBody">
						    	<div class="container" style="width:750px;text-align: center">
						    		<label style="font-size: 14px">"""),_display_(Seq[Any](/*30.45*/error)),format.raw/*30.50*/("""</label>
						    	</div>
						    </div>
						</div>
					</div>
				</div>
    	"""),_display_(Seq[Any](/*36.7*/error/*36.12*/ match/*36.18*/ {/*37.6*/case "Incorrect Username and Password Combination" =>/*37.59*/ {_display_(Seq[Any](format.raw/*37.61*/("""
			  	<script type="text/javascript">
		        	$('#errormodal').modal('show');
				</script>
			  """)))}/*42.6*/case "" =>/*42.16*/ {_display_(Seq[Any](format.raw/*42.18*/("""
			  """)))}})),format.raw/*44.4*/("""
		"""),_display_(Seq[Any](/*45.4*/homeslide())),format.raw/*45.15*/("""
		"""),_display_(Seq[Any](/*46.4*/grid())),format.raw/*46.10*/("""
		"""),_display_(Seq[Any](/*47.4*/footer())),format.raw/*47.12*/("""
	
		<script type="text/javascript">
			window.onload = function() """),format.raw/*50.31*/("""{"""),format.raw/*50.32*/("""
	        	$("body").css("background-image", "url('assets/images/bg4.jpg')");
			"""),format.raw/*52.4*/("""}"""),format.raw/*52.5*/("""
		</script>
    </body>
</html>
"""))}
    }
    
    def render(title:String,error:String): play.api.templates.HtmlFormat.Appendable = apply(title)(error)
    
    def f:((String) => (String) => play.api.templates.HtmlFormat.Appendable) = (title) => (error) => apply(title)(error)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Dec 22 17:35:14 EST 2014
                    SOURCE: /home/sowmya/git/ElanIndulgence/app/views/main.scala.html
                    HASH: 78896fa83dea573bb56be310e1fc3379febf25bb
                    MATRIX: 780->1|904->31|992->84|1018->89|1115->151|1129->157|1184->191|1275->247|1289->253|1354->296|1446->352|1461->358|1533->407|1630->468|1645->474|1699->506|1760->531|1775->537|1842->582|1935->639|1950->645|2018->691|2111->748|2126->754|2190->796|2283->853|2298->859|2353->892|2452->956|2482->964|2524->971|2558->983|3192->1581|3219->1586|3340->1672|3354->1677|3369->1683|3379->1691|3441->1744|3481->1746|3601->1854|3620->1864|3660->1866|3699->1877|3738->1881|3771->1892|3810->1896|3838->1902|3877->1906|3907->1914|4002->1981|4031->1982|4139->2063|4167->2064
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|46->18|46->18|47->19|47->19|58->30|58->30|64->36|64->36|64->36|64->37|64->37|64->37|68->42|68->42|68->42|69->44|70->45|70->45|71->46|71->46|72->47|72->47|75->50|75->50|77->52|77->52
                    -- GENERATED --
                */
            