
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
object slider extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<script type="text/javascript" src=""""),_display_(Seq[Any](/*1.38*/routes/*1.44*/.Assets.at("javascripts/slider/jquery-1.9.1.min.js"))),format.raw/*1.96*/(""""></script>
<script type="text/javascript" src=""""),_display_(Seq[Any](/*2.38*/routes/*2.44*/.Assets.at("javascripts/slider/jssor.js"))),format.raw/*2.85*/(""""></script>
<script type="text/javascript" src=""""),_display_(Seq[Any](/*3.38*/routes/*3.44*/.Assets.at("javascripts/slider/jssor.slider.js"))),format.raw/*3.92*/(""""></script>
<script>
	jQuery(document).ready(function ($) """),format.raw/*5.38*/("""{"""),format.raw/*5.39*/("""
		var _SlideshowTransitions = [
         //Fade
            """),format.raw/*8.13*/("""{"""),format.raw/*8.14*/(""" $Duration: 1200, $Opacity: 2 """),format.raw/*8.44*/("""}"""),format.raw/*8.45*/("""
            ];

            var options = """),format.raw/*11.27*/("""{"""),format.raw/*11.28*/("""
                $AutoPlay: true,                                    //[Optional] Whether to auto play, to enable slideshow, this option must be set to true, default value is false
                $AutoPlaySteps: 1,                                  //[Optional] Steps to go for each navigation request (this options applys only when slideshow disabled), the default value is 1
                $AutoPlayInterval: 3000,                            //[Optional] Interval (in milliseconds) to go for next slide since the previous stopped if the slider is auto playing, default value is 3000
                $PauseOnHover: 1,                               //[Optional] Whether to pause when mouse over if a slider is auto playing, 0 no pause, 1 pause for desktop, 2 pause for touch device, 3 pause for desktop and touch device, 4 freeze for desktop, 8 freeze for touch device, 12 freeze for desktop and touch device, default value is 1

                $ArrowKeyNavigation: true,                           //[Optional] Allows keyboard (arrow key) navigation or not, default value is false
                $SlideDuration: 500,                                //[Optional] Specifies default duration (swipe) for slide in milliseconds, default value is 500
                $MinDragOffsetToSlide: 20,                          //[Optional] Minimum drag offset to trigger slide , default value is 20
                //$SlideWidth: 600,                                 //[Optional] Width of every slide in pixels, default value is width of 'slides' container
                //$SlideHeight: 300,                                //[Optional] Height of every slide in pixels, default value is height of 'slides' container
                $SlideSpacing: 0,                                     //[Optional] Space between each slide in pixels, default value is 0
                $DisplayPieces: 1,                                  //[Optional] Number of pieces to display (the slideshow would be disabled if the value is set to greater than 1), the default value is 1
                $ParkingPosition: 0,                                //[Optional] The offset position to park slide (this options applys only when slideshow disabled), default value is 0.
                $UISearchMode: 1,                                   //[Optional] The way (0 parellel, 1 recursive, default value is 1) to search UI components (slides container, loading screen, navigator container, arrow navigator container, thumbnail navigator container etc).
                $PlayOrientation: 1,                                //[Optional] Orientation to play slide (for auto play, navigation), 1 horizental, 2 vertical, 5 horizental reverse, 6 vertical reverse, default value is 1
                $DragOrientation: 3,                                //[Optional] Orientation to drag slide, 0 no drag, 1 horizental, 2 vertical, 3 either, default value is 1 (Note that the $DragOrientation should be the same as $PlayOrientation when $DisplayPieces is greater than 1, or parking position is not 0)

                $SlideshowOptions: """),format.raw/*29.36*/("""{"""),format.raw/*29.37*/("""                                //[Optional] Options to specify and enable slideshow or not
                    $Class: $JssorSlideshowRunner$,                 //[Required] Class to create instance of slideshow
                    $Transitions: _SlideshowTransitions,            //[Required] An array of slideshow transitions to play slideshow
                    $TransitionsOrder: 1,                           //[Optional] The way to choose transition to play slide, 1 Sequence, 0 Random
                    $ShowLink: true                                    //[Optional] Whether to bring slide link on top of the slider when slideshow is running, default value is false
                """),format.raw/*34.17*/("""}"""),format.raw/*34.18*/(""",

                $BulletNavigatorOptions: """),format.raw/*36.42*/("""{"""),format.raw/*36.43*/("""                                //[Optional] Options to specify and enable navigator or not
                    $Class: $JssorBulletNavigator$,                       //[Required] Class to create navigator instance
                    $ChanceToShow: 2,                               //[Required] 0 Never, 1 Mouse Over, 2 Always
                    $AutoCenter: 1,                                 //[Optional] Auto center navigator in parent container, 0 None, 1 Horizontal, 2 Vertical, 3 Both, default value is 0
                    $Steps: 1,                                      //[Optional] Steps to go for each navigation request, default value is 1
                    $Lanes: 1,                                      //[Optional] Specify lanes to arrange items, default value is 1
                    $SpacingX: 10,                                   //[Optional] Horizontal space between each item in pixel, default value is 0
                    $SpacingY: 10,                                   //[Optional] Vertical space between each item in pixel, default value is 0
                    $Orientation: 1                                 //[Optional] The orientation of the navigator, 1 horizontal, 2 vertical, default value is 1
                """),format.raw/*45.17*/("""}"""),format.raw/*45.18*/(""",

                $ArrowNavigatorOptions: """),format.raw/*47.41*/("""{"""),format.raw/*47.42*/("""
                    $Class: $JssorArrowNavigator$,              //[Requried] Class to create arrow navigator instance
                    $ChanceToShow: 2,                               //[Required] 0 Never, 1 Mouse Over, 2 Always
                    $Steps: 1                                       //[Optional] Steps to go for each navigation request, default value is 1
                """),format.raw/*51.17*/("""}"""),format.raw/*51.18*/("""
            """),format.raw/*52.13*/("""}"""),format.raw/*52.14*/(""";
            var jssor_slider1 = new $JssorSlider$("slider1_container", options);

            //responsive code begin
            //you can remove responsive code if you don't want the slider scales while window resizes
            function ScaleSlider() """),format.raw/*57.36*/("""{"""),format.raw/*57.37*/("""
                var parentWidth = jssor_slider1.$Elmt.parentNode.clientWidth;
                if (parentWidth)
                    jssor_slider1.$ScaleWidth(Math.min(parentWidth, 600));
                else
                    window.setTimeout(ScaleSlider, 30);
            """),format.raw/*63.13*/("""}"""),format.raw/*63.14*/("""
            ScaleSlider();

            $(window).bind("load", ScaleSlider);
            $(window).bind("resize", ScaleSlider);
            $(window).bind("orientationchange", ScaleSlider);
            //responsive code end
        """),format.raw/*70.9*/("""}"""),format.raw/*70.10*/(""");
    </script>
    <!-- Jssor Slider Begin -->
    <!-- You can move inline styles to css file or css block. -->
