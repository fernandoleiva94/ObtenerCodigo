package com.init.activacion.programa;

import java.text.DecimalFormat;

public class CryptUtils {
	
	public static double encrypt1(double value) {
	    if (value < 0.0D) {
	       value *= -1.0D;
		    }
		    return value * 3.0D;
		 }
		 
		   public  double encrypt2(double value) {
		   if (value < 0.0D) {
		   value *= -1.0D;
		   }
	    return value * 4.0D;

		  }
		
		   public static double encrypt3(double value) {
		   if (value < 0.0D) {
	      value *= -1.0D;
	   }
		     return value * 5.0D;
		   }
		  
	  public static double decrypt1(double value) {
		     if (value < 0.0D) {
	      value *= -1.0D;
		    }
		    return value / 3.0D;
	   }
		  
		   public static double decrypt2(double value) {
		    if (value < 0.0D) {
		      value *= -1.0D;
		    }
		     return value / 4.0D;
		   }
		   
		   public static double decrypt3(double value) {
	     if (value < 0.0D) {
	     value *= -1.0D;
	    }
	    return value / 5.0D;
	  }
		 
		  public  String obfuscateKey(String key) {
		     String newKey = "";
		   
	   int middle = key.length() / 2;
		    
		     String part1 = key.substring(0, middle);
		     String part2 = key.substring(middle, key.length());
		
		     
		     int j = 0;
		     for (int i = 0; i < key.length(); i++) {
		       if (i % 2 == 0) {
		        newKey = String.valueOf(newKey) + part1.substring(j, j + 1);
		       } else {
		         newKey = String.valueOf(newKey) + part2.substring(j, j + 1);
		         j++;
		      } 
		     } 
		     return newKey;
		  }
	  
		   public  String deobfuscateKey(String key) {
		    String newKey = "";
		     
		    int i;
		/*  82 */     for (i = 0; i < key.length(); i++) {
		/*  83 */       if (i % 2 == 0) {
		/*  84 */         newKey = String.valueOf(newKey) + key.substring(i, i + 1);
		/*     */       }
		/*     */     } 
		/*  87 */     for (i = 0; i < key.length(); i++) {
		/*  88 */       if (i % 2 != 0) {
		/*  89 */         newKey = String.valueOf(newKey) + key.substring(i, i + 1);
		/*     */       }
		/*     */     } 
		/*     */     
		/*  93 */     return newKey;
		/*     */   }
		/*     */ 
		/*     */ 
		/*     */   
		/*     */   public String formatKey(String key) {
		/*  99 */     String fCode = "";
		/*     */ 
		/*     */     
		/* 102 */     while (key.length() % 4 != 0) {
		/* 103 */       key = "0" + key;
		/*     */     }
		/*     */ 
		/*     */     
		/* 107 */     int idx = 0;
		/* 108 */     while (idx + 4 <= key.length()) {
		/* 109 */       fCode = String.valueOf(fCode) + key.substring(idx, idx + 4);
		/* 110 */       fCode = String.valueOf(fCode) + "-";
		/* 111 */       idx += 4;
		/*     */     } 
		/*     */ 
		/*     */     
		/* 115 */     fCode = fCode.substring(0, fCode.length() - 1);
		/*     */     
		/* 117 */     return fCode;
		/*     */   }
		/*     */ 
		/*     */ 
		/*     */ 
		/*     */   
		/*     */   public static String unformatKey(String key) {
		/* 124 */     String newKey = key.replaceAll("-", "");
		/*     */ 
		/*     */     
		/* 127 */     while (newKey.startsWith("0")) {
		/* 128 */       newKey = newKey.substring(1, newKey.length());
		/*     */     }
		/*     */     
		/* 131 */     return newKey;
		/*     */   }
		/*     */ 
		/*     */   
		/*     */   public static String generateCodFacturaElectronica(double serialNumber) {
		/* 136 */     String codFacturaElectronica = "";
		/*     */ 
		/*     */     
		/*     */     try {
		/* 140 */       DecimalFormat df = new DecimalFormat("#");
		/*     */       
		/* 142 */       serialNumber = serialNumber * 3.0D + 129900.0D;
		/*     */       
		/* 144 */       String serialStr = df.format(serialNumber);
		/*     */       
		/* 146 */       codFacturaElectronica = serialStr.substring(serialStr.length() - 6, serialStr.length());
		/*     */     }
		/* 148 */     catch (Exception e) {		     
		/* 150 */       codFacturaElectronica = "129900";
		/*     */     } 
		/*     */ 
		/*     */     
		/* 154 */     return codFacturaElectronica;
		/*     */   }

}
