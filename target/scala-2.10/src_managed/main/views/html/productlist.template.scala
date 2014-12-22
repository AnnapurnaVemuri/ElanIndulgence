
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
object productlist extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[Product],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(products : List[Product]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.28*/("""

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
        <script src=""""),_display_(Seq[Any](/*16.23*/routes/*16.29*/.Assets.at("javascripts/star-rating.min.js"))),format.raw/*16.73*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*17.23*/routes/*17.29*/.Assets.at("javascripts/main.js"))),format.raw/*17.62*/("""" type="text/javascript"></script>
    </head>
    <script type="text/javascript">
	    function getUrlParameter(sParam) """),format.raw/*20.39*/("""{"""),format.raw/*20.40*/("""
	        var sPageURL = window.location.search.substring(1);
	        var sURLVariables = sPageURL.split('&');
	        for (var i = 0; i < sURLVariables.length; i++) 
	        """),format.raw/*24.10*/("""{"""),format.raw/*24.11*/("""
	            var sParameterName = sURLVariables[i].split('=');
	            if (sParameterName[0] == sParam) 
	            """),format.raw/*27.14*/("""{"""),format.raw/*27.15*/("""
	                return sParameterName[1];
	            """),format.raw/*29.14*/("""}"""),format.raw/*29.15*/("""
	        """),format.raw/*30.10*/("""}"""),format.raw/*30.11*/("""
	    """),format.raw/*31.6*/("""}"""),format.raw/*31.7*/("""
    </script>
    <body>
    	"""),_display_(Seq[Any](/*34.7*/header())),format.raw/*34.15*/("""
    	"""),_display_(Seq[Any](/*35.7*/navigation())),format.raw/*35.19*/("""
		<div class="container" style="padding-left:0px">
			<div class="row" style="padding-left:0px">
				<div class="col-sm-3" style="padding-left:0px">
					"""),_display_(Seq[Any](/*39.7*/filter())),format.raw/*39.15*/("""
				</div>
				<div class="col-sm-9">
					<div class="container">
				        <div class="row col-sm-9">
							"""),_display_(Seq[Any](/*44.9*/for(product <- products) yield /*44.33*/ {_display_(Seq[Any](format.raw/*44.35*/("""
								<div class="col-sm-4 thumb" style="text-align: center">
					                <a class="thumbnail" href="#" style="width:260px" id="""),_display_(Seq[Any](/*46.76*/product/*46.83*/.prod_id)),format.raw/*46.91*/(""">
					                    <img class="img-responsive" src="data:image/jpg;base64,"""),_display_(Seq[Any](/*47.82*/product/*47.89*/.photo)),format.raw/*47.95*/("""" alt="renderedIncorrectly">
					                </a>
					                <label>"""),_display_(Seq[Any](/*49.30*/product/*49.37*/.merchant)),format.raw/*49.46*/("""</label>
					                <input class="rating" data-size="xxs" data-disabled="true" value="""),_display_(Seq[Any](/*50.88*/product/*50.95*/.rating)),format.raw/*50.102*/(""">
					                <label>$"""),_display_(Seq[Any](/*51.31*/product/*51.38*/.price)),format.raw/*51.44*/("""</label>
					            </div>
					            <script>
					            	var i = """),_display_(Seq[Any](/*54.28*/product/*54.35*/.prod_id)),format.raw/*54.43*/(""";
					            	$("#"""),_display_(Seq[Any](/*55.24*/product/*55.31*/.prod_id)),format.raw/*55.39*/("""").click(function() """),format.raw/*55.59*/("""{"""),format.raw/*55.60*/("""
					            		var url = window.location.href.split("/")[0];
						        		window.location.href = url + "/product?p=" + """),_display_(Seq[Any](/*57.63*/product/*57.70*/.prod_id)),format.raw/*57.78*/(""";
					            	"""),format.raw/*58.19*/("""}"""),format.raw/*58.20*/(""");
					            </script>
							""")))})),format.raw/*60.9*/("""
						</div>
			    	</div>
			    	<nav>
					  <ul class="pager">
					    <li id="olderEl" class="previous"><a href="#" id="older"><span aria-hidden="true">&larr;</span> Older</a></li>
					    <li class="next"><a href="#" id="newer">Newer <span aria-hidden="true">&rarr;</span></a></li>
					  </ul>
					</nav>
				</div>
			</div>
		</div>
		"""),_display_(Seq[Any](/*72.4*/footer())),format.raw/*72.12*/("""
		<script>
	    	window.onload = function() """),format.raw/*74.34*/("""{"""),format.raw/*74.35*/("""
	    		var p = getUrlParameter("p");
	    		if (p == 1) """),format.raw/*76.20*/("""{"""),format.raw/*76.21*/("""
	    			$("#olderEl").addClass("disabled");
	    		"""),format.raw/*78.8*/("""}"""),format.raw/*78.9*/("""
	    		
	    		$("#older").click(function() """),format.raw/*80.37*/("""{"""),format.raw/*80.38*/("""
	        		var curr = parseInt(getUrlParameter("p")) - 1;
	        		var ampsplit = window.location.href.split("&p");
	        		var url;
	        		if (ampsplit.length > 1) """),format.raw/*84.37*/("""{"""),format.raw/*84.38*/("""
	        			url = ampsplit[0];
	        			window.location.href = url + "&p=" + curr;
	        		"""),format.raw/*87.12*/("""}"""),format.raw/*87.13*/(""" else """),format.raw/*87.19*/("""{"""),format.raw/*87.20*/("""
	        			var quesplit = window.location.href.split("?p");
	        			url = quesplit[0];
	        			window.location.href = url + "?p=" + curr;
	        		"""),format.raw/*91.12*/("""}"""),format.raw/*91.13*/("""
	        	"""),format.raw/*92.11*/("""}"""),format.raw/*92.12*/(""");
	        	
	        	$("#newer").click(function() """),format.raw/*94.40*/("""{"""),format.raw/*94.41*/("""
	        		var curr = parseInt(getUrlParameter("p")) + 1;
	        		var ampsplit = window.location.href.split("&p");
	        		var url;
	        		if (ampsplit.length > 1) """),format.raw/*98.37*/("""{"""),format.raw/*98.38*/("""
	        			url = ampsplit[0];
	        			window.location.href = url + "&p=" + curr;
	        		"""),format.raw/*101.12*/("""}"""),format.raw/*101.13*/(""" else """),format.raw/*101.19*/("""{"""),format.raw/*101.20*/("""
	        			var quesplit = window.location.href.split("?p");
	        			url = quesplit[0];
	        			window.location.href = url + "?p=" + curr;
	        		"""),format.raw/*105.12*/("""}"""),format.raw/*105.13*/("""
	        	"""),format.raw/*106.11*/("""}"""),format.raw/*106.12*/(""");
	        	$("body").css("background-image", "url('assets/images/bg4.jpg')");
	    	"""),format.raw/*108.7*/("""}"""),format.raw/*108.8*/(""";
		</script>
    </body>
</html>
"""))}
    }
    
    def render(products:List[Product]): play.api.templates.HtmlFormat.Appendable = apply(products)
    
    def f:((List[Product]) => play.api.templates.HtmlFormat.Appendable) = (products) => apply(products)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Dec 22 17:38:56 EST 2014
                    SOURCE: /home/sowmya/git/ElanIndulgence/app/views/productlist.scala.html
                    HASH: 6b9741c8e16ed6b758559e3ec4c3f803c9dcade5
                    MATRIX: 787->1|907->27|1071->156|1085->162|1140->196|1231->252|1245->258|1310->301|1402->357|1417->363|1489->412|1586->473|1601->479|1655->511|1715->535|1730->541|1797->586|1905->658|1920->664|1987->709|2080->766|2095->772|2163->818|2256->875|2271->881|2335->923|2428->980|2443->986|2509->1030|2602->1087|2617->1093|2672->1126|2821->1247|2850->1248|3056->1426|3085->1427|3237->1551|3266->1552|3351->1609|3380->1610|3418->1620|3447->1621|3480->1627|3508->1628|3575->1660|3605->1668|3647->1675|3681->1687|3872->1843|3902->1851|4052->1966|4092->1990|4132->1992|4308->2132|4324->2139|4354->2147|4473->2230|4489->2237|4517->2243|4637->2327|4653->2334|4684->2343|4816->2439|4832->2446|4862->2453|4930->2485|4946->2492|4974->2498|5096->2584|5112->2591|5142->2599|5203->2624|5219->2631|5249->2639|5297->2659|5326->2660|5490->2788|5506->2795|5536->2803|5584->2823|5613->2824|5682->2862|6067->3212|6097->3220|6170->3265|6199->3266|6284->3323|6313->3324|6392->3376|6420->3377|6493->3422|6522->3423|6725->3598|6754->3599|6880->3697|6909->3698|6943->3704|6972->3705|7159->3864|7188->3865|7227->3876|7256->3877|7337->3930|7366->3931|7569->4106|7598->4107|7725->4205|7755->4206|7790->4212|7820->4213|8008->4372|8038->4373|8078->4384|8108->4385|8222->4471|8251->4472
                    LINES: 26->1|29->1|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|48->20|48->20|52->24|52->24|55->27|55->27|57->29|57->29|58->30|58->30|59->31|59->31|62->34|62->34|63->35|63->35|67->39|67->39|72->44|72->44|72->44|74->46|74->46|74->46|75->47|75->47|75->47|77->49|77->49|77->49|78->50|78->50|78->50|79->51|79->51|79->51|82->54|82->54|82->54|83->55|83->55|83->55|83->55|83->55|85->57|85->57|85->57|86->58|86->58|88->60|100->72|100->72|102->74|102->74|104->76|104->76|106->78|106->78|108->80|108->80|112->84|112->84|115->87|115->87|115->87|115->87|119->91|119->91|120->92|120->92|122->94|122->94|126->98|126->98|129->101|129->101|129->101|129->101|133->105|133->105|134->106|134->106|136->108|136->108
                    -- GENERATED --
                */
            