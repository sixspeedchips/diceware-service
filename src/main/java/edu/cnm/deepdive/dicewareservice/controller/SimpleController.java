package edu.cnm.deepdive.dicewareservice.controller;

import edu.cnm.deepdive.dicewareservice.service.PassphraseGenerator;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/generator")

public class SimpleController {

  private final PassphraseGenerator generator;

  @Autowired
  public SimpleController(PassphraseGenerator generator) {
    this.generator = generator;
  }

  @ResponseBody
  @GetMapping(produces = "application/json")
  public String[] getJson(
      @RequestParam(value = "length", defaultValue = "6") int length){
    return generator.passphrase(length);
  }


//  @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
//  public String getPage(@RequestParam(value = "length", defaultValue = "6") int length, Model model){
//    model.addAttribute("words", getJson(length));
//    return "generator";
//  }

  @ResponseBody
  @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
  public String getString(@RequestParam(value = "length", defaultValue = "6") int length){
    return Arrays.stream(getJson(length)).map(String::toUpperCase).collect(Collectors.joining(" "));
  }


}
