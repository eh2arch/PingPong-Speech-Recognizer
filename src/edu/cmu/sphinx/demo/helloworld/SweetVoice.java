/*
 * Copyright 1999-2004 Carnegie Mellon University.
 * Portions Copyright 2004 Sun Microsystems, Inc.
 * Portions Copyright 2004 Mitsubishi Electric Research Laboratories.
 * All Rights Reserved.  Use is subject to license terms.
 *
 * See the file "license.terms" for information on usage and
 * redistribution of this file, and for a DISCLAIMER OF ALL
 * WARRANTIES.
 *
 */

package edu.cmu.sphinx.demo.helloworld;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import javax.swing.JOptionPane;


/**
 * A simple HelloWorld demo showing a simple speech application built using Sphinx-4. This application uses the Sphinx-4
 * endpointer, which automatically segments incoming audio into utterances and silences.
 */
public class SweetVoice {
    
    public String getWords() {
        ConfigurationManager cm;
        cm = new ConfigurationManager(SweetVoice.class.getResource("helloworld.config.xml"));

        Recognizer recognizer = (Recognizer) cm.lookup("recognizer");
        recognizer.allocate();

        // start the microphone or exit if the programm if this is not possible
        Microphone microphone = (Microphone) cm.lookup("microphone");
        if (!microphone.startRecording()) {
            System.out.println("Cannot start microphone.");
            recognizer.deallocate();
            System.exit(1);
        }
        JOptionPane.showMessageDialog(null,"Start Speaking.");
        // loop the recognition until the programm exits.
//        while (true) {
            Result result = recognizer.recognize();
            String res = " ";
            if (result != null) {
                String resultText = result.getBestFinalResultNoFiller();             
                res = resultText;
            } else {
//                System.out.println("I can't hear what you said.\n");
                res = "I can't hear what you said.";
            }
//        }
          return res;

    }

    public static void main(String[] args) {
    }
}
