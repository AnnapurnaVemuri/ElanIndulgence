package controllers;

import play.*;
import play.mvc.*;
import utils.ImageLoader;
import views.html.*;

public class Application extends Controller {

    public static Result loadMain() {
        return ok(main.render("ElanIndulgence"));
    }

}
