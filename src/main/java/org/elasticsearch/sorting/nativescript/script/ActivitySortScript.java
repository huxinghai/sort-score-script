package main.java.org.elasticsearch.sorting.nativescript.script;

import org.elasticsearch.ElasticSearchIllegalArgumentException;
import org.elasticsearch.common.Nullable;
import org.elasticsearch.common.xcontent.support.XContentMapValues;
import org.elasticsearch.script.AbstractDoubleSearchScript;
import org.elasticsearch.script.AbstractFloatSearchScript;
import org.elasticsearch.script.AbstractLongSearchScript;
import org.elasticsearch.script.ExecutableScript;
import org.elasticsearch.script.NativeScriptFactory;
import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.Loggers;
import org.elasticsearch.script.AbstractSearchScript;
import org.elasticsearch.index.fielddata.ScriptDocValues;

import main.java.org.elasticsearch.sorting.nativescript.script.BaseModule;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;


public class ActivitySortScript implements NativeScriptFactory {
	
	private final ESLogger logger = Loggers.getLogger(ActivitySortScript.class);
	
	@Override
	public ExecutableScript newScript(@Nullable Map<String, Object> params) {				
		return new SortScript();
	}

	private static class SortScript extends AbstractDoubleSearchScript {	
		
		private final ESLogger log = Loggers.getLogger(SortScript.class);
		
		private final long one_hour = 3600000;
		private final Date to_day = new Date();
		private final long like = 5;
		private final long participate = 100;		

		public SortScript() {			
		}

		
		public double runAsDouble() {
			long _like = Long.parseLong(getFieldValue("like"));
			long _particpate = Long.parseLong(getFieldValue("participate"));
			long state = Long.parseLong(getFieldValue("status"));
			long total = (_like * like) + (_particpate * participate) + state;
			Date start_time = BaseSort.parse_date(getFieldValue("start_time"));
			Date end_time = BaseSort.parse_date(getFieldValue("end_time"));		
										
			if (start_time.after(to_day)) {
				return total
						/ ((start_time.getTime() - to_day.getTime()) / one_hour);
			} else if (start_time.before(to_day) && end_time.before(to_day)) {
				return total
						/ ((to_day.getTime() - end_time.getTime()) / one_hour);
			} else {
				return total
						/ ((to_day.getTime() - start_time.getTime()) / one_hour);
			}						
		}
		
		private String getFieldValue(String field){
			return source().get(field).toString();
		}
		
	}

}