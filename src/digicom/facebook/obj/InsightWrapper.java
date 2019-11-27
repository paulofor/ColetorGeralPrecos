package digicom.facebook.obj;

import java.util.List;

import com.restfb.Connection;
import com.restfb.json.JsonObject;
import com.restfb.types.Insight;

public class InsightWrapper {

	private Connection<Insight> item = null;
	
	public void setItem(Connection<Insight> valor) {
		item = valor;
	}
	
	public long qtdeImpressaoUnica() {
		for (Insight ideia : item.getData()) {
			if ("post_impressions_unique".equals(ideia.getName())) {
				List<JsonObject> texto = ideia.getValues();
				
			}
		}
		return 0;
			
	}
}
