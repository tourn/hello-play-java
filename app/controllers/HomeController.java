package controllers;

import models.BakedGoods;
import play.*;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import play.db.*;

import views.html.*;

import javax.inject.Inject;
import java.sql.Connection;
import java.util.List;

import static play.libs.Json.toJson;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {


    @Inject
    FormFactory formFactory;

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {

        return ok(index.render("Your new application is ready.", BakedGoods.find.all()));
    }

    public Result addGoods(){
        Form<BakedGoods> goodsForm = formFactory.form(BakedGoods.class);
        BakedGoods good = goodsForm.bindFromRequest().get();
        BakedGoods.create(good);
        return ok(index.render("Your new application is ready.", BakedGoods.find.all()));
    }

    public Result getBakedGoods() {
        List<BakedGoods> goods = BakedGoods.find.all();
        return ok(toJson(goods));
    }

}
