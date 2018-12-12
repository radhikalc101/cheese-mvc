package org.lanunchcode.cheesemvc.controllers;

import org.lanunchcode.cheesemvc.models.Cheese;
import org.lanunchcode.cheesemvc.models.CheeseData;
import org.lanunchcode.cheesemvc.models.CheeseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "cheese")
public class CheeseController {

    //static ArrayList<Cheese> cheeses = new ArrayList<>();
    //static HashMap<String, String> cheeses = new HashMap<>();

    //request path:/cheese
    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("cheeses",CheeseData.getAll());
        model.addAttribute("title","My Cheeses");
        return "cheese/index";//rendering template
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {

        model.addAttribute("title","Add Cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";//rendering template

    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute  @Valid  Cheese newCheese, Errors errors, Model model) {
//        System.out.println("cheeseName :"+ cheeseName);
//        System.out.println("cheeseDescription :" +cheeseDescription);
//        Cheese cheese = new Cheese(cheeseName,cheeseDescription );
        /*
        * the ModelAttribute (springboot) will create all these useing default constructor
        * instead of using RequestParameters in the method signature simply use one sentence @ModelAttribute
        *
        * Cheese newCheese = new Cheese();
        * newCheese.setName(request.getParameter("name");
        * newCheese.setDescription(Request.getParameter("description");
        *
        *
        * */

        if(errors.hasErrors()){
            model.addAttribute("title", "Add Cheese");
            return "cheese/add";
        }

        CheeseData.add(newCheese);
        return "redirect:";
    }
        //cheeses.add(new Cheese(cheeseName,cheeseDescription ));
        //cheeses.put(cheeseName, cheeseDescription);

        //redirect to /cheese

    @RequestMapping(value = "remove",method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model){
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title","Remove Cheese");
        return "cheese/remove";
    }


    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {

        for (int cheeseId : cheeseIds) {
            CheeseData.remove(cheeseId);
        }
        return "redirect:";
    }



}
