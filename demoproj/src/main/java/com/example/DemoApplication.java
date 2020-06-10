package com.example;
import com.blade.Blade;
public class DemoApplication {

	public static void main(String[] args) {
         Blade.of().get("/home", ctx -> ctx.text("Home Page")).start(DemoApplication.class,args);
	}

}
