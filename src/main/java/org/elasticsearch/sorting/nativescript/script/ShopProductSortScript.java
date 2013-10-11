package main.java.org.elasticsearch.sorting.nativescript.script;

import org.elasticsearch.ElasticSearchIllegalArgumentException;
import org.elasticsearch.common.xcontent.support.XContentMapValues;
import org.elasticsearch.index.fielddata.ScriptDocValues;
import org.elasticsearch.index.mapper.internal.UidFieldMapper;
import org.elasticsearch.script.AbstractDoubleSearchScript;
import org.elasticsearch.common.Nullable;
import org.elasticsearch.script.ExecutableScript;
import org.elasticsearch.script.NativeScriptFactory;
import java.util.Map;

public class ShopProductSortScript implements NativeScriptFactory {
	
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
		  @Override
		  public double runAsDouble() {
			  return 0.001;
		  }
	  }
}
