package com.spiNN4j.runner

import org.codehaus.groovy.control.CompilerConfiguration;

/**
 * Created by Grzegorz Borowik on 2016-06-14 3:06 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class MainRunner {
    public static void main(String[] args) {
        def configuration = new CompilerConfiguration()
        configuration.setScriptBaseClass("com.spiNN4j.RunnableScript")
        def shell = new GroovyShell(this.class.classLoader, new Binding(), configuration)
        shell.evaluate(new File(args[0]))
    }
}
