package com.sd.training.swift.tag;

import java.util.Date;



public abstract class AbstractTag{

	/*
	1.2. Symbols that define the format of the message:
===================================================


Type of symbol  	Description								Examples
=============		============							=======================
n					Numerical field							18n – numerical fields up to 18 characters.

!					After a number represents a 
					fixedlength determined by the number    18!n – field of fixed 18 numerical characters

a					Exclusively letters’ field (Caps lock)	4!a –four fixed letter characters

d					Decimal field							15d – numerical field with two decimals 
															up to 15 characters (12n,nn)

x					Letter, numerical, and symbol field		35x – represents up to 35 letters,
							 								numerical and symbol characters

c					Letter numerical field					3x – field that has 3 letters, or 3 numbers

3*35x				First number determines number of lines
		 			and second number of 
		 			characters by line.						3*35x – 3 lines of which each has up to 35 characters

[ ]					Fields in round brackets are 
					optional fields							[1!a] – field which in certain conditions 
															require one character and in other conditions 
															is not filed in

->
----I				Fields among these two symbols may
					be repeated several times
	
	
	
	
	
	
	*/
	protected String tagValue;

	public AbstractTag(String value){
//		In the constructor seperate the value into respective sub values eg "01012007USD2000" it means 01012007 is date , USD is currency and 2000 is amount	
//		In case of Tag20 the value only contains the Unique reference number for the day
		this.tagValue = value;
		splitTagValue();
	}
	
	public AbstractTag(){
		
	}
	
	public String getTagValue() {
		return tagValue;
	}

	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
		splitTagValue();
	}

	protected abstract void splitTagValue();
    protected void validateTagValue(String tagValue , String pattern){
    	
    }
    
    protected String formatDate(Date date){
    	
    	return "";
    }
}
