package main.java.org.elasticsearch.sorting.nativescript.script;

import java.util.Date;
import java.util.Map;

import main.java.org.elasticsearch.sorting.nativescript.script.ActivitySortScript.SortScript;

import org.elasticsearch.common.Nullable;
import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.Loggers;
import org.elasticsearch.script.AbstractDoubleSearchScript;
import org.elasticsearch.script.ExecutableScript;
import org.elasticsearch.script.NativeScriptFactory;

public class AskBuySortScript implements NativeScriptFactory {

	@Override
	public ExecutableScript newScript(@Nullable Map<String, Object> params) {
		return new SortScript();
	}

	private static class SortScript extends AbstractDoubleSearchScript {
		
		//private final ESLogger logger = Loggers.getLogger(SortScript.class);	
		
		public SortScript() {
		}

		public double runAsDouble() {
			
			Date c = BaseModule.parse_date(source().get("created_at")
					.toString());			
			double t = (((new Date()).getTime() - c.getTime()) / (double) 3600000);
			double gravity = ((Boolean) source().get("open")) ? 1 : 5;
			
			return ((double) 10 / (t * gravity));
		}
	}
}
