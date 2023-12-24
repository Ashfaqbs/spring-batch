/**
 * Code developed by Ashfaq (© [Year])
 * GitHub: https://github.com/DarkSharkAsh
 */



package com.main.springboot.batch.config;

import org.springframework.batch.item.ItemProcessor;

import com.main.springboot.batch.model.Product;

public class CustomItemProcessor implements ItemProcessor<Product, Product> {

	@Override
	public Product process(Product item) throws Exception {
		return null;
	}

}
