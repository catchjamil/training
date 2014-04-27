/**
 * * * * Created on Feb 08, 2011 by Jamil
 *
 * Copyright (c) 2006 aurionPro Solutions Ltd.
 * Unit no. 404, 4th Floor, Winchester Building Hiranandani Garden ,
 * Powai, Mumbai - 400076.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of 
 * aurionPro Solutions Ltd. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with aurionPro Solutions Ltd.
 */
package com.sd.training.swift.tag;

import java.io.IOException;
   import java.io.Reader;
   import java.util.ArrayList;
   import java.util.HashMap;
   import java.util.Iterator;
   import java.util.List;
   import java.util.Map;
  
  /***
   * Helper class to validated the characters that conform a SWIFT message.
   * SWIFT messages contain a very restrictive character set allowed, this class
   * makes it easier to validate a buffer.
   * 
   * @author mgriffa
   */
  public class MessageValidator {
  	private static final List<Character> allowedCharacters = new ArrayList<Character>();
  	private final Map<Integer,Character> errorInfo = new HashMap<Integer,Character>();
  	
  	static {
  		allowedCharacters.add(Character.valueOf('0'));
  		allowedCharacters.add(Character.valueOf('1'));
  		allowedCharacters.add(Character.valueOf('2'));
  		allowedCharacters.add(Character.valueOf('3'));
  		allowedCharacters.add(Character.valueOf('4'));
  		allowedCharacters.add(Character.valueOf('5'));
  		allowedCharacters.add(Character.valueOf('6'));
  		allowedCharacters.add(Character.valueOf('7'));
  		allowedCharacters.add(Character.valueOf('8'));
  		allowedCharacters.add(Character.valueOf('9'));
  
  		allowedCharacters.add(Character.valueOf('A'));
  		allowedCharacters.add(Character.valueOf('B'));
  		allowedCharacters.add(Character.valueOf('C'));
  		allowedCharacters.add(Character.valueOf('D'));
  		allowedCharacters.add(Character.valueOf('E'));
  		allowedCharacters.add(Character.valueOf('F'));
  		allowedCharacters.add(Character.valueOf('G'));
  		allowedCharacters.add(Character.valueOf('H'));
  		allowedCharacters.add(Character.valueOf('I'));
  		allowedCharacters.add(Character.valueOf('J'));
  		allowedCharacters.add(Character.valueOf('K'));
  		allowedCharacters.add(Character.valueOf('L'));
  		allowedCharacters.add(Character.valueOf('M'));
  		allowedCharacters.add(Character.valueOf('N'));
  		allowedCharacters.add(Character.valueOf('O'));
  		allowedCharacters.add(Character.valueOf('P'));
  		allowedCharacters.add(Character.valueOf('Q'));
  		allowedCharacters.add(Character.valueOf('R'));
  		allowedCharacters.add(Character.valueOf('S'));
  		allowedCharacters.add(Character.valueOf('T'));
  		allowedCharacters.add(Character.valueOf('U'));
  		allowedCharacters.add(Character.valueOf('V'));
  		allowedCharacters.add(Character.valueOf('W'));
  		allowedCharacters.add(Character.valueOf('X'));
  		allowedCharacters.add(Character.valueOf('Y'));
  		allowedCharacters.add(Character.valueOf('Z'));
  
  		allowedCharacters.add(Character.valueOf('/'));
  		allowedCharacters.add(Character.valueOf('-'));
  		allowedCharacters.add(Character.valueOf('?'));
  		allowedCharacters.add(Character.valueOf(':'));
  		allowedCharacters.add(Character.valueOf('('));
  		allowedCharacters.add(Character.valueOf(')'));
  		allowedCharacters.add(Character.valueOf('.'));
  		allowedCharacters.add(Character.valueOf(','));
  		allowedCharacters.add(Character.valueOf('\''));
  		allowedCharacters.add(Character.valueOf('+'));
  		allowedCharacters.add(Character.valueOf('{'));
  		allowedCharacters.add(Character.valueOf('}'));
  		allowedCharacters.add(Character.valueOf('\r'));
  		allowedCharacters.add(Character.valueOf('\n'));
  		allowedCharacters.add(Character.valueOf(' '));		
  	}
  	
  	public MessageValidator() {
  	}
  	
  	/***
  	 * Read all characters from reader and store information about invalid SWIFT characters found.
  	 * NOTE: calling this method resets error information stored in the object.
  	 * 
  	 * @param r reader for the SWIFT stream
 	 * @return thea ammount of invalid SWIFT characters found in the stream
  	 * @throws IOException if an error occurs during read
  	 */
  	public int validateCharacters(Reader r) throws IOException {
  		int c;
  		int curpos = 0;
  		this.errorInfo.clear();
  		while ((c=r.read())!=-1) {
  			System.out.println("c: "+(char)c);
  			Character theChar = Character.valueOf((char)c); 
  			if ( (!allowedCharacters.contains(theChar)) && !allowedCharacters.contains(Character.valueOf((char) Character.toUpperCase(c)))) {
  				// Add error info
  				errorInfo.put(Integer.valueOf(curpos), Character.valueOf((char)c));
  			}
 			curpos++;
 		}
 		return errorInfo.size();
 	}
 
 	/***
 	 * Gets a hashmap with errors information.
 	 * The hashmap contains an Integer as key, that specifies the position (zero based) on 
 	 * the buffer readed and the invalid SWIFT character as the value.
 	 * NOTE: the errors map is reseted on each call to validateCharacteres()
 	 * 
 	 * @return a map with error information of last validation or an empty map if no errors occured
 	 * */
 	public Map getErrorMap() {
 		return this.errorInfo;
 	}
 
 	/***
 	 * Gets a string to present to user with information about invalid characters.
 	 * This methods returns a language-neutral string.
 	 * 
 	 * @return a string with the form of char (position)[, char (position)]+ or an empty string if no errors happened in last validation
 	 */
 	public String getErrorString() {
 		StringBuffer sb = new StringBuffer();
 		
 		for (Iterator it = errorInfo.keySet().iterator() ; it.hasNext() ; ) {
 			Integer pos = (Integer) it.next();
 			Character c = (Character) errorInfo.get(pos);
 			
 			sb.append(c);
 			sb.append(" (");
 			sb.append(pos);
 			sb.append(")");
 			if (it.hasNext()) {
				sb.append(", ");
 			}
 		}
 		return sb.toString();
 	}
 }
