package com.example.spring_demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class LuckyYouController {
    private List<String> animals = new ArrayList<>(){
        {
            add("Rabbit");
            add("Snail");
            add("Spider");
            add("Dog");
            add("Squirrel");
            add("Turtle");
            add("Hedgehog");
            add("Lama");
            add("Bug");
            add("Lizard");
        }
    };

    public int randomNumber(){
        Random random = new Random();
        return random.nextInt(10 - 1 + 1) + 1;
    }

    public String getALuckyAnimal(){
        return animals.get(randomNumber() - 1);
    }

    @RequestMapping("/luckyYou")
    public String returnLucky(@RequestParam String type){
        if(type.equals("number")){
            return "Your lucky number is " + randomNumber();
        } else if(type.equals("animal")){
            return "Your lucky animal is " + getALuckyAnimal();
        } else {
            return "Error due to unknown type";
        }
    }

    @RequestMapping("/luckyYouWithName")
    public String returnLuckyWithName(@RequestParam String type,
                               @RequestParam(required = false) String firstname,
                               @RequestParam(required = false) String lastname) {
        String name = "";
        if(firstname != null){
            name = firstname;
        }
        if(lastname != null){
            if(name.length() == 0){
                name = lastname;
            } else {
                name = name + " " + lastname;
            }
        }
        if(type.equals("animal")){
            if(!name.isEmpty()){
                return name + ", your lucky animal is " + getALuckyAnimal();
            } else{
                return "Your lucky animal is " + getALuckyAnimal();
            }
        } else if(type.equals("number")){
            if(!name.isEmpty()){
                return name + ", your lucky number is " + randomNumber();
            } else{
                return "Your lucky number is " + randomNumber();
            }
        } else{
            return "Error due to unknown type";
        }

    }


    @RequestMapping("/luckyYouWithDefault")
    public String returnLuckyDef(@RequestParam(defaultValue = "animal") String type,
                                  @RequestParam(defaultValue = "Din gamle galosch") String fullname) {


        if(type.equals("animal")){
            return fullname + ", your lucky animal is " + getALuckyAnimal();
        } else if(type.equals("number")){
                return fullname + ", your lucky number is " + randomNumber();
        } else{
            return "Error due to unknown type";
        }
    }

    @RequestMapping("/listUnlucky")
    public String onlyLuckyNumbers(@RequestParam List<String> unlucky){
        boolean numberFits = false;
        int number = 0;
        while (!numberFits){
            number = randomNumber();
            numberFits = checkIfNumberIsUnlucky(unlucky, number);
        }
        return "Your lucky number is " + number;
    }

    @RequestMapping( "/getLuckyList")
    public String luckyList(@RequestParam List<String> unlucky){
        List<String> lucky = new ArrayList<>();
        boolean numberFits = true;
        for (int i = 1; i <= 10; i++) {
            for (String s: unlucky) {
                if(s.equals(String.valueOf(i))){
                    numberFits = false;
                }
            }
            if(numberFits){
                lucky.add(String.valueOf(i));
            }
            numberFits = true;
        }

        return lucky.toString();
    }

    public boolean checkIfNumberIsUnlucky(List<String> list, int number){
        for (String unluckyNumb: list) {
            if(unluckyNumb.equals(String.valueOf(number))){
                return false;
            }
        }
        return true;
    }

    @RequestMapping("/luckyYouPath/{type}")
    public String returnLuckyUsingPath(@PathVariable String type){
        if(type.equals("number")){
            return "Your lucky number is " + randomNumber();
        } else if(type.equals("animal")){
            return "Your lucky animal is " + getALuckyAnimal();
        } else {
            return "Error due to unknown type";
        }
    }

    @RequestMapping("/luckyYouPHTML")
    public String returnLuckyUsingHTML(@PathVariable String type){
        if(type.equals("number")){
            return "<H1>Your lucky number is " + randomNumber() + "</h1>";
        } else if(type.equals("animal")){
            return "Your lucky animal is " + getALuckyAnimal();
        } else {
            return "Error due to unknown type";
        }
    }


}
