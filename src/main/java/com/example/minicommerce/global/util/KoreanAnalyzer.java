package com.example.minicommerce.global.util;

import org.openkoreantext.processor.OpenKoreanTextProcessorJava;
import org.openkoreantext.processor.tokenizer.KoreanTokenizer;
import org.springframework.stereotype.Component;

import scala.collection.Seq;

@Component
public class KoreanAnalyzer {
    public static String analyze(String text) {
        if (text == null) return null;

        CharSequence normalized = OpenKoreanTextProcessorJava.normalize(text);

        Seq<KoreanTokenizer.KoreanToken> tokens =
            OpenKoreanTextProcessorJava.tokenize(normalized);

        return OpenKoreanTextProcessorJava.tokensToJavaStringList(tokens).stream()
            .map(token -> "+" + token)
            .reduce((a, b) -> a + " " + b)
            .orElse("");
    }
}
