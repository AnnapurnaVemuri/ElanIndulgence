
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
object userproductlist extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,List[Product],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(username : String, products : List[Product]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.47*/("""

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
    	"""),_display_(Seq[Any](/*34.7*/userheader(username, "FALSE"))),format.raw/*34.36*/("""
    	"""),_display_(Seq[Any](/*35.7*/usernav(username))),format.raw/*35.24*/("""
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
						        		window.location.href = url + "/uproduct?u="""),_display_(Seq[Any](/*57.60*/username)),format.raw/*57.68*/("""&p=" + """),_display_(Seq[Any](/*57.76*/product/*57.83*/.prod_id)),format.raw/*57.91*/(""";
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
	        		var url = window.location.href.split("?")[0];
	        		window.location.href = url + "?u="""),_display_(Seq[Any](/*83.46*/username)),format.raw/*83.54*/("""&p=" + curr;
	        	"""),format.raw/*84.11*/("""}"""),format.raw/*84.12*/(""");
	        	
	        	$("#newer").click(function() """),format.raw/*86.40*/("""{"""),format.raw/*86.41*/("""
	        		var curr = parseInt(getUrlParameter("p")) + 1;
	        		var url = window.location.href.split("?")[0];
	        		window.location.href = url + "?u="""),_display_(Seq[Any](/*89.46*/username)),format.raw/*89.54*/("""&p=" + curr;
	        	"""),format.raw/*90.11*/("""}"""),format.raw/*90.12*/(""");
	        	$("body").css("background-image", "url('assets/images/bg4.jpg')");
	    	"""),format.raw/*92.7*/("""}"""),format.raw/*92.8*/(""";
		</script>
    </body>
</html>
"""))}
    }
    
    def render(username:String,products:List[Product]): play.api.templates.HtmlFormat.Appendable = apply(username,products)
    
    def f:((String,List[Product]) => play.api.templates.HtmlFormat.Appendable) = (username,products) => apply(username,products)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Dec 22 17:38:56 EST 2014
                    SOURCE: /home/sowmya/git/ElanIndulgence/app/views/userproductlist.scala.html
                    HASH: 8c9bc60ef444d77e79c4223ff7368d166b438319
                    MATRIX: 798->1|937->46|1101->175|1115->181|1170->215|1261->271|1275->277|1340->320|1432->376|1447->382|1519->431|1616->492|1631->498|1685->530|1745->554|1760->560|1827->605|1935->677|1950->683|2017->728|2110->785|2125->791|2193->837|2286->894|2301->900|2365->942|2458->999|2473->1005|2539->1049|2632->1106|2647->1112|2702->1145|2851->1266|2880->1267|3086->1445|3115->1446|3267->1570|3296->1571|3381->1628|3410->1629|3448->1639|3477->1640|3510->1646|3538->1647|3605->1679|3656->1708|3698->1715|3737->1732|3928->1888|3958->1896|4108->2011|4148->2035|4188->2037|4364->2177|4380->2184|4410->2192|4529->2275|4545->2282|4573->2288|4693->2372|4709->2379|4740->2388|4872->2484|4888->2491|4918->2498|4986->2530|5002->2537|5030->2543|5152->2629|5168->2636|5198->2644|5259->2669|5275->2676|5305->2684|5353->2704|5382->2705|5543->2830|5573->2838|5617->2846|5633->2853|5663->2861|5711->2881|5740->2882|5809->2920|6194->3270|6224->3278|6297->3323|6326->3324|6411->3381|6440->3382|6519->3434|6547->3435|6620->3480|6649->3481|6846->3642|6876->3650|6927->3673|6956->3674|7037->3727|7066->3728|7263->3889|7293->3897|7344->3920|7373->3921|7486->4007|7514->4008
                    LINES: 26->1|29->1|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|48->20|48->20|52->24|52->24|55->27|55->27|57->29|57->29|58->30|58->30|59->31|59->31|62->34|62->34|63->35|63->35|67->39|67->39|72->44|72->44|72->44|74->46|74->46|74->46|75->47|75->47|75->47|77->49|77->49|77->49|78->50|78->50|78->50|79->51|79->51|79->51|82->54|82->54|82->54|83->55|83->55|83->55|83->55|83->55|85->57|85->57|85->57|85->57|85->57|86->58|86->58|88->60|100->72|100->72|102->74|102->74|104->76|104->76|106->78|106->78|108->80|108->80|111->83|111->83|112->84|112->84|114->86|114->86|117->89|117->89|118->90|118->90|120->92|120->92
                    -- GENERATED --
                */
            