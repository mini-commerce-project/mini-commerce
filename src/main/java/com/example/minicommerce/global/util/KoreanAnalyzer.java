package com.example.minicommerce.global.util;

import org.openkoreantext.processor.OpenKoreanTextProcessorJava;
import org.openkoreantext.processor.tokenizer.KoreanTokenizer;
import org.springframework.stereotype.Component;

import scala.collection.Seq;

@Component
public class KoreanAnalyzer {
    public static String analyze(String text) {
        CharSequence normalized = OpenKoreanTextProcessorJava.normalize(text);

        Seq<KoreanTokenizer.KoreanToken> tokens =
            OpenKoreanTextProcessorJava.tokenize(normalized);

        return String.join(" ", OpenKoreanTextProcessorJava.tokensToJavaStringList(tokens));
    }
}