<div class="container-fluid" style="padding-left:345px">
    <div id="slider1_container" style="position: relative; top: 0px; left: 0px; width: 400px; height: 350px; overflow: hidden;">

        <!-- Loading Screen -->
        <div u="loading" style="position: absolute; top: 0px; left: 0px;">
            <div style="filter: alpha(opacity=70); opacity:0.7; position: absolute; display: block;
                background-color: #000000; top: 0px; left: 0px;width: 100%;height:100%;">
            </div>
            <div style="position: absolute; display: block; background: url(img/loading.gif) no-repeat center center;
                top: 0px; left: 0px;width: 100%;height:100%;">
            </div>
        </div>

        <!-- Slides Container -->
        <div u="slides" style="cursor: move; position: absolute; left: 0px; top: 0px; width: 400px; height: 350px; overflow: hidden; align-component: center;">
             <div>
                <img u="image" src=""""),_display_(Seq[Any](/*90.38*/routes/*90.44*/.Assets.at("images/homeslider/10.jpg"))),format.raw/*90.82*/("""" />
            </div>
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*93.38*/routes/*93.44*/.Assets.at("images/homeslider/11.jpg"))),format.raw/*93.82*/("""" />
            </div>
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*96.38*/routes/*96.44*/.Assets.at("images/homeslider/12.jpg"))),format.raw/*96.82*/("""" />
            </div>
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*99.38*/routes/*99.44*/.Assets.at("images/homeslider/13.jpg"))),format.raw/*99.82*/("""" />
            </div>
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*102.38*/routes/*102.44*/.Assets.at("images/homeslider/14.jpg"))),format.raw/*102.82*/("""" />
            </div>
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*105.38*/routes/*105.44*/.Assets.at("images/homeslider/15.jpg"))),format.raw/*105.82*/("""" />
            </div>
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*108.38*/routes/*108.44*/.Assets.at("images/homeslider/17.jpg"))),format.raw/*108.82*/("""" />
            </div>
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*111.38*/routes/*111.44*/.Assets.at("images/homeslider/18.jpg"))),format.raw/*111.82*/("""" />
            </div>
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*114.38*/routes/*114.44*/.Assets.at("images/homeslider/19.jpg"))),format.raw/*114.82*/("""" />
            </div>
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*117.38*/routes/*117.44*/.Assets.at("images/homeslider/20.jpg"))),format.raw/*117.82*/("""" />
            </div>
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*120.38*/routes/*120.44*/.Assets.at("images/homeslider/1.jpg"))),format.raw/*120.81*/("""" />
            </div>
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*123.38*/routes/*123.44*/.Assets.at("images/homeslider/2.jpg"))),format.raw/*123.81*/("""" />
            </div>
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*126.38*/routes/*126.44*/.Assets.at("images/homeslider/3.jpg"))),format.raw/*126.81*/("""" />
            </div>
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*129.38*/routes/*129.44*/.Assets.at("images/homeslider/4.jpg"))),format.raw/*129.81*/("""" />
            </div>
           
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*133.38*/routes/*133.44*/.Assets.at("images/homeslider/7.jpg"))),format.raw/*133.81*/("""" />
            </div>
          
           
                </div>

        <!-- Bullet Navigator Skin Begin -->
        <style>
            /* jssor slider bullet navigator skin 05 css */
            /*
            .jssorb05 div           (normal)
            .jssorb05 div:hover     (normal mouseover)
            .jssorb05 .av           (active)
            .jssorb05 .av:hover     (active mouseover)
            .jssorb05 .dn           (mousedown)
            */
            .jssorb05 div, .jssorb05 div:hover, .jssorb05 .av """),format.raw/*149.63*/("""{"""),format.raw/*149.64*/("""
                background: url("""),_display_(Seq[Any](/*150.34*/routes/*150.40*/.Assets.at("images/testSlider/b05.png"))),format.raw/*150.79*/(""") no-repeat;
                overflow: hidden;
                cursor: pointer;
            """),format.raw/*153.13*/("""}"""),format.raw/*153.14*/("""

            .jssorb05 div """),format.raw/*155.27*/("""{"""),format.raw/*155.28*/("""
                background-position: -7px -7px;
            """),format.raw/*157.13*/("""}"""),format.raw/*157.14*/("""

                .jssorb05 div:hover, .jssorb05 .av:hover """),format.raw/*159.58*/("""{"""),format.raw/*159.59*/("""
                    background-position: -37px -7px;
                """),format.raw/*161.17*/("""}"""),format.raw/*161.18*/("""

            .jssorb05 .av """),format.raw/*163.27*/("""{"""),format.raw/*163.28*/("""
                background-position: -67px -7px;
            """),format.raw/*165.13*/("""}"""),format.raw/*165.14*/("""

            .jssorb05 .dn, .jssorb05 .dn:hover """),format.raw/*167.48*/("""{"""),format.raw/*167.49*/("""
                background-position: -97px -7px;
            """),format.raw/*169.13*/("""}"""),format.raw/*169.14*/("""
        </style>
        <!-- bullet navigator container -->
        <div u="navigator" class="jssorb05" style="position: absolute; bottom: 16px; right: 6px;">
            <!-- bullet navigator item prototype -->
            <div u="prototype" style="POSITION: absolute; WIDTH: 16px; HEIGHT: 16px;"></div>
        </div>
        <!-- Bullet Navigator Skin End -->
        <!-- Arrow Navigator Skin Begin -->
        <style>
            /* jssor slider arrow navigator skin 12 css */
            /*
            .jssora12l              (normal)
            .jssora12r              (normal)
            .jssora12l:hover        (normal mouseover)
            .jssora12r:hover        (normal mouseover)
            .jssora12ldn            (mousedown)
            .jssora12rdn            (mousedown)
            */
            .jssora12l, .jssora12r, .jssora12ldn, .jssora12rdn """),format.raw/*188.64*/("""{"""),format.raw/*188.65*/("""
                position: absolute;
                cursor: pointer;
                display: block;
                background: url("""),_display_(Seq[Any](/*192.34*/routes/*192.40*/.Assets.at("images/testSlider/a12.png"))),format.raw/*192.79*/(""") no-repeat;
                overflow: hidden;
            """),format.raw/*194.13*/("""}"""),format.raw/*194.14*/("""

            .jssora12l """),format.raw/*196.24*/("""{"""),format.raw/*196.25*/("""
                background-position: -16px -37px;
            """),format.raw/*198.13*/("""}"""),format.raw/*198.14*/("""

            .jssora12r """),format.raw/*200.24*/("""{"""),format.raw/*200.25*/("""
                background-position: -75px -37px;
            """),format.raw/*202.13*/("""}"""),format.raw/*202.14*/("""

            .jssora12l:hover """),format.raw/*204.30*/("""{"""),format.raw/*204.31*/("""
                background-position: -136px -37px;
            """),format.raw/*206.13*/("""}"""),format.raw/*206.14*/("""

            .jssora12r:hover """),format.raw/*208.30*/("""{"""),format.raw/*208.31*/("""
                background-position: -195px -37px;
            """),format.raw/*210.13*/("""}"""),format.raw/*210.14*/("""

            .jssora12ldn """),format.raw/*212.26*/("""{"""),format.raw/*212.27*/("""
                background-position: -256px -37px;
            """),format.raw/*214.13*/("""}"""),format.raw/*214.14*/("""

            .jssora12rdn """),format.raw/*216.26*/("""{"""),format.raw/*216.27*/("""
                background-position: -315px -37px;
            """),format.raw/*218.13*/("""}"""),format.raw/*218.14*/("""
        </style>
        <!-- Arrow Left -->
        <span u="arrowleft" class="jssora12l" style="width: 30px; height: 46px; top: 123px; left: 0px;">
        </span>
        <!-- Arrow Right -->
        <span u="arrowright" class="jssora12r" style="width: 30px; height: 46px; top: 123px; right: 0px">
        </span>
        <!-- Arrow Navigator Skin End -->
        <a style="display: none" href="http://www.jssor.com">bootstrap slider</a>
    </div>
</div>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Dec 22 17:34:16 EST 2014
                    SOURCE: /home/sowmya/git/ElanIndulgence/app/views/slider.scala.html
                    HASH: f7d47871683fbf58cc8f5b6936d70e40009402cd
                    MATRIX: 856->0|928->37|942->43|1015->95|1099->144|1113->150|1175->191|1259->240|1273->246|1342->294|1427->352|1455->353|1543->414|1571->415|1628->445|1656->446|1727->489|1756->490|4870->3576|4899->3577|5616->4266|5645->4267|5717->4311|5746->4312|7025->5563|7054->5564|7125->5607|7154->5608|7571->5997|7600->5998|7641->6011|7670->6012|7955->6269|7984->6270|8288->6546|8317->6547|8577->6780|8606->6781|9726->7865|9741->7871|9801->7909|9916->7988|9931->7994|9991->8032|10106->8111|10121->8117|10181->8155|10296->8234|10311->8240|10371->8278|10487->8357|10503->8363|10564->8401|10680->8480|10696->8486|10757->8524|10873->8603|10889->8609|10950->8647|11066->8726|11082->8732|11143->8770|11259->8849|11275->8855|11336->8893|11452->8972|11468->8978|11529->9016|11645->9095|11661->9101|11721->9138|11837->9217|11853->9223|11913->9260|12029->9339|12045->9345|12105->9382|12221->9461|12237->9467|12297->9504|12425->9595|12441->9601|12501->9638|13062->10170|13092->10171|13163->10205|13179->10211|13241->10250|13362->10342|13392->10343|13449->10371|13479->10372|13569->10433|13599->10434|13687->10493|13717->10494|13816->10564|13846->10565|13903->10593|13933->10594|14024->10656|14054->10657|14132->10706|14162->10707|14253->10769|14283->10770|15185->11643|15215->11644|15387->11779|15403->11785|15465->11824|15553->11883|15583->11884|15637->11909|15667->11910|15759->11973|15789->11974|15843->11999|15873->12000|15965->12063|15995->12064|16055->12095|16085->12096|16178->12160|16208->12161|16268->12192|16298->12193|16391->12257|16421->12258|16477->12285|16507->12286|16600->12350|16630->12351|16686->12378|16716->12379|16809->12443|16839->12444
                    LINES: 29->1|29->1|29->1|29->1|30->2|30->2|30->2|31->3|31->3|31->3|33->5|33->5|36->8|36->8|36->8|36->8|39->11|39->11|57->29|57->29|62->34|62->34|64->36|64->36|73->45|73->45|75->47|75->47|79->51|79->51|80->52|80->52|85->57|85->57|91->63|91->63|98->70|98->70|118->90|118->90|118->90|121->93|121->93|121->93|124->96|124->96|124->96|127->99|127->99|127->99|130->102|130->102|130->102|133->105|133->105|133->105|136->108|136->108|136->108|139->111|139->111|139->111|142->114|142->114|142->114|145->117|145->117|145->117|148->120|148->120|148->120|151->123|151->123|151->123|154->126|154->126|154->126|157->129|157->129|157->129|161->133|161->133|161->133|177->149|177->149|178->150|178->150|178->150|181->153|181->153|183->155|183->155|185->157|185->157|187->159|187->159|189->161|189->161|191->163|191->163|193->165|193->165|195->167|195->167|197->169|197->169|216->188|216->188|220->192|220->192|220->192|222->194|222->194|224->196|224->196|226->198|226->198|228->200|228->200|230->202|230->202|232->204|232->204|234->206|234->206|236->208|236->208|238->210|238->210|240->212|240->212|242->214|242->214|244->216|244->216|246->218|246->218
                    -- GENERATED --
                */
            