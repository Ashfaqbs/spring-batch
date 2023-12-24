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

		try {
			int discountPer = Integer.parseInt(item.getDiscount());

			double originalPrice = Double.parseDouble(item.getPrice());

			double discount = (discountPer / 100) * originalPrice;

			double finalPrice = originalPrice - discount;

			item.setDiscount(String.valueOf(finalPrice));
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		

		return item;
	}

}
