package com.example.bfhl.controller;

import com.example.bfhl.dto.ApiRequest;
import com.example.bfhl.dto.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/bfhl")
public class ApiController {

    @PostMapping
    public ApiResponse processData(@RequestBody ApiRequest request) {
        List<String> data = request.getData();
        List<String> even = new ArrayList<>();
        List<String> odd = new ArrayList<>();
        List<String> alpha = new ArrayList<>();
        List<String> special = new ArrayList<>();
        List<Character> charList = new ArrayList<>();

        int sum = 0;

        for (String val : data) {
            try {
                int num = Integer.parseInt(val);
                sum += num;
                if (num % 2 == 0) even.add(val);
                else odd.add(val);
            } catch (NumberFormatException e) {
                if (val.matches("[a-zA-Z]+")) {
                    alpha.add(val.toUpperCase());
                    for (char c : val.toCharArray()) {
                        if (Character.isLetter(c)) {
                            charList.add(c);
                        }
                    }
                } else {
                    special.add(val);
                }
            }
        }

        Collections.reverse(charList);
        StringBuilder concatStr = new StringBuilder();
        boolean upper = true;
        for (char c : charList) {
            concatStr.append(upper ? Character.toUpperCase(c) : Character.toLowerCase(c));
            upper = !upper;
        }

        ApiResponse response = new ApiResponse();
        response.setIs_success(true);
        response.setUser_id("abhishek_choudhary_07032005");
        response.setEmail("abhishek1161.be22@chitkara.edu.in");
        response.setRoll_number("2210991161");
        response.setEven_numbers(even);
        response.setOdd_numbers(odd);
        response.setAlphabets(alpha);
        response.setSpecial_characters(special);
        response.setSum(String.valueOf(sum));
        response.setConcat_string(concatStr.toString());

        return response;
    }
}
