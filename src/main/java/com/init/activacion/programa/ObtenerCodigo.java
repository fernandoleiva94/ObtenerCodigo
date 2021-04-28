package com.init.activacion.programa;

import com.init.activacion.programa.CryptUtils;
import java.text.DecimalFormat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ObtenerCodigo")
public class ObtenerCodigo {
	@RequestMapping(value= "{codActivacion}")
	public ResponseEntity<String> getCodActivacion(@PathVariable("codActivacion") long codActivacion) {
		
		DecimalFormat df = new DecimalFormat("#");		
		CryptUtils c = new CryptUtils();
		String codigo = df.format(c.encrypt2(codActivacion));           
		System.out.println("Codigo1 " + codigo);
		String parte2 = df.format(c.encrypt2(Double.parseDouble("4071005999"))); 
		System.out.println("Codigo2 " + parte2);
		   
		String union = "00" + codigo +"0"+ parte2;
		System.out.println("union " + union);   
		
		 
		String key = c.obfuscateKey(union);
		String key1 = c.formatKey(key);
		System.out.println("Clave " + key1); 
			
		return ResponseEntity.ok(key1);
		
	}
	
}
