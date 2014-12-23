
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
object navigation extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<div style="margin:0">
		<nav class="navbar" role="navigation" style="background-color: #6D9BC3;border-radius: 0px;font-size:12px;">
			<div class="container-fluid">
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
		        		<li><a href=""""),_display_(Seq[Any](/*6.27*/routes/*6.33*/.RecoDB.getLatestProducts(1))),format.raw/*6.61*/("""" style="color:white;font-family: fantasy;" class="maindrop">NEW ARRIVALS</a></li>
				        <li class="dropdown">
				          <a href="#" class="dropdown-toggle maindrop" data-toggle="dropdown" role="button" aria-expanded="false" style="color:white;font-family: fantasy;">WOMEN<span class="caret"></span></a>
				          <ul class="dropdown-menu" role="menu">
				            <li><a href="#" style="font-weight: bold;font-size: 12px;color: #6D9BC3;font-family: fantasy;">ETHNIC</a></li>
				            <li class="divider"></li>
				            <li><a href=""""),_display_(Seq[Any](/*12.31*/routes/*12.37*/.FilterDB.getProductByProdTypeAndRatingWithoutColor(1,1))),format.raw/*12.93*/("""" style="font-size: 10px;font-family: fantasy;">SAREE</a></li>
				            <li><a href=""""),_display_(Seq[Any](/*13.31*/routes/*13.37*/.FilterDB.getProductByProdTypeAndRatingWithoutColor(2,1))),format.raw/*13.93*/("""" style="font-size: 10px;font-family: fantasy;">LEHENGAS</a></li>
				            <li><a href=""""),_display_(Seq[Any](/*14.31*/routes/*14.37*/.FilterDB.getProductByProdTypeAndRatingWithoutColor(3,1))),format.raw/*14.93*/("""" style="font-size: 10px;font-family: fantasy;">KURTIS</a></li>
				            <li><a href=""""),_display_(Seq[Any](/*15.31*/routes/*15.37*/.FilterDB.getProductByProdTypeAndRatingWithoutColor(4,1))),format.raw/*15.93*/("""" style="font-size: 10px;font-family: fantasy;">SALWAR KAMEEZ</a></li>
				            <li style="padding-top:20px"><a href="#" style="font-weight: bold;font-size: 12px;color: #6D9BC3;font-family: fantasy;">WESTERN</a></li>
				            <li class="divider"></li>
				            <li><a href=""""),_display_(Seq[Any](/*18.31*/routes/*18.37*/.FilterDB.getProductByProdTypeAndRatingWithoutColor(5,1))),format.raw/*18.93*/("""" style="font-size: 10px;font-family: fantasy;">DRESSES</a></li>
				            <li style="padding-top:20px"><a href="#" style="font-weight: bold;font-size: 12px;color: #6D9BC3;font-family: fantasy;">ACCESSORIES</a></li>
				            <li class="divider"></li>
				            <li><a href=""""),_display_(Seq[Any](/*21.31*/routes/*21.37*/.FilterDB.getProductByProdTypeAndRatingWithoutColor(6,1))),format.raw/*21.93*/("""" style="font-size: 10px;font-family: fantasy;">JEWELLERY</a></li>
				            <li><a href=""""),_display_(Seq[Any](/*22.31*/routes/*22.37*/.FilterDB.getProductByProdTypeAndRatingWithoutColor(7,1))),format.raw/*22.93*/("""" style="font-size: 10px;font-family: fantasy;">BAGS</a></li>
				            <li><a href=""""),_display_(Seq[Any](/*23.31*/routes/*23.37*/.FilterDB.getProductByProdTypeAndRatingWithoutColor(8,1))),format.raw/*23.93*/("""" style="font-size: 10px;font-family: fantasy;">FOOTWEAR</a></li>
				            <li><a href=""""),_display_(Seq[Any](/*24.31*/routes/*24.37*/.FilterDB.getProductByProdTypeAndRatingWithoutColor(9,1))),format.raw/*24.93*/("""" style="font-size: 10px;font-family: fantasy;">SCARVES</a></li>
				          </ul>
				        </li>
				        <li class="dropdown">
				          <a href="#" class="dropdown-toggle maindrop" data-toggle="dropdown" role="button" aria-expanded="false" style="color:white;font-family: fantasy;">MEN<span class="caret"></span></a>
				          <ul class="dropdown-menu" role="menu">
				            <li><a href="#" style="font-weight: bold;font-size: 12px;font-family: fantasy;color: #6D9BC3">ETHNIC</a></li>
				            <li class="divider"></li>
				            <li><a href=""""),_display_(Seq[Any](/*32.31*/routes/*32.37*/.FilterDB.getProductByProdTypeAndRatingWithoutColor(10,1))),format.raw/*32.94*/("""" style="font-size: 10px;font-family: fantasy;">SHERWANI</a></li>
				            <li><a href=""""),_display_(Seq[Any](/*33.31*/routes/*33.37*/.FilterDB.getProductByProdTypeAndRatingWithoutColor(11,1))),format.raw/*33.94*/("""" style="font-size: 10px;font-family: fantasy;">KURTAS</a></li>
				            <li style="padding-top:20px"><a href="#" style="font-weight: bold;font-size: 12px;font-family: fantasy;color: #6D9BC3">WESTERN</a></li>
				            <li class="divider"></li>
				            <li><a href=""""),_display_(Seq[Any](/*36.31*/routes/*36.37*/.FilterDB.getProductByProdTypeAndRatingWithoutColor(12,1))),format.raw/*36.94*/("""" style="font-size: 10px;font-family: fantasy;">SUITS</a></li>
				          </ul>
				        </li>
				        <li class="dropdown">
				          <a href="#" class="dropdown-toggle maindrop" data-toggle="dropdown" role="button" aria-expanded="false" style="color:white;font-family: fantasy;">KIDS<span class="caret"></span></a>
				          <ul class="dropdown-menu" role="menu">
				            <li><a href="#" style="font-weight: bold;font-size: 12px;font-family: fantasy;color: #6D9BC3">GIRLS</a></li>
				            <li class="divider"></li>
				            <li><a href=""""),_display_(Seq[Any](/*44.31*/routes/*44.37*/.FilterDB.getProductByProdTypeAndRatingWithoutColor(13,1))),format.raw/*44.94*/("""" style="font-size: 10px;font-family: fantasy;">ETHNIC</a></li>
				            <li><a href=""""),_display_(Seq[Any](/*45.31*/routes/*45.37*/.FilterDB.getProductByProdTypeAndRatingWithoutColor(14,1))),format.raw/*45.94*/("""" style="font-size: 10px;font-family: fantasy;">FROCKS</a></li>
				            <li style="padding-top:20px"><a href="#" style="font-weight: bold;font-size: 12px;font-family: fantasy;color: #6D9BC3">BOYS</a></li>
				            <li class="divider"></li>
				            <li><a href=""""),_display_(Seq[Any](/*48.31*/routes/*48.37*/.FilterDB.getProductByProdTypeAndRatingWithoutColor(15,1))),format.raw/*48.94*/("""" style="font-size: 10px;font-family: fantasy;">ETHNIC</a></li>
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
	</div>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Dec 22 17:38:56 EST 2014
                    SOURCE: /home/sowmya/git/ElanIndulgence/app/views/navigation.scala.html
                    HASH: 969193720ed45daa55d8f0ca334e8b0bfb06b91b
                    MATRIX: 860->0|1163->268|1177->274|1226->302|1828->868|1843->874|1921->930|2050->1023|2065->1029|2143->1085|2275->1181|2290->1187|2368->1243|2498->1337|2513->1343|2591->1399|2923->1695|2938->1701|3016->1757|3346->2051|3361->2057|3439->2113|3572->2210|3587->2216|3665->2272|3793->2364|3808->2370|3886->2426|4018->2522|4033->2528|4111->2584|4730->3167|4745->3173|4824->3230|4956->3326|4971->3332|5050->3389|5374->3677|5389->3683|5468->3740|6085->4321|6100->4327|6179->4384|6309->4478|6324->4484|6403->4541|6724->4826|6739->4832|6818->4889
                    LINES: 29->1|34->6|34->6|34->6|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|46->18|46->18|46->18|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|60->32|60->32|60->32|61->33|61->33|61->33|64->36|64->36|64->36|72->44|72->44|72->44|73->45|73->45|73->45|76->48|76->48|76->48
                    -- GENERATED --
                */
            