
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
object homeslide extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<script type="text/javascript" src=""""),_display_(Seq[Any](/*1.38*/routes/*1.44*/.Assets.at("javascripts/slider/jquery-1.9.1.min.js"))),format.raw/*1.96*/(""""></script>
    <!-- use jssor.slider.mini.js (40KB) instead for release -->
    <!-- jssor.slider.mini.js = (jssor.js + jssor.slider.js) -->
    <script type="text/javascript" src=""""),_display_(Seq[Any](/*4.42*/routes/*4.48*/.Assets.at("javascripts/slider/jssor.js"))),format.raw/*4.89*/(""""></script>
    <script type="text/javascript" src=""""),_display_(Seq[Any](/*5.42*/routes/*5.48*/.Assets.at("javascripts/slider/jssor.slider.js"))),format.raw/*5.96*/(""""></script>
    <script>
        jQuery(document).ready(function ($) """),format.raw/*7.45*/("""{"""),format.raw/*7.46*/("""

            var _CaptionTransitions = [];
            _CaptionTransitions["L"] = """),format.raw/*10.40*/("""{"""),format.raw/*10.41*/(""" $Duration: 900, x: 0.6, $Easing: """),format.raw/*10.75*/("""{"""),format.raw/*10.76*/(""" $Left: $JssorEasing$.$EaseInOutSine """),format.raw/*10.113*/("""}"""),format.raw/*10.114*/(""", $Opacity: 2 """),format.raw/*10.128*/("""}"""),format.raw/*10.129*/(""";
            _CaptionTransitions["R"] = """),format.raw/*11.40*/("""{"""),format.raw/*11.41*/(""" $Duration: 900, x: -0.6, $Easing: """),format.raw/*11.76*/("""{"""),format.raw/*11.77*/(""" $Left: $JssorEasing$.$EaseInOutSine """),format.raw/*11.114*/("""}"""),format.raw/*11.115*/(""", $Opacity: 2 """),format.raw/*11.129*/("""}"""),format.raw/*11.130*/(""";
            _CaptionTransitions["T"] = """),format.raw/*12.40*/("""{"""),format.raw/*12.41*/(""" $Duration: 900, y: 0.6, $Easing: """),format.raw/*12.75*/("""{"""),format.raw/*12.76*/(""" $Top: $JssorEasing$.$EaseInOutSine """),format.raw/*12.112*/("""}"""),format.raw/*12.113*/(""", $Opacity: 2 """),format.raw/*12.127*/("""}"""),format.raw/*12.128*/(""";
            _CaptionTransitions["B"] = """),format.raw/*13.40*/("""{"""),format.raw/*13.41*/(""" $Duration: 900, y: -0.6, $Easing: """),format.raw/*13.76*/("""{"""),format.raw/*13.77*/(""" $Top: $JssorEasing$.$EaseInOutSine """),format.raw/*13.113*/("""}"""),format.raw/*13.114*/(""", $Opacity: 2 """),format.raw/*13.128*/("""}"""),format.raw/*13.129*/(""";
            _CaptionTransitions["ZMF|10"] = """),format.raw/*14.45*/("""{"""),format.raw/*14.46*/(""" $Duration: 900, $Zoom: 11, $Easing: """),format.raw/*14.83*/("""{"""),format.raw/*14.84*/(""" $Zoom: $JssorEasing$.$EaseOutQuad, $Opacity: $JssorEasing$.$EaseLinear """),format.raw/*14.156*/("""}"""),format.raw/*14.157*/(""", $Opacity: 2 """),format.raw/*14.171*/("""}"""),format.raw/*14.172*/(""";
            _CaptionTransitions["RTT|10"] = """),format.raw/*15.45*/("""{"""),format.raw/*15.46*/(""" $Duration: 900, $Zoom: 11, $Rotate: 1, $Easing: """),format.raw/*15.95*/("""{"""),format.raw/*15.96*/(""" $Zoom: $JssorEasing$.$EaseOutQuad, $Opacity: $JssorEasing$.$EaseLinear, $Rotate: $JssorEasing$.$EaseInExpo """),format.raw/*15.204*/("""}"""),format.raw/*15.205*/(""", $Opacity: 2, $Round: """),format.raw/*15.228*/("""{"""),format.raw/*15.229*/(""" $Rotate: 0.8"""),format.raw/*15.242*/("""}"""),format.raw/*15.243*/(""" """),format.raw/*15.244*/("""}"""),format.raw/*15.245*/(""";
            _CaptionTransitions["RTT|2"] = """),format.raw/*16.44*/("""{"""),format.raw/*16.45*/(""" $Duration: 900, $Zoom: 3, $Rotate: 1, $Easing: """),format.raw/*16.93*/("""{"""),format.raw/*16.94*/(""" $Zoom: $JssorEasing$.$EaseInQuad, $Opacity: $JssorEasing$.$EaseLinear, $Rotate: $JssorEasing$.$EaseInQuad """),format.raw/*16.201*/("""}"""),format.raw/*16.202*/(""", $Opacity: 2, $Round: """),format.raw/*16.225*/("""{"""),format.raw/*16.226*/(""" $Rotate: 0.5"""),format.raw/*16.239*/("""}"""),format.raw/*16.240*/(""" """),format.raw/*16.241*/("""}"""),format.raw/*16.242*/(""";
            _CaptionTransitions["RTTL|BR"] = """),format.raw/*17.46*/("""{"""),format.raw/*17.47*/(""" $Duration: 900, x: -0.6, y: -0.6, $Zoom: 11, $Rotate: 1, $Easing: """),format.raw/*17.114*/("""{"""),format.raw/*17.115*/(""" $Left: $JssorEasing$.$EaseInCubic, $Top: $JssorEasing$.$EaseInCubic, $Zoom: $JssorEasing$.$EaseInCubic, $Opacity: $JssorEasing$.$EaseLinear, $Rotate: $JssorEasing$.$EaseInCubic """),format.raw/*17.293*/("""}"""),format.raw/*17.294*/(""", $Opacity: 2, $Round: """),format.raw/*17.317*/("""{"""),format.raw/*17.318*/(""" $Rotate: 0.8"""),format.raw/*17.331*/("""}"""),format.raw/*17.332*/(""" """),format.raw/*17.333*/("""}"""),format.raw/*17.334*/(""";
            _CaptionTransitions["CLIP|LR"] = """),format.raw/*18.46*/("""{"""),format.raw/*18.47*/(""" $Duration: 900, $Clip: 15, $Easing: """),format.raw/*18.84*/("""{"""),format.raw/*18.85*/(""" $Clip: $JssorEasing$.$EaseInOutCubic """),format.raw/*18.123*/("""}"""),format.raw/*18.124*/(""", $Opacity: 2 """),format.raw/*18.138*/("""}"""),format.raw/*18.139*/(""";
            _CaptionTransitions["MCLIP|L"] = """),format.raw/*19.46*/("""{"""),format.raw/*19.47*/(""" $Duration: 900, $Clip: 1, $Move: true, $Easing: """),format.raw/*19.96*/("""{"""),format.raw/*19.97*/(""" $Clip: $JssorEasing$.$EaseInOutCubic"""),format.raw/*19.134*/("""}"""),format.raw/*19.135*/(""" """),format.raw/*19.136*/("""}"""),format.raw/*19.137*/(""";
            _CaptionTransitions["MCLIP|R"] = """),format.raw/*20.46*/("""{"""),format.raw/*20.47*/(""" $Duration: 900, $Clip: 2, $Move: true, $Easing: """),format.raw/*20.96*/("""{"""),format.raw/*20.97*/(""" $Clip: $JssorEasing$.$EaseInOutCubic"""),format.raw/*20.134*/("""}"""),format.raw/*20.135*/(""" """),format.raw/*20.136*/("""}"""),format.raw/*20.137*/(""";

            var options = """),format.raw/*22.27*/("""{"""),format.raw/*22.28*/("""
                $FillMode: 2,                                       //[Optional] The way to fill image in slide, 0 stretch, 1 contain (keep aspect ratio and put all inside slide), 2 cover (keep aspect ratio and cover whole slide), 4 actual size, 5 contain for large image, actual size for small image, default value is 0
                $AutoPlay: true,                                    //[Optional] Whether to auto play, to enable slideshow, this option must be set to true, default value is false
                $AutoPlayInterval: 4000,                            //[Optional] Interval (in milliseconds) to go for next slide since the previous stopped if the slider is auto playing, default value is 3000
                $PauseOnHover: 1,                                   //[Optional] Whether to pause when mouse over if a slider is auto playing, 0 no pause, 1 pause for desktop, 2 pause for touch device, 3 pause for desktop and touch device, 4 freeze for desktop, 8 freeze for touch device, 12 freeze for desktop and touch device, default value is 1

                $ArrowKeyNavigation: true,   			            //[Optional] Allows keyboard (arrow key) navigation or not, default value is false
                $SlideEasing: $JssorEasing$.$EaseOutQuint,          //[Optional] Specifies easing for right to left animation, default value is $JssorEasing$.$EaseOutQuad
                $SlideDuration: 800,                               //[Optional] Specifies default duration (swipe) for slide in milliseconds, default value is 500
                $MinDragOffsetToSlide: 20,                          //[Optional] Minimum drag offset to trigger slide , default value is 20
                //$SlideWidth: 600,                                 //[Optional] Width of every slide in pixels, default value is width of 'slides' container
                //$SlideHeight: 300,                                //[Optional] Height of every slide in pixels, default value is height of 'slides' container
                $SlideSpacing: 0, 					                //[Optional] Space between each slide in pixels, default value is 0
                $DisplayPieces: 1,                                  //[Optional] Number of pieces to display (the slideshow would be disabled if the value is set to greater than 1), the default value is 1
                $ParkingPosition: 0,                                //[Optional] The offset position to park slide (this options applys only when slideshow disabled), default value is 0.
                $UISearchMode: 1,                                   //[Optional] The way (0 parellel, 1 recursive, default value is 1) to search UI components (slides container, loading screen, navigator container, arrow navigator container, thumbnail navigator container etc).
                $PlayOrientation: 1,                                //[Optional] Orientation to play slide (for auto play, navigation), 1 horizental, 2 vertical, 5 horizental reverse, 6 vertical reverse, default value is 1
                $DragOrientation: 1,                                //[Optional] Orientation to drag slide, 0 no drag, 1 horizental, 2 vertical, 3 either, default value is 1 (Note that the $DragOrientation should be the same as $PlayOrientation when $DisplayPieces is greater than 1, or parking position is not 0)

                $CaptionSliderOptions: """),format.raw/*41.40*/("""{"""),format.raw/*41.41*/("""                            //[Optional] Options which specifies how to animate caption
                    $Class: $JssorCaptionSlider$,                   //[Required] Class to create instance to animate caption
                    $CaptionTransitions: _CaptionTransitions,       //[Required] An array of caption transitions to play caption, see caption transition section at jssor slideshow transition builder
                    $PlayInMode: 1,                                 //[Optional] 0 None (no play), 1 Chain (goes after main slide), 3 Chain Flatten (goes after main slide and flatten all caption animations), default value is 1
                    $PlayOutMode: 3                                 //[Optional] 0 None (no play), 1 Chain (goes before main slide), 3 Chain Flatten (goes before main slide and flatten all caption animations), default value is 1
                """),format.raw/*46.17*/("""}"""),format.raw/*46.18*/(""",

                $BulletNavigatorOptions: """),format.raw/*48.42*/("""{"""),format.raw/*48.43*/("""                          //[Optional] Options to specify and enable navigator or not
                    $Class: $JssorBulletNavigator$,                 //[Required] Class to create navigator instance
                    $ChanceToShow: 2,                               //[Required] 0 Never, 1 Mouse Over, 2 Always
                    $AutoCenter: 1,                                 //[Optional] Auto center navigator in parent container, 0 None, 1 Horizontal, 2 Vertical, 3 Both, default value is 0
                    $Steps: 1,                                      //[Optional] Steps to go for each navigation request, default value is 1
                    $Lanes: 1,                                      //[Optional] Specify lanes to arrange items, default value is 1
                    $SpacingX: 8,                                   //[Optional] Horizontal space between each item in pixel, default value is 0
                    $SpacingY: 8,                                   //[Optional] Vertical space between each item in pixel, default value is 0
                    $Orientation: 1,                                //[Optional] The orientation of the navigator, 1 horizontal, 2 vertical, default value is 1
                    $Scale: false,                                  //Scales bullets navigator or not while slider scale
                """),format.raw/*58.17*/("""}"""),format.raw/*58.18*/(""",

                $ArrowNavigatorOptions: """),format.raw/*60.41*/("""{"""),format.raw/*60.42*/("""                           //[Optional] Options to specify and enable arrow navigator or not
                    $Class: $JssorArrowNavigator$,                  //[Requried] Class to create arrow navigator instance
                    $ChanceToShow: 1,                               //[Required] 0 Never, 1 Mouse Over, 2 Always
                    $AutoCenter: 2,                                 //[Optional] Auto center arrows in parent container, 0 No, 1 Horizontal, 2 Vertical, 3 Both, default value is 0
                    $Steps: 1                                       //[Optional] Steps to go for each navigation request, default value is 1
                """),format.raw/*65.17*/("""}"""),format.raw/*65.18*/("""
            """),format.raw/*66.13*/("""}"""),format.raw/*66.14*/(""";

            var jssor_slider1 = new $JssorSlider$("slider1_container", options);

            //responsive code begin
            //you can remove responsive code if you don't want the slider scales while window resizes
            function ScaleSlider() """),format.raw/*72.36*/("""{"""),format.raw/*72.37*/("""
                var bodyWidth = document.body.clientWidth;
                if (bodyWidth)
                    jssor_slider1.$ScaleWidth(Math.min(bodyWidth, 1920));
                else
                    window.setTimeout(ScaleSlider, 30);
            """),format.raw/*78.13*/("""}"""),format.raw/*78.14*/("""
            ScaleSlider();

            $(window).bind("load", ScaleSlider);
            $(window).bind("resize", ScaleSlider);
            $(window).bind("orientationchange", ScaleSlider);
            //responsive code end
        """),format.raw/*85.9*/("""}"""),format.raw/*85.10*/(""");
    </script>
    <!-- Jssor Slider Begin -->
    <!-- You can move inline styles to css file or css block. -->
    <div id="slider1_container" style="position: relative; margin: 0 auto;
        top: 0px; left: 0px; width: 1300px; height: 500px; overflow: hidden;">
        <!-- Loading Screen -->
        <div u="loading" style="position: absolute; top: 0px; left: 0px;">
            <div style="filter: alpha(opacity=70); opacity: 0.7; position: absolute; display: block;
                top: 0px; left: 0px; width: 100%; height: 100%;">
            </div>
            <div style="position: absolute; display: block; background: url(img/loading.gif) no-repeat center center;
                top: 0px; left: 0px; width: 100%; height: 100%;">
            </div>
        </div>
        <!-- Slides Container -->
        <div u="slides" style="cursor: move; position: absolute; left: 0px; top: 0px; width: 1300px;
            height: 500px; overflow: hidden;">
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*104.38*/routes/*104.44*/.Assets.at("elan/12.png"))),format.raw/*104.69*/("""" />     
            </div>
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*107.38*/routes/*107.44*/.Assets.at("elan/5.png"))),format.raw/*107.68*/(""""/>
               
            </div>
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*111.38*/routes/*111.44*/.Assets.at("elan/24.png"))),format.raw/*111.69*/(""""/>     
            </div>
            
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*115.38*/routes/*115.44*/.Assets.at("elan/15.png"))),format.raw/*115.69*/("""" />     
            </div>
            
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*119.38*/routes/*119.44*/.Assets.at("elan/13.png"))),format.raw/*119.69*/("""" />     
            </div>
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*122.38*/routes/*122.44*/.Assets.at("elan/2.png"))),format.raw/*122.68*/("""" />
               
            </div>
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*126.38*/routes/*126.44*/.Assets.at("elan/11.png"))),format.raw/*126.69*/(""""/>     
            </div>
            
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*130.38*/routes/*130.44*/.Assets.at("elan/22.png"))),format.raw/*130.69*/("""" />     
            </div>
            
            
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*135.38*/routes/*135.44*/.Assets.at("elan/7.png"))),format.raw/*135.68*/(""""/>
               
            </div>
              
            <div>
                <img u="image" src=""""),_display_(Seq[Any](/*140.38*/routes/*140.44*/.Assets.at("elan/1.png"))),format.raw/*140.68*/("""" />
               
            </div>
             
        </div>
                
        <!-- Bullet Navigator Skin Begin -->
        <style>
            /* jssor slider bullet navigator skin 21 css */
            /*
            .jssorb21 div           (normal)
            .jssorb21 div:hover     (normal mouseover)
            .jssorb21 .av           (active)
            .jssorb21 .av:hover     (active mouseover)
            .jssorb21 .dn           (mousedown)
            */
            .jssorb21 div, .jssorb21 div:hover, .jssorb21 .av
            """),format.raw/*157.13*/("""{"""),format.raw/*157.14*/("""
                background: url("""),_display_(Seq[Any](/*158.34*/routes/*158.40*/.Assets.at("images/testSlider/b05.png"))),format.raw/*158.79*/(""") no-repeat;
                overflow:hidden;
                cursor: pointer;
            """),format.raw/*161.13*/("""}"""),format.raw/*161.14*/("""
            .jssorb21 div """),format.raw/*162.27*/("""{"""),format.raw/*162.28*/(""" background-position: -5px -5px; """),format.raw/*162.61*/("""}"""),format.raw/*162.62*/("""
            .jssorb21 div:hover, .jssorb21 .av:hover """),format.raw/*163.54*/("""{"""),format.raw/*163.55*/(""" background-position: -35px -5px; """),format.raw/*163.89*/("""}"""),format.raw/*163.90*/("""
            .jssorb21 .av """),format.raw/*164.27*/("""{"""),format.raw/*164.28*/(""" background-position: -65px -5px; """),format.raw/*164.62*/("""}"""),format.raw/*164.63*/("""
            .jssorb21 .dn, .jssorb21 .dn:hover """),format.raw/*165.48*/("""{"""),format.raw/*165.49*/(""" background-position: -95px -5px; """),format.raw/*165.83*/("""}"""),format.raw/*165.84*/("""
        </style>
        <!-- bullet navigator container -->
        <div u="navigator" class="jssorb21" style="position: absolute; bottom: 26px; left: 6px;">
            <!-- bullet navigator item prototype -->
            <div u="prototype" style="POSITION: absolute; WIDTH: 19px; HEIGHT: 19px; text-align:center; line-height:19px; color:White; font-size:12px;"></div>
        </div>
        <!-- Bullet Navigator Skin End -->

        <!-- Arrow Navigator Skin Begin -->
        <style>
            /* jssor slider arrow navigator skin 21 css */
            /*
            .jssora21l              (normal)
            .jssora21r              (normal)
            .jssora21l:hover        (normal mouseover)
            .jssora21r:hover        (normal mouseover)
            .jssora21ldn            (mousedown)
            .jssora21rdn            (mousedown)
            */
            .jssora21l, .jssora21r, .jssora21ldn, .jssora21rdn
            """),format.raw/*186.13*/("""{"""),format.raw/*186.14*/("""
            	position: absolute;
            	cursor: pointer;
            	display: block;
                background: url("""),_display_(Seq[Any](/*190.34*/routes/*190.40*/.Assets.at("images/testSlider/a12.png"))),format.raw/*190.79*/(""")center center no-repeat;
                overflow: hidden;
            """),format.raw/*192.13*/("""}"""),format.raw/*192.14*/("""
            .jssora21l """),format.raw/*193.24*/("""{"""),format.raw/*193.25*/(""" background-position: -3px -33px; """),format.raw/*193.59*/("""}"""),format.raw/*193.60*/("""
            .jssora21r """),format.raw/*194.24*/("""{"""),format.raw/*194.25*/(""" background-position: -63px -33px; """),format.raw/*194.60*/("""}"""),format.raw/*194.61*/("""
            .jssora21l:hover """),format.raw/*195.30*/("""{"""),format.raw/*195.31*/(""" background-position: -123px -33px; """),format.raw/*195.67*/("""}"""),format.raw/*195.68*/("""
            .jssora21r:hover """),format.raw/*196.30*/("""{"""),format.raw/*196.31*/(""" background-position: -183px -33px; """),format.raw/*196.67*/("""}"""),format.raw/*196.68*/("""
            .jssora21ldn """),format.raw/*197.26*/("""{"""),format.raw/*197.27*/(""" background-position: -243px -33px; """),format.raw/*197.63*/("""}"""),format.raw/*197.64*/("""
            .jssora21rdn """),format.raw/*198.26*/("""{"""),format.raw/*198.27*/(""" background-position: -303px -33px; """),format.raw/*198.63*/("""}"""),format.raw/*198.64*/("""
        </style>
        <!-- Arrow Left -->
        <span u="arrowleft" class="jssora21l" style="width: 55px; height: 55px; top: 123px; left: 8px;">
        </span>
        <!-- Arrow Right -->
        <span u="arrowright" class="jssora21r" style="width: 55px; height: 55px; top: 123px; right: 8px">
        </span>
        <!-- Arrow Navigator Skin End -->
        <a style="display: none" href="http://www.jssor.com">bootstrap slider</a>
    </div>
    <!-- Jssor Slider End -->"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Dec 22 18:39:26 EST 2014
                    SOURCE: /home/sowmya/git/ElanIndulgence/app/views/homeslide.scala.html
                    HASH: 2775bd205279046663fc3820d4c3eeaa0cb4b8e6
                    MATRIX: 859->0|931->37|945->43|1018->95|1236->278|1250->284|1312->325|1400->378|1414->384|1483->432|1579->501|1607->502|1718->585|1747->586|1809->620|1838->621|1904->658|1934->659|1977->673|2007->674|2076->715|2105->716|2168->751|2197->752|2263->789|2293->790|2336->804|2366->805|2435->846|2464->847|2526->881|2555->882|2620->918|2650->919|2693->933|2723->934|2792->975|2821->976|2884->1011|2913->1012|2978->1048|3008->1049|3051->1063|3081->1064|3155->1110|3184->1111|3249->1148|3278->1149|3379->1221|3409->1222|3452->1236|3482->1237|3556->1283|3585->1284|3662->1333|3691->1334|3828->1442|3858->1443|3910->1466|3940->1467|3982->1480|4012->1481|4042->1482|4072->1483|4145->1528|4174->1529|4250->1577|4279->1578|4415->1685|4445->1686|4497->1709|4527->1710|4569->1723|4599->1724|4629->1725|4659->1726|4734->1773|4763->1774|4859->1841|4889->1842|5096->2020|5126->2021|5178->2044|5208->2045|5250->2058|5280->2059|5310->2060|5340->2061|5415->2108|5444->2109|5509->2146|5538->2147|5605->2185|5635->2186|5678->2200|5708->2201|5783->2248|5812->2249|5889->2298|5918->2299|5984->2336|6014->2337|6044->2338|6074->2339|6149->2386|6178->2387|6255->2436|6284->2437|6350->2474|6380->2475|6410->2476|6440->2477|6497->2506|6526->2507|9919->5872|9948->5873|10860->6757|10889->6758|10961->6802|10990->6803|12376->8161|12405->8162|12476->8205|12505->8206|13198->8871|13227->8872|13268->8885|13297->8886|13583->9144|13612->9145|13894->9399|13923->9400|14183->9633|14212->9634|15266->10651|15282->10657|15330->10682|15451->10766|15467->10772|15514->10796|15645->10890|15661->10896|15709->10921|15842->11017|15858->11023|15906->11048|16040->11145|16056->11151|16104->11176|16225->11260|16241->11266|16288->11290|16420->11385|16436->11391|16484->11416|16617->11512|16633->11518|16681->11543|16828->11653|16844->11659|16891->11683|17037->11792|17053->11798|17100->11822|17688->12381|17718->12382|17789->12416|17805->12422|17867->12461|17987->12552|18017->12553|18073->12580|18103->12581|18165->12614|18195->12615|18278->12669|18308->12670|18371->12704|18401->12705|18457->12732|18487->12733|18550->12767|18580->12768|18657->12816|18687->12817|18750->12851|18780->12852|19760->13803|19790->13804|19953->13930|19969->13936|20031->13975|20132->14047|20162->14048|20215->14072|20245->14073|20308->14107|20338->14108|20391->14132|20421->14133|20485->14168|20515->14169|20574->14199|20604->14200|20669->14236|20699->14237|20758->14267|20788->14268|20853->14304|20883->14305|20938->14331|20968->14332|21033->14368|21063->14369|21118->14395|21148->14396|21213->14432|21243->14433
                    LINES: 29->1|29->1|29->1|29->1|32->4|32->4|32->4|33->5|33->5|33->5|35->7|35->7|38->10|38->10|38->10|38->10|38->10|38->10|38->10|38->10|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|40->12|40->12|40->12|41->13|41->13|41->13|41->13|41->13|41->13|41->13|41->13|42->14|42->14|42->14|42->14|42->14|42->14|42->14|42->14|43->15|43->15|43->15|43->15|43->15|43->15|43->15|43->15|43->15|43->15|43->15|43->15|44->16|44->16|44->16|44->16|44->16|44->16|44->16|44->16|44->16|44->16|44->16|44->16|45->17|45->17|45->17|45->17|45->17|45->17|45->17|45->17|45->17|45->17|45->17|45->17|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|50->22|50->22|69->41|69->41|74->46|74->46|76->48|76->48|86->58|86->58|88->60|88->60|93->65|93->65|94->66|94->66|100->72|100->72|106->78|106->78|113->85|113->85|132->104|132->104|132->104|135->107|135->107|135->107|139->111|139->111|139->111|143->115|143->115|143->115|147->119|147->119|147->119|150->122|150->122|150->122|154->126|154->126|154->126|158->130|158->130|158->130|163->135|163->135|163->135|168->140|168->140|168->140|185->157|185->157|186->158|186->158|186->158|189->161|189->161|190->162|190->162|190->162|190->162|191->163|191->163|191->163|191->163|192->164|192->164|192->164|192->164|193->165|193->165|193->165|193->165|214->186|214->186|218->190|218->190|218->190|220->192|220->192|221->193|221->193|221->193|221->193|222->194|222->194|222->194|222->194|223->195|223->195|223->195|223->195|224->196|224->196|224->196|224->196|225->197|225->197|225->197|225->197|226->198|226->198|226->198|226->198
                    -- GENERATED --
                */
            