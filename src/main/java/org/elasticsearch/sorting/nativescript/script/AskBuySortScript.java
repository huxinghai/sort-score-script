package main.java.org.elasticsearch.sorting.nativescript.script;


import java.util.Date;
import java.util.Map;

import org.elasticsearch.common.Nullable;
import org.elasticsearch.index.fielddata.ScriptDocValues;
import org.elasticsearch.script.AbstractDoubleSearchScript;
import org.elasticsearch.script.ExecutableScript;
import org.elasticsearch.script.NativeScriptFactory;

import main.java.org.elasticsearch.sorting.nativescript.script.BaseModule;


public class AskBuySortScript implements NativeScriptFactory {

	  /**
	   * This method is called for every search on every shard.
	   *
	   * @param params list of script parameters passed with the query
	   * @return new native script
	   */
	  @Override
	  public ExecutableScript newScript(@Nullable Map<String, Object> params) {
	    return new SortScript();
	  }
	  
	  private static class SortScript extends AbstractDoubleSearchScript {
		  private long one_hour = 3600000;
		  
		  private SortScript(){			  
		  }
		  
		  @Override
		  public double runAsDouble() {			  
			  Date c = BaseSort.parse_date(source().get("end_time").toString());
			  
			  return 10/(((new Date().getTime()) - c.getTime())/one_hour);
		  }
	  }
}
