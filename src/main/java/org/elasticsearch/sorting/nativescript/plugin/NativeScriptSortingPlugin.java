package main.java.org.elasticsearch.sorting.nativescript.plugin;

import main.java.org.elasticsearch.sorting.nativescript.script.ActivitySortScript;
import main.java.org.elasticsearch.sorting.nativescript.script.AskBuySortScript;
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
    module.registerScript("productSort", ProductSortScript.class);
    module.registerScript("activitySort", ActivitySortScript.class);
    module.registerScript("askbuySort", AskBuySortScript.class);
    module.registerScript("shopProductSort", ShopProductSortScript.class);
  }
}
