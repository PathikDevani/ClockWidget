package com.spidren.database;

public class WidgetColorContent {
	String color1,color2;
	int id;
	public WidgetColorContent(int id ,String color1,String color2)
	{
		this.id = id;
		this.color1 = color1;
		this.color2 = color2;
	}
	
	public void updateColor(String color1,String color2)
	{
		this.color1 = color1;
		this.color2 = color2;
	}
	public int getId()
	{
		return id;
	}
	public String getFirstColor()
	{
		return color1;
	}
	public String getSecondColor()
	{
		return color2;
	}
}
