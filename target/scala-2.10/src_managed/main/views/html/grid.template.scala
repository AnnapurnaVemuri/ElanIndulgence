
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
object grid extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*3.5*/("""<!-- Page Content -->
    <div class="container">

        <div class="row">

            <div>
                <a  href="#">
                    <img  src=""""),_display_(Seq[Any](/*10.33*/routes/*10.39*/.Assets.at("images/homepage/2.jpg"))),format.raw/*10.74*/("""" height=500px  width =750px align=left  hspace=10px vspace=5px>
                </a>
            </div>
            <div >
                <a  href="#">
                    <img  src=""""),_display_(Seq[Any](/*15.33*/routes/*15.39*/.Assets.at("images/homepage/3.jpg"))),format.raw/*15.74*/("""" height=800px  width =400px align=right   vspace=5px >
                </a>
            </div>
            <div >
                <a  href="#">
                    <img  src=""""),_display_(Seq[Any](/*20.33*/routes/*20.39*/.Assets.at("images/homepage/4.jpg"))),format.raw/*20.74*/("""" height=290px  width =750px align=left  hspace=10px vspace=5px >
                </a>
            </div>
            <div >
                <a  href="#">
                    <img  src=""""),_display_(Seq[Any](/*25.33*/routes/*25.39*/.Assets.at("images/homepage/5.jpg"))),format.raw/*25.74*/("""" height=500px  width =580px align=right  vspace=5px >
                </a>
            </div>
            <div >
                <a  href="#">
                    <img  src=""""),_display_(Seq[Any](/*30.33*/routes/*30.39*/.Assets.at("images/homepage/1.jpg"))),format.raw/*30.74*/(""""  height=500px  width =580px align=left  vspace=5px>
                </a8
            </div>
            <div>
                <a  href="#">
                    <img  src=""""),_display_(Seq[Any](/*35.33*/routes/*35.39*/.Assets.at("images/homepage/10.png"))),format.raw/*35.75*/("""" height=800px  width =500px align=left   vspace=5px >
                </a>>
                </a>
            </div>
            <div ">
                <a  href="#">
                    <img  src=""""),_display_(Seq[Any](/*41.33*/routes/*41.39*/.Assets.at("images/homepage/6.jpg"))),format.raw/*41.74*/("""" height=400px  width =650px align=left hspace=10px  vspace=5px >
                </a>>
                </a>
            </div>
            <div >
                <a  href="#">
                    <img src=""""),_display_(Seq[Any](/*47.32*/routes/*47.38*/.Assets.at("images/homepage/7.jpg"))),format.raw/*47.73*/("""" height=390px  width =650px align=left hspace=10px  vspace=5px >
                </a>> >
                </a>
            </div>
            <div >
                <a  href="#">
                    <img  src=""""),_display_(Seq[Any](/*53.33*/routes/*53.39*/.Assets.at("images/homepage/11.png"))),format.raw/*53.75*/(""""height=600px  width =650px align=left  hspace=10px vspace=5px>
                </a>
            </div>
            <div >
                <a  href="#">
                    <img src=""""),_display_(Seq[Any](/*58.32*/routes/*58.38*/.Assets.at("images/homepage/9.png"))),format.raw/*58.73*/("""" height=600px  width =500px align=right   vspace=5px >
                </a>
            </div>
            
            
</div>
        </div>
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Dec 22 17:34:17 EST 2014
                    SOURCE: /home/sowmya/git/ElanIndulgence/app/views/grid.scala.html
                    HASH: 8405b76b229df0bf11c762d5ef6124ba0e9bcab5
                    MATRIX: 854->6|1048->164|1063->170|1120->205|1342->391|1357->397|1414->432|1627->609|1642->615|1699->650|1922->837|1937->843|1994->878|2206->1054|2221->1060|2278->1095|2488->1269|2503->1275|2561->1311|2796->1510|2811->1516|2868->1551|3112->1759|3127->1765|3184->1800|3431->2011|3446->2017|3504->2053|3724->2237|3739->2243|3796->2278
                    LINES: 29->3|36->10|36->10|36->10|41->15|41->15|41->15|46->20|46->20|46->20|51->25|51->25|51->25|56->30|56->30|56->30|61->35|61->35|61->35|67->41|67->41|67->41|73->47|73->47|73->47|79->53|79->53|79->53|84->58|84->58|84->58
                    -- GENERATED --
                */
            