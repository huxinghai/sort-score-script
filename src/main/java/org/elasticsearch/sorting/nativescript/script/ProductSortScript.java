package main.java.org.elasticsearch.sorting.nativescript.script;

import java.util.Date;
import java.util.Map;

import org.elasticsearch.common.Nullable;
import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.Loggers;
import org.elasticsearch.index.engine.Engine.Create;
import org.elasticsearch.script.AbstractDoubleSearchScript;
import org.elasticsearch.script.ExecutableScript;
import org.elasticsearch.script.NativeScriptFactory;

public class ProductSortScript implements NativeScriptFactory {

	@Override
	public ExecutableScript newScript(@Nullable Map<String, Object> params) {
		return new SortScript();
	}

	private static class SortScript extends AbstractDoubleSearchScript {
		
		private final ESLogger logger = Loggers.getLogger(SortScript.class);	
		
		public SortScript() {
		}

		public double runAsDouble() {
			Object create = source().get("created_at");
			
			double score = 0;
			if(create != null){
				Date c = BaseModule.parse_date(create.toString());				
				double t = (((new Date()).getTime() - c.getTime()) / (double) 3600000);
				score = 5 / t;				
			}
			
			return 0.0001 + score;
		}

	}

}