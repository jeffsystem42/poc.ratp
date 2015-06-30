package fr.ratp.phoebus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONObject;
import org.sonatype.aether.impl.internal.Slf4jLogger;
import org.springframework.jdbc.core.namedparam.ParsedSql;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.jsonpath.JsonPath;

import fr.ratp.phoebus.beanMetier.ContextMatriculeItem;
import fr.ratp.phoebus.beanMetier.PrimeT;

public class TestJson {

	static Map<String, String> flatmap = new HashMap<String, String>();
	static Gson gson=new Gson();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PrimeT primeT = new PrimeT();
		primeT.setMontant(145);
		primeT.setTaux(16.5);
		primeT.setType("C");

		ContextMatriculeItem context = new ContextMatriculeItem();
		context.setCompteurA(new BigDecimal("10.444"));
		context.setPrime1(1);
		context.setPrime2(334);
		context.setPrime3(12);
		context.setPrimeT(primeT);

		// Gson gson = new GsonBuilder().setPrettyPrinting().create();

		Gson gson = new Gson();
		String json = gson.toJson(context);
		System.out.println(json);
		
		parse(json);
		System.out.println(flatmap.get("primeT.taux"));
		System.out.println(flatmap.get("prime1"));

		Object jsonpath = JsonPath.read(json,"primeT.type");
		
		System.out.println(jsonpath.toString());
	
	}

	public static Map<String, String> parse(String value) {
		iterableCrawl("", null, (gson.fromJson(value, flatmap.getClass())).entrySet());
		return flatmap;
	}

	private static <T> void iterableCrawl(String prefix, String suffix, Iterable<T> iterable) {
		int key = 0;
		for (T t : iterable) {
			if (suffix != null)
				crawl(t, prefix + (key++) + suffix);
			else
				crawl(((Entry<String, Object>) t).getValue(), prefix + ((Entry<String, Object>) t).getKey());
		}
	}

	private static void crawl(Object object, String key) {
		if (object instanceof ArrayList)
			iterableCrawl(key + "[", "]", (ArrayList<Object>) object);
		else if (object instanceof Map)
			iterableCrawl(key + ".", null, ((Map<String, Object>) object).entrySet());
		else
			flatmap.put(key, object.toString());
	}

}
