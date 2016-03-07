package models;
/**
 * Created by mario on 07.03.16.
 */

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class BakedGoods extends Model {
    @Id
    public Long id;

    @Constraints.Required
    public String title;

    public String time_to_bake;

    public static void create(BakedGoods good){
        good.save();
    }

    public static Finder<Long, BakedGoods> find = new Finder<Long,BakedGoods>(BakedGoods.class);

}
