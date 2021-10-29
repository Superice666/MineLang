package me.minelang.tests.language;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.Value;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class ParserTest {
    private Engine engine = null;

    public Value eval(String code) {
        engine = engine == null ? Engine.newBuilder().build() : engine;
        var ctx = Context.newBuilder().engine(engine).build();
        return ctx.eval("MineLang", code);
    }

    @Test
    public void testParse1() {
        Assert.assertEquals("result: 34.5", eval("""
                a = 10 + 24.5
                b = a = 'result: ' + a
                b
                """).toString());
    }

    @Test
    public void testParse2() {
        Assert.assertEquals(16f, eval("""
                a = (1 + 2) * 3 / 2
                b = a / 0.25
                b
                """).asFloat(), 0.0001f);
    }

    @Test
    public void testParse3() {
        Assert.assertEquals("a: 9.0; b: 10.0", eval("""
                a = (1 + 2) * 4.5
                b = (a = a / 1.5) + 1
                "a: " + a + '; b: ' + b
                """).toString());
    }

    @Test
    public void testParse4() {
        var codes = new String[100];
        var random = new Random();
        for (var i = 0; i < 100; i++) {
            codes[i] = """
                    a = (%d + %d) * %f
                    b = (a = a / %f) + %d
                    "a: " + a + '; b: ' + b
                    """.formatted(random.nextInt(), random.nextInt(), random.nextFloat(), random.nextFloat(), random.nextInt());
        }
        long start = System.currentTimeMillis();
        for (var i = 0; i < 100; i++) {
            eval(codes[i]);
        }
        long end = System.currentTimeMillis();

        System.out.println("Time average: " + (end - start) / 100.0 + "ms");
    }

    @Test
    public void testParse5() {
        Assert.assertEquals(5.1f, eval("""
                a = {1.70 * 3}
                a
                """).asFloat(), 0.00001f);
    }

    @Test
    public void testParse6() {
        Assert.assertEquals(5.1f, eval("""
                a = {
                    b = 1.70
                    b * 3
                }
                a
                """).asFloat(), 0.00001f);
    }

    @Test
    public void testParse7() {
        Assert.assertEquals("c: none", eval("""
                b = 22.33
                a = {
                    c = b
                    b = 1.70
                    b * 3
                    'c: ' + c
                }
                a
                """).toString());
    }
}
