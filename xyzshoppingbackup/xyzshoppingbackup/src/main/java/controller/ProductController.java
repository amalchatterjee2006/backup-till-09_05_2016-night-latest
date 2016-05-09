package controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import model.Product;
import dao.ProductDaoImpl;
import dao.ProductServiceImpl;

	@Controller
	public class ProductController 
	{
		@Autowired
		private ProductServiceImpl productService1;


/*public void setPersonService(PersonService ps){
    this.personService = ps;
}*/
		@RequestMapping("/")
		public String abc() 
		{
			return "index";
		}

//for registration page
		@RequestMapping("/regis")
		public String abc1() 
		{
			return "registration";
		}

		@RequestMapping("/product")
		public String abc2() 
		{
			return "ProductDetails";
		}


		@RequestMapping(value = "/persons", method = RequestMethod.GET)
		public String ListProductDetails(Model model) 
		{
			model.addAttribute("person", new Product());
			model.addAttribute("listProduct", this.productService1.ListProductDetails());
			return "ProductAdd";
		}
		
       @RequestMapping("/pr")		
		public String ListProductDetails1(Model model) 
		{
			model.addAttribute("person", new Product());
			model.addAttribute("listProduct", this.productService1.ListProductDetails());
			return "ProductDetails";
		}
 
//For add and update person both
		@RequestMapping(value= "/person/add", method = RequestMethod.POST)
		public String AddProductDetails(@ModelAttribute("person") Product p)
		{
     
			if(p.getId() == 0)
			{
        //new person, add it
				this.productService1.AddProductDetails(p);
			}
			else
			{
        //existing person, call update
				this.productService1.UpdateProductDetails(p);
			}
     
				return "redirect:/persons";
     
		}
 
		@RequestMapping("/remove/{id}")
			public String removePerson(@PathVariable("id") int id)
		{
     
			this.productService1.RemoveProductDetails(id);
			return "redirect:/persons";
		}

//@RequestMapping("/edit/{id}")
/*  public String editPerson(@PathVariable("id") int id, Model model){
    model.addAttribute("person", this.personService.getPersonById(id));
    model.addAttribute("listPersons", this.personService.listPersons());
    return "person";
}*/

//for display of productdetails  added

/*		@RequestMapping("productdetails")
		public ModelAndView showProducts()
		{
			ModelAndView mv=new ModelAndView("productdetails");
			List<Product> employeeList=new ArrayList<Product>();
			employeeList=productService1.ListProductDetails();
			mv.addObject("listfromtab",employeeList);
			return mv;
		}*/

}