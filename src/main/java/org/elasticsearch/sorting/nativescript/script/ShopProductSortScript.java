package main.java.org.elasticsearch.sorting.nativescript.script;

import java.util.Map;

import org.elasticsearch.common.Nullable;
import org.elasticsearch.script.AbstractDoubleSearchScript;
import org.elasticsearch.script.ExecutableScript;
import org.elasticsearch.script.NativeScriptFactory;

public class ShopProductSortScript implements NativeScriptFactory {
	@Override
	public ExecutableScript newScript(@Nullable Map<String, Object> params) {	
		return new SortScript();
	}

	private static class SortScript extends AbstractDoubleSearchScript {
		
		public SortScript(){
			
		}
		
		public double runAsDouble(){
			return 0.001;
		}
	}
}
