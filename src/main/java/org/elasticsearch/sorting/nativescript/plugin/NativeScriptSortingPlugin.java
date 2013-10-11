package main.java.org.elasticsearch.sorting.nativescript.plugin;

import main.java.org.elasticsearch.sorting.nativescript.script.GlobalSortScript;
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
    module.registerScript("globalSort", GlobalSortScript.class);
  }
}
