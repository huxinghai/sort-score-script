package main.java.org.elasticsearch.sorting.nativescript.plugin;

import main.java.org.elasticsearch.sorting.nativescript.script.AskBuySortScript;
import main.java.org.elasticsearch.sorting.nativescript.script.ActivitySortScript;
import main.java.org.elasticsearch.sorting.nativescript.script.ProductSortScript;
import main.java.org.elasticsearch.sorting.nativescript.script.ShopProductSortScript;
import org.elasticsearch.plugins.AbstractPlugin;
import org.elasticsearch.script.ScriptModule;

public class NativeScriptSortingPlugin extends AbstractPlugin{
  @Override
  public String name() {
    return "sort-score-script";
  }

  @Override
  public String description() {
    return "global sorting score native script";
  }

  public void onModule(ScriptModule module) {
    module.registerScript("activitysort", ActivitySortScript.class);
    module.registerScript("askbuysort", AskBuySortScript.class);
    module.registerScript("productsort", ProductSortScript.class);
    module.registerScript("shopproductsort", ShopProductSortScript.class);
  }
}
