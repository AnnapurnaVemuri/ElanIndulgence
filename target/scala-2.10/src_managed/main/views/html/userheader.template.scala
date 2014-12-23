
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
object userheader extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(user: String, register: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.34*/("""

<div>
	<div class="header">
		<a href=""""),_display_(Seq[Any](/*5.13*/routes/*5.19*/.Application.loadMain())),format.raw/*5.42*/("""" role="button"
			class="transparent logo">Elan Indulgence</a>
		<div class="btn-group user">
			<button type="button" class="btn user" style="font-family: fantasy">Welcome """),_display_(Seq[Any](/*8.81*/{user})),format.raw/*8.87*/("""</button>
			<button type="button" class="btn dropdown-toggle user"
				data-toggle="dropdown" aria-expanded="false">
				<span class="caret"></span> <span class="sr-only">Toggle
					Dropdown</span>
			</button>
			<ul class="dropdown-menu" role="menu">
				<li><a href="#" style="font-size: 10px;font-family: fantasy"  class="transparent" >DETAILS</a></li>
				<li class="divider"></li>
				<li><a href="#" role="button" class="transparent"
					data-toggle="modal" data-target="#prefmodal"
					style="font-size: 10px;font-family: fantasy">PREFERENCES</a></li>
				<li class="divider"></li>
				<li><a href="#" style="font-size: 10px;font-family: fantasy" class="transparent" >ORDERS</a></li>
				<li class="divider"></li>
				<li><a href="#" style="font-size: 10px;font-family: fantasy" class="transparent" >RATINGS</a></li>
				<li class="divider"></li>
				<li><a href=""""),_display_(Seq[Any](/*25.19*/routes/*25.25*/.Application.loadMain())),format.raw/*25.48*/(""""
					style="font-size: 10px;font-family: fantasy" class="transparent" >LOGOUT</a></li>
			</ul>
		</div>
	</div>
	"""),_display_(Seq[Any](/*30.3*/register/*30.11*/ match/*30.17*/ {/*31.4*/case "TRUE" =>/*31.18*/ {_display_(Seq[Any](format.raw/*31.20*/("""
							<script type="text/javascript">
							    $(window).load(function()"""),format.raw/*33.37*/("""{"""),format.raw/*33.38*/("""
							        $("#prefmodal").modal('show');
							    """),format.raw/*35.12*/("""}"""),format.raw/*35.13*/(""");
							</script>
						   """)))}/*38.4*/case "FALSE" =>/*38.19*/ {_display_(Seq[Any](format.raw/*38.21*/(""" """)))}})),format.raw/*39.4*/("""
	<div id="prefmodal" class="modal fade" role="dialog"
		aria-labelledby="prefModal">
		<div class="modal-dialog" style="width: 800px; margin-top: 50px;">
			<div class="modal-content" style="height: 550px">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h3 class="loginh3" style="font-family: fantasy;font-weight: bold">Welcome
						"""),_display_(Seq[Any](/*48.8*/{user})),format.raw/*48.14*/("""! Please fill your preferences</h3>
				</div>
				<div class="modal-body" id="pmodal">
					<form id="prefForm" method="post" action=""""),_display_(Seq[Any](/*51.49*/routes/*51.55*/.Application.saveUserPreferences())),format.raw/*51.89*/("""">
						<div id="typePref" style="border-bottom: 1px solid #ccc">
							<h3 style="text-align: center; padding-bottom: 10px;font-family: fantasy">
								<span class="label label-primary">Product Preferences</span>
							</h3>
							<div class="container">
								<div class="row">
									<div  class="col-xs-2" style="font-family: fantasy">
										<label>
											<span class="label label-primary">Women</span>
										</label>
										<div class="form-group">
											<label class="checkbox" style="font-size: 10px;font-weight: normal;font-family: fantasy">
												<input type="checkbox" value="1">SAREES
											</label>
											<label class="checkbox" style="font-size: 10px;font-weight: normal;font-family: fantasy">
												<input type="checkbox" value="2">LEHENGAS
											</label> 
											<label class="checkbox" style="font-size: 10px;font-weight: normal;font-family: fantasy">
												<input type="checkbox" value="3">KURTIS
											</label> 
											<label class="checkbox" style="font-size: 10px;font-weight: normal;font-family: fantasy">
												<input type="checkbox" value="4">SALWAR KAMEEZ
											</label> 
											<label class="checkbox" style="font-size: 10px;font-weight: normal;font-family: fantasy">
												<input type="checkbox" value="5">DRESSES
											</label> 
											<label class="checkbox" style="font-size: 10px;font-weight: normal;font-family: fantasy">
												<input type="checkbox" value="6">JEWELLERY
											</label> 
											<label class="checkbox" style="font-size: 10px;font-weight: normal;font-family: fantasy">
												<input type="checkbox" value="7">BAGS
											</label> 
											<label class="checkbox" style="font-size: 10px;font-weight: normal;font-family: fantasy">
												<input type="checkbox" value="8">FOOTWEAR
											</label> 
											<label class="checkbox" style="font-size: 10px;font-weight: normal;font-family: fantasy">
												<input type="checkbox" value="9">SCARVES
											</label>
										</div>
									</div>
									<div  class="col-xs-2" style="font-family: fantasy">
										<label>
											<span class="label label-primary">Men</span>
										</label>
										<div class="form-group">
											<label class="checkbox" style="font-size: 10px;font-weight: normal;font-family: fantasy">
												<input type="checkbox" value="10">SHERWANI
											</label> 
											<label class="checkbox" style="font-size: 10px;font-weight: normal;font-family: fantasy">
												<input type="checkbox" value="11">KURTAS
											</label> 
											<label class="checkbox" style="font-size: 10px;font-weight: normal;font-family: fantasy">
												<input type="checkbox" value="12">SUITS
											</label>
										</div>
									</div>
									<div  class="col-xs-4">
										<div class="col-sm-offset-4" style="font-family: fantasy">
											<label><span class="label label-primary">Kids</span></label>
										</div>
										<div class="container">
											<div class="row">
												<div class="col-xs-2">
													<div style="font-family: fantasy">
														<label><span class="label label-primary">Girls</span></label>
													</div>
													<div class="form-group">
														<label class="checkbox" style="font-size: 10px;font-weight: normal;font-family: fantasy">
															<input type="checkbox" value="13">ETHNIC WEAR
														</label>
														<label class="checkbox" style="font-size: 10px;font-weight: normal;font-family: fantasy">
															<input type="checkbox" value="14">DRESSES
														</label>
													</div>
												</div>
												<div class="col-xs-2">
													<div style="font-family: fantasy">
														<label><span class="label label-primary">Boys</span></label>
													</div>
													<label class="checkbox" style="font-size: 10px;font-weight: normal;font-family: fantasy">
														<input type="checkbox" value="15">ETHNIC WEAR
													</label>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div id="colorPref">
							<h3 style="text-align: center; padding-bottom: 10px;font-family: fantasy">
								<span class="label label-primary">Color Preferences</span>
							</h3>
							<div class="container-fluid form-group" style="font-family: fantasy">
								<label class="checkbox-inline" style="font-size: 12px; color: red"> 
									<input type="checkbox" value="16">RED
								</label> 
								<label class="checkbox-inline" style="font-size: 12px; color: blue"> 
									<input type="checkbox" value="17">BLUE
								</label> 
								<label class="checkbox-inline"
									style="font-size: 12px; color: green"> <input
									type="checkbox" value="18">GREEN
								</label> 
								<label class="checkbox-inline"
									style="font-size: 12px; color: black"> <input
									type="checkbox" value="19">BLACK
								</label> 
								<label class="checkbox-inline"
									style="font-size: 12px; color: yellow"> <input
									type="checkbox" value="20">YELLOW
								</label> 
								<label class="checkbox-inline"
									style="font-size: 12px; color: silver"> <input
									type="checkbox" value="21">SILVER
								</label> 
								<label class="checkbox-inline"
									style="font-size: 12px; color: gold"> <input
									type="checkbox" value="22">GOLD
								</label> 
								<label class="checkbox-inline"
									style="font-size: 12px; color: purple"> <input
									type="checkbox" value="23">PURPLE
								</label> 
								<label class="checkbox-inline"
									style="font-size: 12px; color: pink"> <input
									type="checkbox" value="24">PINK
								</label> 
								<label class="checkbox-inline"
									style="font-size: 12px; color: orange"> <input
									type="checkbox" value="25">ORANGE
								</label> 
								<label class="checkbox-inline"
									style="font-size: 12px; color: cream"> <input
									type="checkbox" value="26">CREAM
								</label> 
								<label class="checkbox-inline"
									style="font-size: 12px; color: #e1ebf3"> <input
									type="checkbox" value="27">WHITE
								</label> 
								<label class="checkbox-inline"
									style="font-size: 12px; color: grey"> <input
									type="checkbox" value="28">GREY
								</label> 
								<label class="checkbox-inline"
									style="font-size: 12px; color: brown"> <input
									type="checkbox" value="29">BROWN
								</label>
								<input type="checkbox" class="hide" value="""),_display_(Seq[Any](/*200.52*/user)),format.raw/*200.56*/(""" name="username">
							</div>
						</div>
						<div class="form-group" style="float:right">
				            <button type="button" class="btn btn-default prefSave" data-dismiss="modal">Save</button>
				        </div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>"""))}
    }
    
    def render(user:String,register:String): play.api.templates.HtmlFormat.Appendable = apply(user,register)
    
    def f:((String,String) => play.api.templates.HtmlFormat.Appendable) = (user,register) => apply(user,register)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Dec 22 17:34:17 EST 2014
                    SOURCE: /home/sowmya/git/ElanIndulgence/app/views/userheader.scala.html
                    HASH: d3afb91c51382721fe8f409acac2941f7b09de3a
                    MATRIX: 786->1|912->33|989->75|1003->81|1047->104|1257->279|1284->285|2197->1162|2212->1168|2257->1191|2409->1308|2426->1316|2441->1322|2451->1329|2474->1343|2514->1345|2618->1421|2647->1422|2733->1480|2762->1481|2810->1515|2834->1530|2874->1532|2908->1539|3373->1969|3401->1975|3573->2111|3588->2117|3644->2151|10331->8801|10358->8805
                    LINES: 26->1|29->1|33->5|33->5|33->5|36->8|36->8|53->25|53->25|53->25|58->30|58->30|58->30|58->31|58->31|58->31|60->33|60->33|62->35|62->35|64->38|64->38|64->38|64->39|73->48|73->48|76->51|76->51|76->51|225->200|225->200
                    -- GENERATED --
                */
            