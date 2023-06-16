package com.example.StackQuestionsSolve.duplicateStackProblem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Stack;
@RestController
public class DuplicateStackProblem {

    @GetMapping("/isDuplicateBracket")
    public boolean isDuplicateBracket(@RequestParam final String string){
        char[] charArray = string.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<charArray.length;i++){
            switch (charArray[i]){
                case')':

                    if(stack.peek().equals(')')){
                        return false;
                    }else {
                        while (stack.peek() != '('){
                            stack.pop();
                        }
                        stack.pop();
                    }
                    break;
                default: stack.push(charArray[i]);
            }
        }
        if(stack.isEmpty()){
            return false;
        }else {
            return true;
        }
    }
}
