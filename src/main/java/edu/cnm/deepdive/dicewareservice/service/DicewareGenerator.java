package edu.cnm.deepdive.dicewareservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DicewareGenerator implements PassphraseGenerator {


  final private Random random;
  final private List<String> words;

  @Autowired
  public DicewareGenerator(Random random, List<String> words) {
    this.random = random;
    this.words = new ArrayList<>(words);
  }


  @Override
  public String[] passphrase(int length) {

    return IntStream.generate(() -> random.nextInt(words.size())).limit(length).mapToObj(words::get)
        .toArray(String[]::new);
  }
}
