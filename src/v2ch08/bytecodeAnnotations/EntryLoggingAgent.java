package v2ch08.bytecodeAnnotations;

import java.lang.instrument.*;

import jdk.internal.org.objectweb.asm.*;

/**
 * @author Cay Horstmann
 * @version 1.10 2016-05-10
 */
public class EntryLoggingAgent {

    public static void premain(final String arg, Instrumentation instr) {
        instr.addTransformer((loader, className, cl, pd, data) ->
                             {
                                 if (!className.replace("/", ".").equals(arg)) return null;
                                 ClassReader reader = new ClassReader(data);
                                 ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
                                 EntryLogger el = new EntryLogger(writer, className);
                                 reader.accept(el, ClassReader.EXPAND_FRAMES);
                                 return writer.toByteArray();
                             });
    }
}