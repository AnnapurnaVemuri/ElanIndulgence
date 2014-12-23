
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
object merchant extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,List[Product],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(username : String, products : List[Product]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.47*/("""
<!DOCTYPE html>

<html>
    <head>
        <title>Elan Indulgence</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*7.54*/routes/*7.60*/.Assets.at("stylesheets/main.css"))),format.raw/*7.94*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*8.103*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*9.54*/routes/*9.60*/.Assets.at("stylesheets/bootstrap-theme.min.css"))),format.raw/*9.109*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*10.59*/routes/*10.65*/.Assets.at("images/favicon.png"))),format.raw/*10.97*/("""">
        <link href=""""),_display_(Seq[Any](/*11.22*/routes/*11.28*/.Assets.at("stylesheets/star-rating.min.css"))),format.raw/*11.73*/("""" media="all" rel="stylesheet" type="text/css" />
        <script src=""""),_display_(Seq[Any](/*12.23*/routes/*12.29*/.Assets.at("javascripts/jquery-2.1.1.min.js"))),format.raw/*12.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*13.23*/routes/*13.29*/.Assets.at("javascripts/jquery-2.1.1.min.map"))),format.raw/*13.75*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*14.23*/routes/*14.29*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*14.71*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*15.23*/routes/*15.29*/.Assets.at("javascripts/main.js"))),format.raw/*15.62*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*16.23*/routes/*16.29*/.Assets.at("javascripts/common.js"))),format.raw/*16.64*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*17.23*/routes/*17.29*/.Assets.at("javascripts/FileUpload.js"))),format.raw/*17.68*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*18.23*/routes/*18.29*/.Assets.at("javascripts/star-rating.min.js"))),format.raw/*18.73*/("""" type="text/javascript"></script>
		<link rel="stylesheet" href=""""),_display_(Seq[Any](/*19.33*/routes/*19.39*/.Assets.at("stylesheets/screen.css"))),format.raw/*19.75*/("""" type="text/css" media="all" />
		<link rel="stylesheet" href=""""),_display_(Seq[Any](/*20.33*/routes/*20.39*/.Assets.at("stylesheets/FileUpload.css"))),format.raw/*20.79*/("""" type="text/css" media="all" />
    </head>
    <body>
		<!-- Script for the NewsTicker -->
		<script type="text/javascript">
		
			function div_show() """),format.raw/*26.24*/("""{"""),format.raw/*26.25*/("""
				$('#imagemodal').modal('show');
			"""),format.raw/*28.4*/("""}"""),format.raw/*28.5*/("""
			
			function addinlineform() """),format.raw/*30.29*/("""{"""),format.raw/*30.30*/("""
				$("#uploadfiles").append('<input type="file" multiple style="padding:10px">');
			"""),format.raw/*32.4*/("""}"""),format.raw/*32.5*/("""
			function getUrlParameter(sParam) """),format.raw/*33.37*/("""{"""),format.raw/*33.38*/("""
		        var sPageURL = window.location.search.substring(1);
		        var sURLVariables = sPageURL.split('&');
		        for (var i = 0; i < sURLVariables.length; i++) 
		        """),format.raw/*37.11*/("""{"""),format.raw/*37.12*/("""
		            var sParameterName = sURLVariables[i].split('=');
		            if (sParameterName[0] == sParam) 
		            """),format.raw/*40.15*/("""{"""),format.raw/*40.16*/("""
		                return sParameterName[1];
		            """),format.raw/*42.15*/("""}"""),format.raw/*42.16*/("""
		        """),format.raw/*43.11*/("""}"""),format.raw/*43.12*/("""
		    """),format.raw/*44.7*/("""}"""),format.raw/*44.8*/("""
		</script>
		<div>
			<div class="header" style="border-bottom:5px solid #6D9BC3;">
				<a href=""""),_display_(Seq[Any](/*48.15*/routes/*48.21*/.Application.loadMain())),format.raw/*48.44*/(""""  role="button" class="transparent logo">Elan Indulgence</a>
				<div class="btn-group user">
					<button type="button" class="btn user" style="font-family: fantasy">Welcome """),_display_(Seq[Any](/*50.83*/{username})),format.raw/*50.93*/("""!</button>
					<button type="button" class="btn dropdown-toggle user"
						data-toggle="dropdown" aria-expanded="false">
						<span class="caret"></span> <span class="sr-only">Toggle
							Dropdown</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#"  class="transparent" style="font-size: 10px;font-family: fantasy">DETAILS</a></li>
						<li class="divider"></li>
						<li><a href=""""),_display_(Seq[Any](/*59.21*/routes/*59.27*/.Application.loadMain())),format.raw/*59.50*/("""" class="transparent"
							style="font-size: 10px;font-family: fantasy">LOGOUT</a></li>
					</ul>
				</div>
				<!-- <label style="float:right; font-size:16px; font-weight:bold;padding-top: 5px">Welcome """),_display_(Seq[Any](/*63.97*/{username})),format.raw/*63.107*/("""!</label> -->
			</div>
			
			<div class="container" style="padding-left:0px">
				<div class="row" style="padding-left:0px">
					<div class="col-sm-9">
						<div class="container">
					        <div class="row col-sm-9">
								"""),_display_(Seq[Any](/*71.10*/for(product <- products) yield /*71.34*/ {_display_(Seq[Any](format.raw/*71.36*/("""
									<div class="col-sm-4 thumb" style="text-align: center">
						                <a class="thumbnail" href="#" style="width:260px" id="""),_display_(Seq[Any](/*73.77*/product/*73.84*/.prod_id)),format.raw/*73.92*/(""">
						                    <img class="img-responsive" src="data:image/jpg;base64,"""),_display_(Seq[Any](/*74.83*/product/*74.90*/.photo)),format.raw/*74.96*/("""" alt="renderedIncorrectly">
						                </a>
						                <input class="rating" data-size="xxs" data-disabled="true" value="""),_display_(Seq[Any](/*76.89*/product/*76.96*/.rating)),format.raw/*76.103*/(""">
						                <label>$"""),_display_(Seq[Any](/*77.32*/product/*77.39*/.price)),format.raw/*77.45*/("""</label>
						            </div>
						            <script>
						            	var i = """),_display_(Seq[Any](/*80.29*/product/*80.36*/.prod_id)),format.raw/*80.44*/(""";
						            	$("#"""),_display_(Seq[Any](/*81.25*/product/*81.32*/.prod_id)),format.raw/*81.40*/("""").click(function() """),format.raw/*81.60*/("""{"""),format.raw/*81.61*/("""
						            		var url = window.location.href.split("/")[0];
							        		window.location.href = url + "/product?p=" + """),_display_(Seq[Any](/*83.64*/product/*83.71*/.prod_id)),format.raw/*83.79*/(""";
						            	"""),format.raw/*84.20*/("""}"""),format.raw/*84.21*/(""");
						            </script>
								""")))})),format.raw/*86.10*/("""
							</div>
				    	</div>
				    	<nav>
						  <ul class="pager">
						    <li id="olderEl" class="previous"><a href="#" id="older"><span aria-hidden="true">&larr;</span> Older</a></li>
						    <li class="next"><a href="#" id="newer">Newer <span aria-hidden="true">&rarr;</span></a></li>
						  </ul>
						</nav>
					</div>
					<div class="col-sm-3" style="padding-left:40px;">
						<div class="btn-group-vertical" role="group">
							<button class="btn btn-default login" style="margin:3px"> View Orders </button>
				 	 		<button id="popup" class="btn btn-default login" onclick="div_show()" style="margin:3px;">Upload Pictures</button>
				  			<!-- <button type="button" class="btn btn-default" style="background-color: #6D9BC3 !important"><input type="file" data-filename-placement="inside"></button> -->
				  	
				  			<!-- NewsTicker Implementation -->
				  			<div id="wrap" style="border-radius: 5px;border: 1px solid #ccc;margin: 3px; margin-right: 0px;">
								<div id="head" class="block">
									<label> Your activity feed</label>
								</div>
								<div id="content" style="padding-top:0px">
									<div id="info" class="block">
										<ul id="ticker">					
											<li><span>Title Here</span><a href="#">Text Here</a></li>
											<li><span>Title Here</span><a href="#">Text Here</a></li>	
											<li><span>Title Here</span><a href="#">Text Here</a></li>					
											<li><span>Title Here</span><a href="#">Text Here</a></li>
											<li><span>Title Here</span><a href="#">Text Here</a></li>
										</ul>
									</div>
								</div>
							</div>
				  		</div>
					</div>
				</div>
			</div>
			<div id="imagemodal" class="modal fade in" role="dialog" aria-labelledby="imageModal">  
					<div class="modal-dialog" style="width: 800px; margin-top: 125px">
				        <div class="modal-content">
						    <div class="modal-header" style="text-align: center;">  
						    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						    	<label style="font-size:16px;margin-bottom:0px">UPLOAD YOUR DESIGNS!</label>
						    </div>      
						    <div class="modal-body" id="imageBody">
						    	<div class="container" style="width:750px">
						    		<label>Select files from your computer</label>
						    		<div style="inline-block">
						    			<div id="uploadfiles">
						    				<input type="file" multiple style="padding:10px">
						    			</div>
						    			<button class="btn btn-default prefSave" onclick="addinlineform()">Add more images</button>
						    			<a href="#" role="button" class="btn btn-default prefSave" data-dismiss="modal"  data-toggle="modal" data-target="#imageSaved" >Upload all images</a>
						    		</div>
						    	</div>
						    </div>
						</div>
					</div>
			</div>
			
			<div id="imageSaved" class="modal fade" role="dialog" aria-labelledby="imageSaved" aria-hidden="true">  
				<div class="modal-dialog" style="width: 800px; margin-top: 125px">
					<div class="modal-content">
						<div class="modal-header" style="text-align: center;">  
						    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						    <label style="font-size:16px;margin-bottom:0px">UPLOAD YOUR DESIGNS!</label>
						</div>      
						<div class="modal-body" id="merchantBody">
						    <div class="container-fluid" style="text-align: center;">
						    	<label>IMAGES UPLOADED!</label>
						    </div>  
					   	</div>
					</div>
				</div>
			</div> 
		</div>
		<script>
	    	window.onload = function() """),format.raw/*163.34*/("""{"""),format.raw/*163.35*/("""
	    		var p = getUrlParameter("p");
	    		if (p == 1) """),format.raw/*165.20*/("""{"""),format.raw/*165.21*/("""
	    			$("#olderEl").addClass("disabled");
	    		"""),format.raw/*167.8*/("""}"""),format.raw/*167.9*/("""
	    		
	    		$("#older").click(function() """),format.raw/*169.37*/("""{"""),format.raw/*169.38*/("""
	        		var curr = parseInt(getUrlParameter("p")) - 1;
	        		var url = window.location.href.split("?")[0];
	        		window.location.href = url + "?u="""),_display_(Seq[Any](/*172.46*/username)),format.raw/*172.54*/("""&p=" + curr;
	        	"""),format.raw/*173.11*/("""}"""),format.raw/*173.12*/(""");
	        	
	        	$("#newer").click(function() """),format.raw/*175.40*/("""{"""),format.raw/*175.41*/("""
	        		var curr = parseInt(getUrlParameter("p")) + 1;
	        		var url = window.location.href.split("?")[0];
	        		window.location.href = url + "?u="""),_display_(Seq[Any](/*178.46*/username)),format.raw/*178.54*/("""&p=" + curr;
	        	"""),format.raw/*179.11*/("""}"""),format.raw/*179.12*/(""");
	        	$("body").css("background-image", "url('assets/images/bg4.jpg')");
	    	"""),format.raw/*181.7*/("""}"""),format.raw/*181.8*/(""";
		</script>
	</body>
</html>"""))}
    }
    
    def render(username:String,products:List[Product]): play.api.templates.HtmlFormat.Appendable = apply(username,products)
    
    def f:((String,List[Product]) => play.api.templates.HtmlFormat.Appendable) = (username,products) => apply(username,products)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Dec 22 17:38:56 EST 2014
                    SOURCE: /home/sowmya/git/ElanIndulgence/app/views/merchant.scala.html
                    HASH: c21cb569611fc501a608a589a976e4576b375b9f
                    MATRIX: 791->1|930->46|1093->174|1107->180|1162->214|1253->270|1267->276|1332->319|1423->375|1437->381|1508->430|1605->491|1620->497|1674->529|1734->553|1749->559|1816->604|1924->676|1939->682|2006->727|2099->784|2114->790|2182->836|2275->893|2290->899|2354->941|2447->998|2462->1004|2517->1037|2610->1094|2625->1100|2682->1135|2775->1192|2790->1198|2851->1237|2944->1294|2959->1300|3025->1344|3128->1411|3143->1417|3201->1453|3302->1518|3317->1524|3379->1564|3560->1717|3589->1718|3656->1758|3684->1759|3745->1792|3774->1793|3888->1880|3916->1881|3981->1918|4010->1919|4220->2101|4249->2102|4404->2229|4433->2230|4520->2289|4549->2290|4588->2301|4617->2302|4651->2309|4679->2310|4815->2410|4830->2416|4875->2439|5088->2616|5120->2626|5581->3051|5596->3057|5641->3080|5885->3288|5918->3298|6188->3532|6228->3556|6268->3558|6446->3700|6462->3707|6492->3715|6612->3799|6628->3806|6656->3812|6836->3956|6852->3963|6882->3970|6951->4003|6967->4010|6995->4016|7120->4105|7136->4112|7166->4120|7228->4146|7244->4153|7274->4161|7322->4181|7351->4182|7517->4312|7533->4319|7563->4327|7612->4348|7641->4349|7713->4389|11342->7989|11372->7990|11458->8047|11488->8048|11568->8100|11597->8101|11671->8146|11701->8147|11899->8308|11930->8316|11982->8339|12012->8340|12094->8393|12124->8394|12322->8555|12353->8563|12405->8586|12435->8587|12549->8673|12578->8674
                    LINES: 26->1|29->1|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|54->26|54->26|56->28|56->28|58->30|58->30|60->32|60->32|61->33|61->33|65->37|65->37|68->40|68->40|70->42|70->42|71->43|71->43|72->44|72->44|76->48|76->48|76->48|78->50|78->50|87->59|87->59|87->59|91->63|91->63|99->71|99->71|99->71|101->73|101->73|101->73|102->74|102->74|102->74|104->76|104->76|104->76|105->77|105->77|105->77|108->80|108->80|108->80|109->81|109->81|109->81|109->81|109->81|111->83|111->83|111->83|112->84|112->84|114->86|191->163|191->163|193->165|193->165|195->167|195->167|197->169|197->169|200->172|200->172|201->173|201->173|203->175|203->175|206->178|206->178|207->179|207->179|209->181|209->181
                    -- GENERATED --
                */
            